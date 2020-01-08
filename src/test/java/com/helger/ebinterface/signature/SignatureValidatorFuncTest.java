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
package com.helger.ebinterface.signature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.io.file.FileSystemRecursiveIterator;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xml.sax.DoNothingSAXErrorHandler;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;
import com.helger.xmldsig.XMLDSigValidationResult;
import com.helger.xmldsig.XMLDSigValidator;

/**
 * Test class for class {@link XMLDSigValidator}
 *
 * @author Philip Helger
 */
public final class SignatureValidatorFuncTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (SignatureValidatorFuncTest.class);

  @Ignore
  @Test
  public void testFindAllValidatableFiles ()
  {
    for (final File aFile : new FileSystemRecursiveIterator ("src/test/resources"))
      if (aFile.isFile () && aFile.getName ().endsWith (".xml"))
      {
        // Read document
        final Document aDoc = DOMReader.readXMLDOM (aFile,
                                                    new DOMReaderSettings ().setErrorHandler (new DoNothingSAXErrorHandler ()));
        assertNotNull (aDoc);

        // Validate the signature
        try
        {
          if (XMLDSigValidator.validateSignature (aDoc).isValid ())
            System.out.println ("OK: " + aFile.getAbsolutePath ());
        }
        catch (final Exception ex)
        {}
      }
  }

  @Test
  public void testSign () throws Exception
  {
    for (final String sPath : new String [] { "ebinterface/v30/valid6-signed.xml",
                                              "ebinterface/v302/mesonic1.xml",
                                              "ebinterface/v302/mesonic2.xml",
                                              "ebinterface/v302/valid_and_signed.xml",
                                              // "ebinterface/v40/ebinterface4-signed.xml",
                                              "ebinterface/v40/Rechnung-R_00156_3_00.xml" })
    {
      LOGGER.info (sPath);

      // Read document
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sPath));
      assertNotNull (aDoc);

      // Validate the signature
      final XMLDSigValidationResult aResult = XMLDSigValidator.validateSignature (aDoc);
      assertTrue (sPath + " - " + String.valueOf (aResult), aResult.isValid ());

      if (!aDoc.getDocumentElement ().getLocalName ().equals ("Signature"))
      {
        // Modify the document
        aDoc.getDocumentElement ().appendChild (aDoc.createTextNode ("text"));

        // Validate again - must fail
        assertTrue (XMLDSigValidator.validateSignature (aDoc).isInvalid ());
      }
    }
  }
}
