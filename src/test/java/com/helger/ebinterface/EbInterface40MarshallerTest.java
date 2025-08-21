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
package com.helger.ebinterface;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.io.resource.IReadableResource;
import com.helger.unittest.support.TestHelper;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xmldsig.XMLDSigValidationResult;
import com.helger.xmldsig.XMLDSigValidator;

/**
 * Test class for class {@link EbInterface40Marshaller}.
 *
 * @author Philip Helger
 */
public final class EbInterface40MarshallerTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (EbInterface40MarshallerTest.class);

  @Test
  public void testReadValid ()
  {
    final EbInterface40Marshaller aMarshaller = new EbInterface40Marshaller ();

    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V40.getTestResources ())
    {
      if (false)
        LOGGER.info ("Reading: " + aExampleFile.getPath ());

      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi40InvoiceType aInvoice = aMarshaller.read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      TestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = aMarshaller.getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V40,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi40InvoiceType aInvoice2 = aMarshaller.read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);

      // Must be equals
      TestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testValidateSignature () throws Exception
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V40.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      if (XMLDSigValidator.containsSignature (aDoc))
      {
        LOGGER.info (aExampleFile.getPath ());
        final XMLDSigValidationResult aSVR = XMLDSigValidator.validateSignature (aDoc);
        assertNotNull (aSVR);
      }
    }
  }
}
