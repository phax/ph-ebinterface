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
package com.helger.ebinterface.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;

/**
 * Recommended codes for FurtherIdentification. Source: ebInterface 6.1
 * documentation
 *
 * @author Philip Helger
 * @since 7.1.1
 */
public enum EFurtherIdentification implements IHasID <String>, IHasDisplayName
{
  ARA ("ARA", "ARA Nummer"),
  BBG_GZ ("BBG-GZ", "Geschäftszahl/Vertragsnummer der Bundesbeschaffung"),
  CONSOLIDATOR ("Consolidator", "ID des Consolidators"),
  CONTRACT ("Contract", "Vertragsnummer"),
  DVR ("DVR", "DVR Nummer"),
  EORI ("EORI", "Economic Operator's Registration and Identification"),
  ERSB ("ERSB", "Ergänzungsregister Sonstige Betroffene"),
  OFFICE_LOCATION ("FN", "Firmenbuchnummer"),
  COMMERCIAL_REGISTER_NUMBER ("FR", "Firmenregisternummer beim Firmengericht"),
  COMMERCIAL_COURT ("HG", "Name des zuständigen Handelsgerichts"),
  PAYER ("Payer", "ID des Payers"),
  FASTNR ("FASTNR", "Finanzamt-Steuernummer"),
  VID ("VID", "Verbrauchsteuernummer"),
  VN ("VN", "Vereinsregisternummer");

  private final String m_sID;
  private final String m_sDisplayName;

  EFurtherIdentification (@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName)
  {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
  }

  @Nonnull
  @Nonempty
  public String getID ()
  {
    return m_sID;
  }

  /**
   * @return Description of this further identification (in German). Never
   *         <code>null</code>.
   */
  @Nonnull
  @Nonempty
  public String getDisplayName ()
  {
    return m_sDisplayName;
  }

  /**
   * Lookup element by ID.
   *
   * @param sID
   *        ID to lookup. May be <code>null</code>.
   * @return <code>null</code> if no such element exists.
   */
  @Nullable
  public static EFurtherIdentification getFromIDOrNull (@Nullable final String sID)
  {
    return EnumHelper.getFromIDOrNull (EFurtherIdentification.class, sID);
  }
}
