/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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

import java.io.File;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.io.file.FileHelper;
import com.helger.ebinterface.signature.CreateCertHelper.ECertType;
import com.helger.security.keystore.EKeyStoreType;

/**
 * <b>DO NOT EXECUTE THIS</b><br>
 * Handle with care - needed once only :)<br>
 * This class creates the TOOP playground CA. It is a certificate hierarchy with
 * a self-signed root certificate (CN=playground-root) and a set of derived
 * child certificates.
 *
 * @author Philip Helger
 */
public final class MainCreateExamplePKI
{
  private static final Logger LOGGER = LoggerFactory.getLogger (MainCreateExamplePKI.class);

  public static void main (final String [] args) throws Exception
  {
    Security.addProvider (CreateCertHelper.PROVIDER);
    final String sPassword = "fink";
    final String sOrganization = "FINK-Lab";
    final String sCountry = "DE";

    // Start the key and trust store
    final KeyStore aKS = EKeyStoreType.JKS.getKeyStore ();
    aKS.load (null, null);
    final KeyStore aTS = EKeyStoreType.JKS.getKeyStore ();
    aTS.load (null, null);

    // Root stuff
    final String sRootCN = "FINK-Lab-Root";
    final KeyPair aRootKey = CreateCertHelper.genRSAKeyPair ();
    final X509Certificate aRootCert = CreateCertHelper.generateSelfSignedRootCertificate (aRootKey,
                                                                                          sRootCN,
                                                                                          sOrganization,
                                                                                          sCountry,
                                                                                          CreateCertHelper.plusDays (9999));
    {
      aKS.setKeyEntry ("root-key", aRootKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aRootCert });
      aTS.setCertificateEntry ("root-cert", aRootCert);
    }

    // add AS4 CA
    final String sAS4CN = "as4-ca";
    final KeyPair aAS4RootKey;
    final X509Certificate aAS4RootCert;
    {
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      aAS4RootKey = CreateCertHelper.genRSAKeyPair ();
      aAS4RootCert = CreateCertHelper.generateSignedCertificate (aRootKey,
                                                                 aRootCert,
                                                                 aAS4RootKey,
                                                                 sAS4CN,
                                                                 sOrganization,
                                                                 sCountry,
                                                                 aNotAfter,
                                                                 ECertType.CA_SUB);

      // Add to keystore
      aKS.setKeyEntry (sAS4CN, aAS4RootKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aAS4RootCert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sAS4CN, aAS4RootCert);
    }

    // add SMP CA
    final String sSMPCN = "smp-ca";
    final KeyPair aSMPRootKey;
    final X509Certificate aSMPRootCert;
    {
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      aSMPRootKey = CreateCertHelper.genRSAKeyPair ();
      aSMPRootCert = CreateCertHelper.generateSignedCertificate (aRootKey,
                                                                 aRootCert,
                                                                 aSMPRootKey,
                                                                 sSMPCN,
                                                                 sOrganization,
                                                                 sCountry,
                                                                 aNotAfter,
                                                                 ECertType.CA_SUB);

      // Add to keystore
      aKS.setKeyEntry (sSMPCN, aSMPRootKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aSMPRootCert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sSMPCN, aSMPRootCert);
    }

    // all AS4 certificates
    for (int i = 1; i <= 5; ++i)
    {
      final String sCertName = "as4-" + i;
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      final KeyPair aAS4Key = CreateCertHelper.genRSAKeyPair ();
      final X509Certificate aAS4Cert = CreateCertHelper.generateSignedCertificate (aAS4RootKey,
                                                                                   aAS4RootCert,
                                                                                   aAS4Key,
                                                                                   sCertName,
                                                                                   sOrganization,
                                                                                   sCountry,
                                                                                   aNotAfter,
                                                                                   ECertType.CERTIFICATE);

      // Add to keystore
      aKS.setKeyEntry (sCertName + "-key",
                       aAS4Key.getPrivate (),
                       sPassword.toCharArray (),
                       new Certificate [] { aAS4Cert, aAS4RootCert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sCertName + "-cert", aAS4Cert);
    }

    // all SMP certificates
    for (final String sCertName : new String [] { "fink-smp" })
    {
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      final KeyPair aSMPKey = CreateCertHelper.genRSAKeyPair ();
      final X509Certificate aSMPCert = CreateCertHelper.generateSignedCertificate (aSMPRootKey,
                                                                                   aSMPRootCert,
                                                                                   aSMPKey,
                                                                                   sCertName,
                                                                                   sOrganization,
                                                                                   sCountry,
                                                                                   aNotAfter,
                                                                                   ECertType.CERTIFICATE);

      // Add to keystore
      aKS.setKeyEntry (sCertName + "-key",
                       aSMPKey.getPrivate (),
                       sPassword.toCharArray (),
                       new Certificate [] { aSMPCert, aSMPRootCert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sCertName + "-cert", aSMPCert);
    }

    // Write to file
    aKS.store (FileHelper.getOutputStream (new File ("fink-lab-keystore.jks")), sPassword.toCharArray ());
    aTS.store (FileHelper.getOutputStream (new File ("fink-lab-truststore.jks")), sPassword.toCharArray ());

    LOGGER.info ("Done creating keys and writing key store");
  }
}
