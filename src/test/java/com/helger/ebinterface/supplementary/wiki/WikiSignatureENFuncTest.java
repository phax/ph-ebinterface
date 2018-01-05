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
package com.helger.ebinterface.supplementary.wiki;

import javax.annotation.Nonnull;
import javax.xml.crypto.dsig.XMLSignatureException;

import org.w3c.dom.Document;

import com.helger.xmldsig.XMLDSigValidationResult;
import com.helger.xmldsig.XMLDSigValidator;

/**
 * The tests contained in here are meant as copy-paste examples for signature
 * handling for the project Wiki.
 *
 * @author Philip Helger
 */
public final class WikiSignatureENFuncTest
{
  /**
   * Verify the XML signature of a document
   *
   * @param aDoc
   *        The existing XML document to validate the signature. May not be
   *        null.
   * @return true if no signature is contained, or if a signature is contained
   *         and valid. false only is a signature is contained and invalid
   */
  public static boolean hasSignatureAndIsValid (@Nonnull final Document aDoc)
  {
    if (!XMLDSigValidator.containsSignature (aDoc))
    {
      // Document does not contain a signature
      return true;
    }

    // Document contains a signature
    try
    {
      final XMLDSigValidationResult aSVR = XMLDSigValidator.validateSignature (aDoc);
      if (aSVR.isValid ())
      {
        // Signature contained and valid
        return true;
      }

      // Signature contained but invalid
      if (!aSVR.getInvalidReferenceIndices ().isEmpty ())
        System.out.println ("The following reference indices are invalid: " + aSVR.getInvalidReferenceIndices ());
    }
    catch (final XMLSignatureException e)
    {
      System.err.println ("Error validating XMLDsig");
      e.printStackTrace (System.err);
    }
    return false;
  }
}
