/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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

import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.ebinterface.v50.Ebi50InvoiceType;
import com.helger.jaxb.builder.JAXBValidationBuilder;

/**
 * A writer builder for ebInterface documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The ebInterface implementation class to be read
 */
@NotThreadSafe
public class EbInterfaceValidator <JAXBTYPE> extends JAXBValidationBuilder <JAXBTYPE, EbInterfaceValidator <JAXBTYPE>>
{
  public EbInterfaceValidator (@Nonnull final EEbInterfaceDocumentType eDocType)
  {
    super (eDocType);
  }

  public EbInterfaceValidator (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (EbInterfaceDocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new validation builder.
   *
   * @param aClass
   *        The UBL class to be validated. May not be <code>null</code>.
   * @return The new validation builder. Never <code>null</code>.
   * @param <T>
   *        The ebInterface document implementation type
   */
  @Nonnull
  public static <T> EbInterfaceValidator <T> create (@Nonnull final Class <T> aClass)
  {
    return new EbInterfaceValidator <> (aClass);
  }

  /**
   * Create a validation builder for Ebi30InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi30InvoiceType> ebInterface30 ()
  {
    return EbInterfaceValidator.create (Ebi30InvoiceType.class);
  }

  /**
   * Create a validation builder for Ebi302InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi302InvoiceType> ebInterface302 ()
  {
    return EbInterfaceValidator.create (Ebi302InvoiceType.class);
  }

  /**
   * Create a validation builder for Ebi40InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi40InvoiceType> ebInterface40 ()
  {
    return EbInterfaceValidator.create (Ebi40InvoiceType.class);
  }

  /**
   * Create a validation builder for Ebi41InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi41InvoiceType> ebInterface41 ()
  {
    return EbInterfaceValidator.create (Ebi41InvoiceType.class);
  }

  /**
   * Create a validation builder for Ebi42InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi42InvoiceType> ebInterface42 ()
  {
    return EbInterfaceValidator.create (Ebi42InvoiceType.class);
  }

  /**
   * Create a validation builder for Ebi43InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi43InvoiceType> ebInterface43 ()
  {
    return EbInterfaceValidator.create (Ebi43InvoiceType.class);
  }

  /**
   * Create a validation builder for Ebi50InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceValidator <Ebi50InvoiceType> ebInterface50 ()
  {
    return EbInterfaceValidator.create (Ebi50InvoiceType.class);
  }
}
