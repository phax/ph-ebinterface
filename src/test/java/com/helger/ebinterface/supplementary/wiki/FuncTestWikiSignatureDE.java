/**
 * Copyright (C) 2006-2014 phloc systems (www.phloc.com)
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
package com.helger.ebinterface.supplementary.wiki;

import javax.annotation.Nonnull;

/**
 * Signatur-Routinen fürs Wiki
 *
 * @author Philip Helger
 */
public final class FuncTestWikiSignatureDE
{
  /**
   * Überprüfe die XML Signatur des angegebenen Dokuments
   *
   * @param aDoc
   *        Das existierende XML DOM Dokument mit der zu überprüfenden Signatur.
   *        Darf nicht null sein.
   * @return true wenn entweder keine Signatur enthalten ist oder wenn eine
   *         gültige Signatur enthalten ist. false wird nur dann zurückgeliefert
   *         wenn eine Signatur enthalten ist, und diese ungültig ist.
   */
  @Nonnull
  public boolean hasSignatureAndIsValid (@Nonnull final org.w3c.dom.Document aDoc)
  {
    if (!com.helger.xmldsig.XMLDSigValidator.containsSignature (aDoc))
    {
      // Dokument enthält keine Signatur
      return true;
    }

    // Dokument enthält eine Signatur
    try
    {
      final com.helger.xmldsig.XMLDSigValidationResult aSVR = com.helger.xmldsig.XMLDSigValidator.validateSignature (aDoc);
      if (aSVR.isValid ())
      {
        // Enthaltene Signatur is valide
        return true;
      }

      // Enthaltene Signatur is NICHT valide
      if (!aSVR.getInvalidReferenceIndices ().isEmpty ())
        System.out.println ("Die folgenden Reference Indizes sind ungültig: " + aSVR.getInvalidReferenceIndices ());
    }
    catch (final javax.xml.crypto.dsig.XMLSignatureException e)
    {
      System.err.println ("Fehler beim Überprüfen der XMLDsig");
      e.printStackTrace (System.err);
    }
    return false;
  }
}
