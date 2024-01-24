/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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

import com.helger.ebinterface.EbInterface302NamespaceContext;
import com.helger.ebinterface.EbInterface30NamespaceContext;
import com.helger.ebinterface.EbInterface40NamespaceContext;
import com.helger.ebinterface.EbInterface41NamespaceContext;
import com.helger.ebinterface.EbInterface42NamespaceContext;
import com.helger.ebinterface.EbInterface43NamespaceContext;
import com.helger.ebinterface.EbInterface50NamespaceContext;
import com.helger.ebinterface.EbInterface60NamespaceContext;
import com.helger.ebinterface.EbInterface61NamespaceContext;
import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.ebinterface.v50.Ebi50InvoiceType;
import com.helger.ebinterface.v60.Ebi60InvoiceType;
import com.helger.ebinterface.v61.Ebi61InvoiceType;
import com.helger.jaxb.builder.JAXBWriterBuilder;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * A writer builder for ebInterface documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The ebInterface implementation class to be written
 */
@NotThreadSafe
@Deprecated (since = "7.1.0", forRemoval = true)
public class EbInterfaceWriter <JAXBTYPE> extends JAXBWriterBuilder <JAXBTYPE, EbInterfaceWriter <JAXBTYPE>>
{
  public EbInterfaceWriter (@Nonnull final EEbInterfaceDocumentType eDocType)
  {
    super (eDocType);

    // Create a default namespace context for the passed document type
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
    return new EbInterfaceWriter <> (aClass);
  }

  /**
   * Create a writer builder for Ebi30InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi30InvoiceType> ebInterface30 ()
  {
    final EbInterfaceWriter <Ebi30InvoiceType> ret = EbInterfaceWriter.create (Ebi30InvoiceType.class);
    ret.setNamespaceContext (EbInterface30NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi302InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi302InvoiceType> ebInterface302 ()
  {
    final EbInterfaceWriter <Ebi302InvoiceType> ret = EbInterfaceWriter.create (Ebi302InvoiceType.class);
    ret.setNamespaceContext (EbInterface302NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi40InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi40InvoiceType> ebInterface40 ()
  {
    final EbInterfaceWriter <Ebi40InvoiceType> ret = EbInterfaceWriter.create (Ebi40InvoiceType.class);
    ret.setNamespaceContext (EbInterface40NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi41InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi41InvoiceType> ebInterface41 ()
  {
    final EbInterfaceWriter <Ebi41InvoiceType> ret = EbInterfaceWriter.create (Ebi41InvoiceType.class);
    ret.setNamespaceContext (EbInterface41NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi42InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi42InvoiceType> ebInterface42 ()
  {
    final EbInterfaceWriter <Ebi42InvoiceType> ret = EbInterfaceWriter.create (Ebi42InvoiceType.class);
    ret.setNamespaceContext (EbInterface42NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi43InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi43InvoiceType> ebInterface43 ()
  {
    final EbInterfaceWriter <Ebi43InvoiceType> ret = EbInterfaceWriter.create (Ebi43InvoiceType.class);
    ret.setNamespaceContext (EbInterface43NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi50InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi50InvoiceType> ebInterface50 ()
  {
    final EbInterfaceWriter <Ebi50InvoiceType> ret = EbInterfaceWriter.create (Ebi50InvoiceType.class);
    ret.setNamespaceContext (EbInterface50NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi60InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi60InvoiceType> ebInterface60 ()
  {
    final EbInterfaceWriter <Ebi60InvoiceType> ret = EbInterfaceWriter.create (Ebi60InvoiceType.class);
    ret.setNamespaceContext (EbInterface60NamespaceContext.getInstance ());
    return ret;
  }

  /**
   * Create a writer builder for Ebi61InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static EbInterfaceWriter <Ebi61InvoiceType> ebInterface61 ()
  {
    final EbInterfaceWriter <Ebi61InvoiceType> ret = EbInterfaceWriter.create (Ebi61InvoiceType.class);
    ret.setNamespaceContext (EbInterface61NamespaceContext.getInstance ());
    return ret;
  }
}
