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
package com.helger.ebinterface.supplementary.wiki;

import java.io.File;

import javax.annotation.Nonnull;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.helger.commons.io.resource.IReadableResource;
import com.helger.ebinterface.EbInterface302Marshaller;
import com.helger.ebinterface.EbInterface30Marshaller;
import com.helger.ebinterface.EbInterface40Marshaller;
import com.helger.ebinterface.EbInterface41Marshaller;
import com.helger.ebinterface.EbInterface42Marshaller;
import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;

/**
 * The tests contained in here are meant as copy-paste examples for the project
 * Wiki.
 *
 * @author Philip Helger
 */
public final class WikiReadWriteENFuncTest
{
  /**
   * Read an ebInterface 3.0 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi30InvoiceType readEbInterface30 (@Nonnull final File aFile)
  {
    final Ebi30InvoiceType aInvoice = new EbInterface30Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 3.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be
   *        <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public static Ebi30InvoiceType readEbInterface30 (@Nonnull final Node aNode)
  {
    final Ebi30InvoiceType aInvoice = new EbInterface30Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 3.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0 invoice from the specified resource.
   *
   * @param aRes
   *        The resource to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi30InvoiceType readEbInterface30 (@Nonnull final IReadableResource aRes)
  {
    final Ebi30InvoiceType aInvoice = new EbInterface30Marshaller ().read (aRes);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 3.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0.2 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi302InvoiceType readEbInterface302 (@Nonnull final File aFile)
  {
    final Ebi302InvoiceType aInvoice = new EbInterface302Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 3.0.2 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0.2 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be
   *        <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public static Ebi302InvoiceType readEbInterface302 (@Nonnull final Node aNode)
  {
    final Ebi302InvoiceType aInvoice = new EbInterface302Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 3.0.2 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0.2 invoice from the specified resource.
   *
   * @param aResource
   *        The resource to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi302InvoiceType readEbInterface302 (@Nonnull final IReadableResource aResource)
  {
    final Ebi302InvoiceType aInvoice = new EbInterface302Marshaller ().read (aResource);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 3.0.2 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.0 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi40InvoiceType readEbInterface40 (@Nonnull final File aFile)
  {
    final Ebi40InvoiceType aInvoice = new EbInterface40Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 4.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.0 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be
   *        <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public static Ebi40InvoiceType readEbInterface40 (@Nonnull final Node aNode)
  {
    final Ebi40InvoiceType aInvoice = new EbInterface40Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 4.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.0 invoice from the specified resource.
   *
   * @param aResource
   *        The resource to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi40InvoiceType readEbInterface40 (@Nonnull final IReadableResource aResource)
  {
    final Ebi40InvoiceType aInvoice = new EbInterface40Marshaller ().read (aResource);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 4.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.1 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi41InvoiceType readEbInterface41 (@Nonnull final File aFile)
  {
    final Ebi41InvoiceType aInvoice = new EbInterface41Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 4.1 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.1 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be
   *        <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public static Ebi41InvoiceType readEbInterface41 (@Nonnull final Node aNode)
  {
    final Ebi41InvoiceType aInvoice = new EbInterface41Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 4.1 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.1 invoice from the specified resource.
   *
   * @param aResource
   *        The resource to read the invoice from. May not be <code>null</code>.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public static Ebi41InvoiceType readEbInterface41 (@Nonnull final IReadableResource aResource)
  {
    final Ebi41InvoiceType aInvoice = new EbInterface41Marshaller ().read (aResource);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 4.1 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Write the passed ebInterface 3.0 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  public static void writeEbInterface30File (@Nonnull final Ebi30InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface30Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 3.0 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @return The ebInterface document as an XML DOM Document.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public static Document getEbInterface30Document (@Nonnull final Ebi30InvoiceType aInvoice)
  {
    final Document ret = new EbInterface30Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0 invoice. See the console for details.");
    return ret;
  }

  /**
   * Write the passed ebInterface 3.0.2 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  public static void writeEbInterface302File (@Nonnull final Ebi302InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface302Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0.2 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 3.0.2 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @return The ebInterface document as an XML DOM Document.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public static Document getEbInterface302Document (@Nonnull final Ebi302InvoiceType aInvoice)
  {
    final Document ret = new EbInterface302Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0.2 invoice. See the console for details.");
    return ret;
  }

  /**
   * Write the passed ebInterface 4.0 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  public static void writeEbInterface40File (@Nonnull final Ebi40InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface40Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.0 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 4.0 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @return The ebInterface document as an XML DOM Document.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public static Document getEbInterface40Document (@Nonnull final Ebi40InvoiceType aInvoice)
  {
    final Document ret = new EbInterface40Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.0 invoice. See the console for details.");
    return ret;
  }

  /**
   * Write the passed ebInterface 4.1 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  public static void writeEbInterface41File (@Nonnull final Ebi41InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface41Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.1 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 4.1 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @return The ebInterface document as an XML DOM Document.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public static Document getEbInterface41Document (@Nonnull final Ebi41InvoiceType aInvoice)
  {
    final Document ret = new EbInterface41Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.1 invoice. See the console for details.");
    return ret;
  }

  /**
   * Write the passed ebInterface 4.2 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @param aFile
   *        The file to read the invoice from. May not be <code>null</code>.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  public static void writeEbInterface42File (@Nonnull final Ebi42InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface42Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.2 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 4.2 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be <code>null</code>.
   * @return The ebInterface document as an XML DOM Document.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public static Document getEbInterface42Document (@Nonnull final Ebi42InvoiceType aInvoice)
  {
    final Document ret = new EbInterface42Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.2 invoice. See the console for details.");
    return ret;
  }
}
