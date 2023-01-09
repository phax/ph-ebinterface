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

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.annotation.Nonnull;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.dom.DOMSignContext;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.io.file.SimpleFileIO;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.ebinterface.EbInterface43NamespaceContext;
import com.helger.ebinterface.builder.EbInterfaceReader;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.write.XMLWriter;
import com.helger.xml.serialize.write.XMLWriterSettings;
import com.helger.xmldsig.XMLDSigCreator;
import com.helger.xmldsig.XMLDSigSetup;
import com.helger.xmldsig.XMLDSigValidator;

/**
 * Test class for class {@link XMLDSigValidator}
 *
 * @author Philip Helger
 */
public final class SignatureCreationFuncTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (SignatureCreationFuncTest.class);

  private static final class Ebi43Signer extends XMLDSigCreator
  {
    public void signEbInterface (@Nonnull final PrivateKey aPrivateKey,
                                 @Nonnull final X509Certificate aCertificate,
                                 @Nonnull final Document aDocument) throws Exception
    {
      ValueEnforcer.notNull (aPrivateKey, "privateKey");
      ValueEnforcer.notNull (aCertificate, "certificate");
      ValueEnforcer.notNull (aDocument, "document");
      ValueEnforcer.notNull (aDocument.getDocumentElement (), "Document is missing a document element");
      if (aDocument.getDocumentElement ().getChildNodes ().getLength () == 0)
        throw new IllegalArgumentException ("Document element has no children!");

      // Check that the document does not contain another Signature element
      final NodeList aNodeList = aDocument.getElementsByTagNameNS (XMLSignature.XMLNS, XMLDSigSetup.ELEMENT_SIGNATURE);
      if (aNodeList.getLength () > 0)
        throw new IllegalArgumentException ("Document already contains an XMLDSig Signature element!");

      // Create the XMLSignature, but don't sign it yet.
      final XMLSignature aXMLSignature = createXMLSignature (aCertificate);

      // In Ebi 4.3 the Signature is the first child element of the root
      final DOMSignContext aDOMSignContext = new DOMSignContext (aPrivateKey,
                                                                 aDocument.getDocumentElement (),
                                                                 aDocument.getDocumentElement ().getFirstChild ());

      // The namespace prefix to be used for the signed XML
      aDOMSignContext.setDefaultNamespacePrefix (DEFAULT_NS_PREFIX);

      // Marshal, generate, and sign the enveloped signature.
      aXMLSignature.sign (aDOMSignContext);
    }
  }

  @Test
  public void testMe () throws Exception
  {
    final Document aDoc = DOMReader.readXMLDOM (new FileSystemResource ("src/test/resources/ebinterface/v43/testinstance-valid-schema.xml"));
    assertNotNull (aDoc);
    final Ebi43InvoiceType aOriginalInvoice = EbInterfaceReader.ebInterface43 ().read (aDoc);
    assertNotNull (aOriginalInvoice);

    // Create cert
    final KeyPair aRootKey = CreateCertHelper.genRSAKeyPair ();
    final X509Certificate aRootCert = CreateCertHelper.generateSelfSignedRootCertificate (aRootKey,
                                                                                          "SignedEbiTest",
                                                                                          "futuretrust.eu",
                                                                                          "EU",
                                                                                          CreateCertHelper.plusDays (999));

    new Ebi43Signer ().signEbInterface (aRootKey.getPrivate (), aRootCert, aDoc);

    LOGGER.info ("Created signed ebi 4.3 file");

    if (false)
      SimpleFileIO.writeFile (new File ("ebi43-signed-ft.xml"),
                              XMLWriter.getNodeAsBytes (aDoc,
                                                        new XMLWriterSettings ().setNamespaceContext (EbInterface43NamespaceContext.getInstance ())));

    // Now check if the Ebi is still valid
    final Ebi43InvoiceType aSignedInvoice = EbInterfaceReader.ebInterface43 ().read (aDoc);
    assertNotNull (aSignedInvoice);
  }
}
