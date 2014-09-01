/**
 * Copyright (C) 2014 Philip Helger (www.helger.com)
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

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.helger.commons.io.IReadableResource;
import com.helger.commons.jaxb.validation.CollectingValidationEventHandlerFactory;
import com.helger.commons.mock.PHTestUtils;
import com.helger.commons.xml.serialize.DOMReader;
import com.helger.ebinterface.v302.Ebi302InvoiceType;

/**
 * Test class for class {@link EbInterface302Marshaller}.
 *
 * @author Philip Helger
 */
public final class EbInterface302MarshallerTest
{
  @Test
  public void testReadValid () throws SAXException
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V302.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      final EbInterface302Marshaller aMarshaller = new EbInterface302Marshaller ();
      aMarshaller.setValidationEventHandlerFactory (new CollectingValidationEventHandlerFactory ());

      // Convert to domain object
      final Ebi302InvoiceType aInvoice = aMarshaller.read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);

      // Convert again to XML document
      final Document aDoc2 = aMarshaller.write (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);

      // Convert to domain object again
      final Ebi302InvoiceType aInvoice2 = aMarshaller.read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);

      // Must be equals
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }
}
