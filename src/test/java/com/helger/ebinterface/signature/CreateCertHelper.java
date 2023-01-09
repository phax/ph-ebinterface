/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.ebinterface.signature;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.annotation.Nonnull;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

import com.helger.bc.PBCProvider;
import com.helger.commons.CGlobal;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.io.stream.NonBlockingByteArrayInputStream;

/**
 * <b>DO NOT EXECUTE THIS</b><br>
 * Handle with care - needed once only :)<br>
 * This class creates the TOOP playground CA. It is a certificate hierarchy with
 * a self-signed root certificate (CN=playground-root) and a set of derived
 * child certificates.
 *
 * @author Philip Helger
 */
public final class CreateCertHelper
{
  public static final Provider PROVIDER = PBCProvider.getProvider ();
  private static final int RSA_KEY_LEN = 2048;
  private static final String SIGNING_ALGO = "SHA256WithRSAEncryption";

  private CreateCertHelper ()
  {}

  @Nonnull
  public static Date now ()
  {
    return new Date (System.currentTimeMillis ());
  }

  @Nonnull
  public static Date plusDays (final long nDays)
  {
    return new Date (System.currentTimeMillis () + nDays * 24 * CGlobal.MILLISECONDS_PER_HOUR);
  }

  @Nonnull
  public static X500Name x500 (@Nonnull @Nonempty final String sCommonName,
                               @Nonnull @Nonempty final String sOrganization,
                               @Nonnull @Nonempty final String sCountry)
  {
    return new X500Name ("CN=" + sCommonName + ", O=" + sOrganization + ", C=" + sCountry);
  }

  @Nonnull
  public static KeyPair genRSAKeyPair () throws NoSuchAlgorithmException
  {
    // Get RSA key factory:
    final KeyPairGenerator kpg = KeyPairGenerator.getInstance ("RSA", PROVIDER);
    // Generate RSA public/private key pair:
    kpg.initialize (RSA_KEY_LEN);
    return kpg.genKeyPair ();
  }

  public static enum ECertType
  {
    CA_ROOT (KeyUsage.keyCertSign | KeyUsage.cRLSign, true, 1),
    CA_SUB (KeyUsage.keyCertSign | KeyUsage.cRLSign, true, 0),
    CERTIFICATE (KeyUsage.digitalSignature | KeyUsage.keyEncipherment | KeyUsage.keyAgreement, false, -1);

    private final int m_nKeyUsage;
    private final boolean m_bIsCA;
    private final int m_nCertPathLen;

    ECertType (final int n, final boolean bIsCA, final int nCertPathLen)
    {
      m_nKeyUsage = n;
      m_bIsCA = bIsCA;
      m_nCertPathLen = nCertPathLen;
    }

    @Nonnull
    public KeyUsage getKeyUsage ()
    {
      return new KeyUsage (m_nKeyUsage);
    }

    @Nonnull
    public BasicConstraints getBasicConstraints ()
    {
      return m_bIsCA ? new BasicConstraints (m_nCertPathLen) : new BasicConstraints (false);
    }
  }

  @Nonnull
  public static X509Certificate generateSelfSignedRootCertificate (@Nonnull final KeyPair aSubjectKP,
                                                                   @Nonnull @Nonempty final String sCommonName,
                                                                   @Nonnull @Nonempty final String sOrganization,
                                                                   @Nonnull @Nonempty final String sCountry,
                                                                   @Nonnull final Date aNotAfter) throws Exception
  {
    final ECertType eCertType = ECertType.CA_ROOT;
    final X500Name aSubjectName = x500 (sCommonName, sOrganization, sCountry);
    final X500Name aIssuerName = aSubjectName;
    final X509v3CertificateBuilder aCertBuilder = new JcaX509v3CertificateBuilder (aIssuerName,
                                                                                   new BigInteger (64, SecureRandom.getInstanceStrong ()),
                                                                                   now (),
                                                                                   aNotAfter,
                                                                                   aSubjectName,
                                                                                   aSubjectKP.getPublic ());
    {
      // Since no CSR is used, the extensions need to be applied immediately
      final JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils ();
      aCertBuilder.addExtension (Extension.subjectKeyIdentifier, false, extUtils.createSubjectKeyIdentifier (aSubjectKP.getPublic ()));
      aCertBuilder.addExtension (Extension.basicConstraints, true, eCertType.getBasicConstraints ());
      aCertBuilder.addExtension (Extension.keyUsage, true, eCertType.getKeyUsage ());
    }

    final ContentSigner aSigner = new JcaContentSignerBuilder (SIGNING_ALGO).setProvider (PROVIDER).build (aSubjectKP.getPrivate ());
    final X509CertificateHolder certHolder = aCertBuilder.build (aSigner);

    final X509Certificate ret = new JcaX509CertificateConverter ().setProvider (PROVIDER).getCertificate (certHolder);
    ret.verify (aSubjectKP.getPublic ());

    return ret;
  }

  @Nonnull
  public static X509Certificate generateCertificate (@Nonnull final X509Certificate aIssuerCert,
                                                     @Nonnull final KeyPair aSubjectKP,
                                                     @Nonnull @Nonempty final String sCommonName,
                                                     @Nonnull @Nonempty final String sOrganization,
                                                     @Nonnull @Nonempty final String sCountry,
                                                     @Nonnull final Date aNotAfter) throws Exception
  {
    // Prepare the information required for generating an X.509 certificate.
    final X500Name aSubjectName = x500 (sCommonName, sOrganization, sCountry);
    final X500Name aIssuerName = X500Name.getInstance (aIssuerCert.getSubjectX500Principal ().getEncoded ());
    final X509v3CertificateBuilder aCertBuilder = new JcaX509v3CertificateBuilder (aIssuerName,
                                                                                   new BigInteger (64, SecureRandom.getInstanceStrong ()),
                                                                                   now (),
                                                                                   aNotAfter,
                                                                                   aSubjectName,
                                                                                   aSubjectKP.getPublic ());
    // No Extensions here - they are added with the signed CSR

    final ContentSigner aSigner = new JcaContentSignerBuilder (SIGNING_ALGO).setProvider (PROVIDER).build (aSubjectKP.getPrivate ());
    final X509CertificateHolder certHolder = aCertBuilder.build (aSigner);

    final X509Certificate ret = new JcaX509CertificateConverter ().setProvider (PROVIDER).getCertificate (certHolder);
    ret.verify (aSubjectKP.getPublic ());

    return ret;
  }

  @Nonnull
  public static PKCS10CertificationRequest createCSR (@Nonnull final X509Certificate cert,
                                                      @Nonnull final KeyPair aIssuerKP) throws Exception
  {
    final Principal principal = cert.getSubjectX500Principal ();
    // generate certification request
    final X500Name x500Name = new X500Name (principal.toString ());
    final PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder (x500Name, aIssuerKP.getPublic ());

    final ContentSigner signer = new JcaContentSignerBuilder (SIGNING_ALGO).build (aIssuerKP.getPrivate ());
    return p10Builder.build (signer);
  }

  @Nonnull
  public static X509Certificate signCSR (@Nonnull final KeyPair aIssuerKP,
                                         @Nonnull final X509Certificate aIssuerCert,
                                         @Nonnull final PKCS10CertificationRequest inputCSR,
                                         @Nonnull final KeyPair aSubjectKP,
                                         @Nonnull final Date aNotAfter,
                                         @Nonnull final ECertType eCertType) throws Exception
  {

    final AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder ().find (SIGNING_ALGO);
    final AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder ().find (sigAlgId);

    final SubjectPublicKeyInfo aSubjectPubKeyInfo = SubjectPublicKeyInfo.getInstance (aSubjectKP.getPublic ().getEncoded ());

    final X509v3CertificateBuilder aCertBuilder = new X509v3CertificateBuilder (X500Name.getInstance (aIssuerCert.getSubjectX500Principal ()
                                                                                                                 .getEncoded ()),
                                                                                new BigInteger (64, SecureRandom.getInstanceStrong ()),
                                                                                now (),
                                                                                aNotAfter,
                                                                                inputCSR.getSubject (),
                                                                                aSubjectPubKeyInfo);
    {
      final JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils ();
      aCertBuilder.addExtension (Extension.subjectKeyIdentifier, false, extUtils.createSubjectKeyIdentifier (aSubjectKP.getPublic ()));
      aCertBuilder.addExtension (Extension.authorityKeyIdentifier, false, extUtils.createAuthorityKeyIdentifier (aIssuerKP.getPublic ()));
      aCertBuilder.addExtension (Extension.basicConstraints, true, eCertType.getBasicConstraints ());
      aCertBuilder.addExtension (Extension.keyUsage, true, eCertType.getKeyUsage ());
    }

    final AsymmetricKeyParameter foo = PrivateKeyFactory.createKey (aIssuerKP.getPrivate ().getEncoded ());
    final ContentSigner sigGen = new BcRSAContentSignerBuilder (sigAlgId, digAlgId).build (foo);

    final X509CertificateHolder holder = aCertBuilder.build (sigGen);

    final org.bouncycastle.asn1.x509.Certificate eeX509CertificateStructure = holder.toASN1Structure ();

    // Read Certificate
    try (final InputStream is1 = new NonBlockingByteArrayInputStream (eeX509CertificateStructure.getEncoded (), false))
    {
      final CertificateFactory cf = CertificateFactory.getInstance ("X.509", PROVIDER);
      final X509Certificate theCert = (X509Certificate) cf.generateCertificate (is1);
      return theCert;
    }
  }

  @Nonnull
  public static X509Certificate generateSignedCertificate (@Nonnull final KeyPair aIssuerKP,
                                                           @Nonnull final X509Certificate aIssuerCert,
                                                           @Nonnull final KeyPair aSubjectKP,
                                                           @Nonnull @Nonempty final String sCommonName,
                                                           @Nonnull @Nonempty final String sOrganization,
                                                           @Nonnull @Nonempty final String sCountry,
                                                           @Nonnull final Date aNotAfter,
                                                           @Nonnull final ECertType eCertType) throws Exception
  {
    final X509Certificate aCert = generateCertificate (aIssuerCert, aSubjectKP, sCommonName, sOrganization, sCountry, aNotAfter);
    final PKCS10CertificationRequest aCSR = createCSR (aCert, aIssuerKP);
    return CreateCertHelper.signCSR (aIssuerKP, aIssuerCert, aCSR, aSubjectKP, aNotAfter, eCertType);
  }
}
