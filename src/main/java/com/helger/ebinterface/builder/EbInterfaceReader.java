/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;

/**
 * Read all ebInterface document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class EbInterfaceReader
{
  @PresentForCodeCoverage
  private static final EbInterfaceReader s_aInstance = new EbInterfaceReader ();

  private EbInterfaceReader ()
  {}

  /**
   * Create a reader builder for Ebi30InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReaderBuilder <Ebi30InvoiceType> ebInterface30 ()
  {
    return EbInterfaceReaderBuilder.create (Ebi30InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi302InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReaderBuilder <Ebi302InvoiceType> ebInterface302 ()
  {
    return EbInterfaceReaderBuilder.create (Ebi302InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi40InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReaderBuilder <Ebi40InvoiceType> ebInterface40 ()
  {
    return EbInterfaceReaderBuilder.create (Ebi40InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi41InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReaderBuilder <Ebi41InvoiceType> ebInterface41 ()
  {
    return EbInterfaceReaderBuilder.create (Ebi41InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi42InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReaderBuilder <Ebi42InvoiceType> ebInterface42 ()
  {
    return EbInterfaceReaderBuilder.create (Ebi42InvoiceType.class);
  }
}
