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
import com.helger.ebinterface.v60.Ebi60InvoiceType;
import com.helger.ebinterface.v61.Ebi61InvoiceType;
import com.helger.jaxb.builder.JAXBReaderBuilder;

/**
 * A reader builder for ebInterface documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The ebInterface implementation class to be read
 */
@NotThreadSafe
@Deprecated (since = "7.1.0", forRemoval = true)
public class EbInterfaceReader <JAXBTYPE> extends JAXBReaderBuilder <JAXBTYPE, EbInterfaceReader <JAXBTYPE>>
{
  public EbInterfaceReader (@Nonnull final EEbInterfaceDocumentType eDocType,
                            @Nonnull final Class <JAXBTYPE> aImplClass)
  {
    super (eDocType, aImplClass);
  }

  public EbInterfaceReader (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (EbInterfaceDocumentTypes.getDocumentTypeOfImplementationClass (aClass), aClass);
  }

  /**
   * Create a new reader builder.
   *
   * @param aClass
   *        The UBL class to be read. May not be <code>null</code>.
   * @return The new reader builder. Never <code>null</code>.
   * @param <T>
   *        The ebInterface document implementation type
   */
  @Nonnull
  public static <T> EbInterfaceReader <T> create (@Nonnull final Class <T> aClass)
  {
    return new EbInterfaceReader <> (aClass);
  }

  /**
   * Create a new reader builder that is not typed, because only the document
   * type enumeration value is available.
   *
   * @param eDocType
   *        The ebInterface document type to be read. May not be
   *        <code>null</code> .
   * @return The new reader builder. Never <code>null</code>.
   */
  @Nonnull
  public static EbInterfaceReader <?> createGeneric (@Nonnull final EEbInterfaceDocumentType eDocType)
  {
    return new EbInterfaceReader <> (eDocType, Object.class);
  }

  /**
   * Create a reader builder for Ebi30InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi30InvoiceType> ebInterface30 ()
  {
    return EbInterfaceReader.create (Ebi30InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi302InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi302InvoiceType> ebInterface302 ()
  {
    return EbInterfaceReader.create (Ebi302InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi40InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi40InvoiceType> ebInterface40 ()
  {
    return EbInterfaceReader.create (Ebi40InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi41InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi41InvoiceType> ebInterface41 ()
  {
    return EbInterfaceReader.create (Ebi41InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi42InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi42InvoiceType> ebInterface42 ()
  {
    return EbInterfaceReader.create (Ebi42InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi43InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi43InvoiceType> ebInterface43 ()
  {
    return EbInterfaceReader.create (Ebi43InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi50InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi50InvoiceType> ebInterface50 ()
  {
    return EbInterfaceReader.create (Ebi50InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi60InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi60InvoiceType> ebInterface60 ()
  {
    return EbInterfaceReader.create (Ebi60InvoiceType.class);
  }

  /**
   * Create a reader builder for Ebi61InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceReader <Ebi61InvoiceType> ebInterface61 ()
  {
    return EbInterfaceReader.create (Ebi61InvoiceType.class);
  }
}
