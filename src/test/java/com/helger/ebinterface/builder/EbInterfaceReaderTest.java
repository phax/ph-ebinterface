/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ebinterface.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.ebinterface.EEbInterfaceTestFiles;
import com.helger.ebinterface.EEbInterfaceVersion;
import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.ebinterface.v50.Ebi50InvoiceType;
import com.helger.ebinterface.v60.Ebi60InvoiceType;
import com.helger.xml.serialize.read.DOMReader;

/**
 * Test class for class {@link EbInterfaceReaderTest}.
 *
 * @author Philip Helger
 */
public final class EbInterfaceReaderTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (EbInterfaceReaderTest.class);

  @Test
  public void testReadEbi30 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V30.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi30InvoiceType aInvoice = EbInterfaceReader.ebInterface30 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface30 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V30,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi30InvoiceType aInvoice2 = EbInterfaceReader.ebInterface30 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);

      // Must be equals
      assertEquals (EbInterfaceWriter.ebInterface30 ().getAsString (aInvoice),
                    EbInterfaceWriter.ebInterface30 ().getAsString (aInvoice2));
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi302 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V302.getTestResources ())
    {
      if (true)
        LOGGER.info (aExampleFile.getPath ());

      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi302InvoiceType aInvoice = EbInterfaceReader.ebInterface302 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface302 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V302,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi302InvoiceType aInvoice2 = EbInterfaceReader.ebInterface302 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi40 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V40.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi40InvoiceType aInvoice = EbInterfaceReader.ebInterface40 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface40 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V40,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi40InvoiceType aInvoice2 = EbInterfaceReader.ebInterface40 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi41 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V41.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi41InvoiceType aInvoice = EbInterfaceReader.ebInterface41 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface41 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V41,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi41InvoiceType aInvoice2 = EbInterfaceReader.ebInterface41 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi42 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V42.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi42InvoiceType aInvoice = EbInterfaceReader.ebInterface42 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface42 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V42,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi42InvoiceType aInvoice2 = EbInterfaceReader.ebInterface42 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi43 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V43.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi43InvoiceType aInvoice = EbInterfaceReader.ebInterface43 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface43 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V43,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi43InvoiceType aInvoice2 = EbInterfaceReader.ebInterface43 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi50 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V50.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi50InvoiceType aInvoice = EbInterfaceReader.ebInterface50 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface50 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V50,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi50InvoiceType aInvoice2 = EbInterfaceReader.ebInterface50 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }

  @Test
  public void testReadEbi60 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V60.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      // Convert to domain object
      final Ebi60InvoiceType aInvoice = EbInterfaceReader.ebInterface60 ().read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());

      // Convert again to XML document
      final Document aDoc2 = EbInterfaceWriter.ebInterface60 ().getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V60,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi60InvoiceType aInvoice2 = EbInterfaceReader.ebInterface60 ().read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }
}
