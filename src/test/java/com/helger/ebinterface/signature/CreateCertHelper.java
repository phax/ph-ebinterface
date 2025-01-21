/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.annotation.Nonnull;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import com.helger.bc.PBCProvider;
import com.helger.commons.CGlobal;
import com.helger.commons.annotation.Nonempty;

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

  @Nonnull
  public static X509Certificate generateSelfSignedRootCertificate (@Nonnull final KeyPair aSubjectKP,
                                                                   @Nonnull @Nonempty final String sCommonName,
                                                                   @Nonnull @Nonempty final String sOrganization,
                                                                   @Nonnull @Nonempty final String sCountry,
                                                                   @Nonnull final Date aNotAfter) throws Exception
  {
    final X500Name aSubjectName = x500 (sCommonName, sOrganization, sCountry);
    final X500Name aIssuerName = aSubjectName;
    final X509v3CertificateBuilder aCertBuilder = new JcaX509v3CertificateBuilder (aIssuerName,
                                                                                   new BigInteger (64,
                                                                                                   SecureRandom.getInstanceStrong ()),
                                                                                   now (),
                                                                                   aNotAfter,
                                                                                   aSubjectName,
                                                                                   aSubjectKP.getPublic ());
    {
      // Since no CSR is used, the extensions need to be applied immediately
      final JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils ();
      aCertBuilder.addExtension (Extension.subjectKeyIdentifier,
                                 false,
                                 extUtils.createSubjectKeyIdentifier (aSubjectKP.getPublic ()));
      aCertBuilder.addExtension (Extension.basicConstraints, true, new BasicConstraints (1));
      aCertBuilder.addExtension (Extension.keyUsage, true, new KeyUsage (KeyUsage.keyCertSign | KeyUsage.cRLSign));
    }

    final ContentSigner aSigner = new JcaContentSignerBuilder (SIGNING_ALGO).setProvider (PROVIDER)
                                                                            .build (aSubjectKP.getPrivate ());
    final X509CertificateHolder certHolder = aCertBuilder.build (aSigner);

    final X509Certificate ret = new JcaX509CertificateConverter ().setProvider (PROVIDER).getCertificate (certHolder);
    ret.verify (aSubjectKP.getPublic ());

    return ret;
  }
}
