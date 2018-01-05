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
package com.helger.ebinterface;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.ebinterface.v50.Ebi50InvoiceType;
import com.helger.jaxb.validation.LoggingValidationEventHandler;
import com.helger.xml.serialize.read.DOMReader;

/**
 * Test class for class {@link EbInterface50Marshaller}.
 *
 * @author Philip Helger
 */
public final class EbInterface50MarshallerTest
{
  @Test
  public void testReadValid () throws SAXException
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V50.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      final EbInterface50Marshaller aMarshaller = new EbInterface50Marshaller ();
      aMarshaller.setValidationEventHandlerFactory (m -> new LoggingValidationEventHandler ().andThen (m));

      // Convert to domain object
      final Ebi50InvoiceType aInvoice = aMarshaller.read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);

      // Convert again to XML document
      final Document aDoc2 = aMarshaller.getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V50,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi50InvoiceType aInvoice2 = aMarshaller.read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());
    }
  }
}
