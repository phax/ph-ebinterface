/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.ebinterface.codelist;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;

/**
 * Tax code enum for ebInterface 4.0
 * <p>
 * „AT“+UVACode. ATXXX entspricht nicht steuerbar. Die entsprechenden UVA Codes
 * sind dem U30 Formular des Bundesministeriums für Finanzen zu entnehmen
 * [BMF11]. Die Angabe des TaxCodes hat nur informativen Charakter. Normativ für
 * den Steuersatz ist die Angabe im Feld „TaxRate“.
 * </p>
 * <p>
 * Has been verified for the years 2006-2013
 * </p>
 * Source:
 * http://formulare.bmf.gv.at/service/formulare/inter-Steuern/pdfs/2010/U30.pdf
 *
 * @author Philip Helger
 */
public enum ETaxCode implements IHasID <String>
{
  /** Regular tax rate. */
  STANDARD_20 ("AT022", 20, "Normalsteuersatz"),
  /** Reduced tax rate */
  REDUCED_10 ("AT029", 10, "ermäßigter Steuersatz"),
  /** Wine tax rate */
  WINE_12 ("AT025", 12, "für Weinumsätze durch landwirtschaftliche Betriebe"),
  /** Special regions. Up to 2006 only */
  @Deprecated GERMANY_16 ("AT035", 16, "für Jungholz und Mittelberg"),
  /** Special regions. From 2007 only */
  GERMANY_19 ("AT037", 19, "für Jungholz und Mittelberg"),
  /** Add-on tax for certain farmers only */
  ADDITIONAL_10 ("AT052", 10, "Zusatzsteuer für pauschalierte land- und forstwirtschaftliche Betriebe"),
  /** Add-on tax for certain farmers only */
  ADDITIONAL_08 ("AT038", 8, "Zusatzsteuer für pauschalierte land- und forstwirtschaftliche Betriebe"),
  /** ebInterface 4.0 specific code */
  NOT_TAXABLE ("ATXXX", 0, "nicht steuerbar");

  private final String m_sID;
  private final int m_nPerc;
  private final String m_sDesc;

  private ETaxCode (@Nonnull @Nonempty final String sID,
                    @Nonnegative final int nPerc,
                    @Nonnull @Nonempty final String sDesc)
  {
    m_sID = sID;
    m_nPerc = nPerc;
    m_sDesc = sDesc;
  }

  @Nonnull
  @Nonempty
  public String getID ()
  {
    return m_sID;
  }

  /**
   * @return The assigned percentage between 0 and 100.
   */
  @Nonnegative
  public int getPercentage ()
  {
    return m_nPerc;
  }

  /**
   * @return Description of this tax code. Never <code>null</code>.
   */
  @Nonnull
  @Nonempty
  public String getDescription ()
  {
    return m_sDesc;
  }

  /**
   * Lookup element by ID.
   *
   * @param sID
   *        ID to lookup. May be <code>null</code>.
   * @return <code>null</code> if no such element exists.
   */
  @Nullable
  public static ETaxCode getFromIDOrNull (@Nullable final String sID)
  {
    return EnumHelper.getFromIDOrNull (ETaxCode.class, sID);
  }
}
