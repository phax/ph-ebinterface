/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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
import com.helger.jaxb.builder.JAXBWriterBuilder;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * A writer builder for ebInterface documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The ebInterface implementation class to be read
 */
@NotThreadSafe
public class EbInterfaceWriter <JAXBTYPE> extends JAXBWriterBuilder <JAXBTYPE, EbInterfaceWriter <JAXBTYPE>>
{
  public EbInterfaceWriter (@Nonnull final EEbInterfaceDocumentType eDocType)
  {
    super (eDocType);

    // Create a special namespace context for the passed document type
    final MapBasedNamespaceContext aNSContext = new MapBasedNamespaceContext ();
    aNSContext.setMapping ("eb", m_aDocType.getNamespaceURI ());
    setNamespaceContext (aNSContext);
  }

  public EbInterfaceWriter (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (EbInterfaceDocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new writer builder.
   *
   * @param aClass
   *        The UBL class to be written. May not be <code>null</code>.
   * @return The new writer builder. Never <code>null</code>.
   * @param <T>
   *        The ebInterface document implementation type
   */
  @Nonnull
  public static <T> EbInterfaceWriter <T> create (@Nonnull final Class <T> aClass)
  {
    return new EbInterfaceWriter<> (aClass);
  }

  /**
   * Create a writer builder for Ebi30InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi30InvoiceType> ebInterface30 ()
  {
    return EbInterfaceWriter.create (Ebi30InvoiceType.class);
  }

  /**
   * Create a writer builder for Ebi302InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi302InvoiceType> ebInterface302 ()
  {
    return EbInterfaceWriter.create (Ebi302InvoiceType.class);
  }

  /**
   * Create a writer builder for Ebi40InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi40InvoiceType> ebInterface40 ()
  {
    return EbInterfaceWriter.create (Ebi40InvoiceType.class);
  }

  /**
   * Create a writer builder for Ebi41InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi41InvoiceType> ebInterface41 ()
  {
    return EbInterfaceWriter.create (Ebi41InvoiceType.class);
  }

  /**
   * Create a writer builder for Ebi42InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi42InvoiceType> ebInterface42 ()
  {
    return EbInterfaceWriter.create (Ebi42InvoiceType.class);
  }

  /**
   * Create a writer builder for Ebi43InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi43InvoiceType> ebInterface43 ()
  {
    return EbInterfaceWriter.create (Ebi43InvoiceType.class);
  }
}
