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

import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xmldsig.XMLDSigValidationResult;
import com.helger.xmldsig.XMLDSigValidator;

/**
 * Test class for class {@link EbInterface43Marshaller}.
 *
 * @author Philip Helger
 */
public final class EbInterface43MarshallerTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (EbInterface43MarshallerTest.class);

  @Test
  public void testReadValid ()
  {
    final EbInterface43Marshaller aMarshaller = new EbInterface43Marshaller ();

    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V43.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi43InvoiceType aInvoice = aMarshaller.read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = aMarshaller.getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V43,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi43InvoiceType aInvoice2 = aMarshaller.read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testValidateSignature () throws Exception
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V43.getTestResources ())
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
