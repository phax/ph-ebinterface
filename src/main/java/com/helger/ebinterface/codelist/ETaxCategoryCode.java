/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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

/**
 * Tax category codes support by ebInterface 5.0 onwards. Based on UNTDID 5305
 * code list, version D16B:
 * https://www.unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tred5305.htm
 *
 * @author Philip Helger
 */
public enum ETaxCategoryCode implements IHasID <String>
{
  // VAT
  S ("S", ETaxCategoryCodeType.VAT),
  AA ("AA", ETaxCategoryCodeType.VAT),
  Z ("Z", ETaxCategoryCodeType.VAT),
  // Tax exemption
  D ("D", ETaxCategoryCodeType.TAX_EXEMPTION),
  E ("E", ETaxCategoryCodeType.TAX_EXEMPTION),
  F ("F", ETaxCategoryCodeType.TAX_EXEMPTION),
  G ("G", ETaxCategoryCodeType.TAX_EXEMPTION),
  I ("I", ETaxCategoryCodeType.TAX_EXEMPTION),
  J ("J", ETaxCategoryCodeType.TAX_EXEMPTION),
  K ("K", ETaxCategoryCodeType.TAX_EXEMPTION),
  // Not tax relevant
  O ("O", ETaxCategoryCodeType.NOT_TAX_RELEVANT),
  // Irrelevant
  A ("A", ETaxCategoryCodeType.IRRELEVANT),
  AB ("AB", ETaxCategoryCodeType.IRRELEVANT),
  AC ("AC", ETaxCategoryCodeType.IRRELEVANT),
  AD ("AD", ETaxCategoryCodeType.IRRELEVANT),
  B ("B", ETaxCategoryCodeType.IRRELEVANT),
  C ("C", ETaxCategoryCodeType.IRRELEVANT),
  H ("H", ETaxCategoryCodeType.IRRELEVANT),
  L ("L", ETaxCategoryCodeType.IRRELEVANT),
  M ("M", ETaxCategoryCodeType.IRRELEVANT);

  private final String m_sID;
  private final ETaxCategoryCodeType m_eType;

  ETaxCategoryCode (@Nonnull @Nonempty final String sID, @Nonnull final ETaxCategoryCodeType eType)
  {
    m_sID = sID;
    m_eType = eType;
  }

  @Nonnull
  @Nonempty
  public String getID ()
  {
    return m_sID;
  }

  @Nonnull
  public ETaxCategoryCodeType getType ()
  {
    return m_eType;
  }

  /**
   * @return <code>true</code> if this code is relevant to Austrian taxation,
   *         <code>false</code> if this code is not applicable in Austria.
   */
  public boolean isRelevantCodeAT ()
  {
    return m_eType != ETaxCategoryCodeType.IRRELEVANT;
  }

  /**
   * Lookup element by ID.
   *
   * @param sID
   *        ID to lookup. May be <code>null</code>.
   * @return <code>null</code> if no such element exists.
   */
  @Nullable
  public static ETaxCategoryCode getFromIDOrNull (@Nullable final String sID)
  {
    return EnumHelper.getFromIDOrNull (ETaxCategoryCode.class, sID);
  }
}
