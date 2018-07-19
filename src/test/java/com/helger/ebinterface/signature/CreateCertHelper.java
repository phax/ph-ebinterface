/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.annotation.Nonnull;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
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
  private static final Provider PROVIDER = PBCProvider.getProvider ();
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

  @Nonnull
  public static X509Certificate generateCertificate (@Nonnull @Nonempty final String sCommonName,
                                                     @Nonnull @Nonempty final String sOrganization,
                                                     @Nonnull @Nonempty final String sCountry,
                                                     @Nonnull final KeyPair keypair,
                                                     @Nonnull final Date notAfter) throws Exception
  {
    final PrivateKey key = keypair.getPrivate ();
    // Prepare the information required for generating an X.509 certificate.
    final X500Name owner = x500 (sCommonName, sOrganization, sCountry);
    final X509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder (owner,
                                                                              new BigInteger (64,
                                                                                              SecureRandom.getInstanceStrong ()),
                                                                              now (),
                                                                              notAfter,
                                                                              owner,
                                                                              keypair.getPublic ());

    final ContentSigner signer = new JcaContentSignerBuilder (SIGNING_ALGO).build (key);
    final X509CertificateHolder certHolder = builder.build (signer);
    final X509Certificate cert = new JcaX509CertificateConverter ().setProvider (PROVIDER).getCertificate (certHolder);
    cert.verify (keypair.getPublic ());

    return cert;
  }

  @Nonnull
  public static PKCS10CertificationRequest createCSR (final X509Certificate cert,
                                                      final KeyPair keyPair) throws Exception
  {
    final Principal principal = cert.getSubjectDN ();
    // generate certification request
    final X500Name x500Name = new X500Name (principal.toString ());
    final PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder (x500Name,
                                                                                                   keyPair.getPublic ());
    final JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder (SIGNING_ALGO);
    final ContentSigner signer = csBuilder.build (keyPair.getPrivate ());
    return p10Builder.build (signer);
  }

  @Nonnull
  public static X509Certificate signCSR (final PKCS10CertificationRequest inputCSR,
                                         final PrivateKey caPrivate,
                                         final KeyPair pair,
                                         @Nonnull @Nonempty final String sRootCommonName,
                                         @Nonnull @Nonempty final String sRootOrganization,
                                         @Nonnull @Nonempty final String sRootCountry,
                                         final Date notAfter) throws Exception
  {

    final AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder ().find (SIGNING_ALGO);
    final AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder ().find (sigAlgId);

    final AsymmetricKeyParameter foo = PrivateKeyFactory.createKey (caPrivate.getEncoded ());
    final SubjectPublicKeyInfo keyInfo = SubjectPublicKeyInfo.getInstance (pair.getPublic ().getEncoded ());

    final X509v3CertificateBuilder myCertificateGenerator = new X509v3CertificateBuilder (x500 (sRootCommonName,
                                                                                                sRootOrganization,
                                                                                                sRootCountry),
                                                                                          new BigInteger (64,
                                                                                                          SecureRandom.getInstanceStrong ()),
                                                                                          now (),
                                                                                          notAfter,
                                                                                          inputCSR.getSubject (),
                                                                                          keyInfo);

    final ContentSigner sigGen = new BcRSAContentSignerBuilder (sigAlgId, digAlgId).build (foo);

    final X509CertificateHolder holder = myCertificateGenerator.build (sigGen);

    final org.bouncycastle.asn1.x509.Certificate eeX509CertificateStructure = holder.toASN1Structure ();

    // Read Certificate
    try (final InputStream is1 = new NonBlockingByteArrayInputStream (eeX509CertificateStructure.getEncoded (), false))
    {
      final CertificateFactory cf = CertificateFactory.getInstance ("X.509", PROVIDER);
      final X509Certificate theCert = (X509Certificate) cf.generateCertificate (is1);
      return theCert;
    }
  }
}
