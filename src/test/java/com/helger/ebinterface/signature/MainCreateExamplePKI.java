package com.helger.ebinterface.signature;

import java.io.File;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.io.file.FileHelper;
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
    final X509Certificate aRootCert = CreateCertHelper.generateCertificate (sRootCN,
                                                                            sOrganization,
                                                                            sCountry,
                                                                            aRootKey,
                                                                            CreateCertHelper.plusDays (9999));
    {
      aKS.setKeyEntry ("root-key", aRootKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aRootCert });
      aTS.setCertificateEntry ("root-cert", aRootCert);
    }

    // add AS4 CA
    final String sAS4CN = "as4";
    final KeyPair aAS4Key;
    final X509Certificate aAS4Cert;
    {
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      aAS4Key = CreateCertHelper.genRSAKeyPair ();
      final X509Certificate aCert = CreateCertHelper.generateCertificate (sAS4CN, sOrganization, sCountry, aAS4Key, aNotAfter);
      final PKCS10CertificationRequest aCSR = CreateCertHelper.createCSR (aCert, aAS4Key);
      aAS4Cert = CreateCertHelper.signCSR (aCSR, aRootKey.getPrivate (), aAS4Key, sRootCN, sOrganization, sCountry, aNotAfter);

      // Add to keystore
      aKS.setKeyEntry (sAS4CN + "-ca", aAS4Key.getPrivate (), sPassword.toCharArray (), new Certificate [] { aAS4Cert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sAS4CN + "-ca", aAS4Cert);
    }

    // add SMP CA
    final String sSMPCN = "smp";
    final KeyPair aSMPKey;
    final X509Certificate aSMPCert;
    {
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      aSMPKey = CreateCertHelper.genRSAKeyPair ();
      final X509Certificate aCert = CreateCertHelper.generateCertificate (sSMPCN, sOrganization, sCountry, aSMPKey, aNotAfter);
      final PKCS10CertificationRequest aCSR = CreateCertHelper.createCSR (aCert, aSMPKey);
      aSMPCert = CreateCertHelper.signCSR (aCSR, aRootKey.getPrivate (), aSMPKey, sRootCN, sOrganization, sCountry, aNotAfter);

      // Add to keystore
      aKS.setKeyEntry (sSMPCN + "-ca", aSMPKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aSMPCert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sSMPCN + "-ca", aSMPCert);
    }

    // all AS4 certificates
    for (int i = 1; i <= 5; ++i)
    {
      final String sCertName = "as4-" + i;
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      final KeyPair aKey = CreateCertHelper.genRSAKeyPair ();
      X509Certificate aCert = CreateCertHelper.generateCertificate (sCertName, sOrganization, sCountry, aKey, aNotAfter);
      final PKCS10CertificationRequest aCSR = CreateCertHelper.createCSR (aCert, aKey);
      aCert = CreateCertHelper.signCSR (aCSR, aAS4Key.getPrivate (), aKey, sAS4CN, sOrganization, sCountry, aNotAfter);

      // Add to keystore
      aKS.setKeyEntry (sCertName + "-key", aKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aCert, aAS4Cert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sCertName + "-cert", aCert);
    }

    // all SMP certificates
    for (final String sCertName : new String [] { "fink-smp" })
    {
      final Date aNotAfter = CreateCertHelper.plusDays (9999);
      final KeyPair aKey = CreateCertHelper.genRSAKeyPair ();
      X509Certificate aCert = CreateCertHelper.generateCertificate (sCertName, sOrganization, sCountry, aKey, aNotAfter);
      final PKCS10CertificationRequest aSMPCSR = CreateCertHelper.createCSR (aCert, aKey);
      aCert = CreateCertHelper.signCSR (aSMPCSR, aSMPKey.getPrivate (), aKey, sSMPCN, sOrganization, sCountry, aNotAfter);

      // Add to keystore
      aKS.setKeyEntry (sCertName + "-key", aKey.getPrivate (), sPassword.toCharArray (), new Certificate [] { aCert, aRootCert });
      // Add to truststore
      aTS.setCertificateEntry (sCertName + "-cert", aSMPCert);
    }

    // Write to file
    aKS.store (FileHelper.getOutputStream (new File ("fink-lab-keystore.jks")), sPassword.toCharArray ());
    aTS.store (FileHelper.getOutputStream (new File ("fink-lab-truststore.jks")), sPassword.toCharArray ());

    LOGGER.info ("Done creating keys and writing key store");
  }
}
