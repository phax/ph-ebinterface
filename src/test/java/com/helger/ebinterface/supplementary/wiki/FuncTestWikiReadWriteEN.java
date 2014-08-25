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
 * The tests contained in here are meant as copy-paste examples for the project
 * Wiki.
 *
 * @author Philip Helger
 */
public final class FuncTestWikiReadWriteEN
{
  /**
   * Read an ebInterface 3.0 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public com.helger.ebinterface.v30.Ebi30InvoiceType readEbInterface30 (@Nonnull final java.io.File aFile)
  {
    final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice = new com.helger.ebinterface.EbInterface30Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 3.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public com.helger.ebinterface.v30.Ebi30InvoiceType readEbInterface30 (@Nonnull final org.w3c.dom.Node aNode)
  {
    final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice = new com.helger.ebinterface.EbInterface30Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 3.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0 invoice from the specified resource.
   *
   * @param aRes
   *        The resource to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public com.helger.ebinterface.v30.Ebi30InvoiceType readEbInterface30 (@Nonnull final com.helger.commons.io.IReadableResource aRes)
  {
    final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice = new com.helger.ebinterface.EbInterface30Marshaller ().read (aRes);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 3.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0.2 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public com.helger.ebinterface.v302.Ebi302InvoiceType readEbInterface302 (@Nonnull final java.io.File aFile)
  {
    final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice = new com.helger.ebinterface.EbInterface302Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 3.0.2 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0.2 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public com.helger.ebinterface.v302.Ebi302InvoiceType readEbInterface302 (@Nonnull final org.w3c.dom.Node aNode)
  {
    final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice = new com.helger.ebinterface.EbInterface302Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 3.0.2 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 3.0.2 invoice from the specified resource.
   *
   * @param aResource
   *        The resource to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public com.helger.ebinterface.v302.Ebi302InvoiceType readEbInterface302 (@Nonnull final com.helger.commons.io.IReadableResource aResource)
  {
    final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice = new com.helger.ebinterface.EbInterface302Marshaller ().read (aResource);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 3.0.2 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.0 invoice from the specified file.
   *
   * @param aFile
   *        The file to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public com.helger.ebinterface.v40.Ebi40InvoiceType readEbInterface40 (@Nonnull final java.io.File aFile)
  {
    final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice = new com.helger.ebinterface.EbInterface40Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed file is not a valid ebInterface 4.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.0 invoice from the specified XML node.
   *
   * @param aNode
   *        The existing XML node to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed DOM node is no valid ebInterface
   *         document
   */
  @Nonnull
  public com.helger.ebinterface.v40.Ebi40InvoiceType readEbInterface40 (@Nonnull final org.w3c.dom.Node aNode)
  {
    final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice = new com.helger.ebinterface.EbInterface40Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed DOM node is not a valid ebInterface 4.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Read an ebInterface 4.0 invoice from the specified resource.
   *
   * @param aResource
   *        The resource to read the invoice from. May not be null.
   * @return The read invoice object.
   * @throws IllegalArgumentException
   *         If the content of the passed file is no valid ebInterface document
   */
  @Nonnull
  public com.helger.ebinterface.v40.Ebi40InvoiceType readEbInterface40 (@Nonnull final com.helger.commons.io.IReadableResource aResource)
  {
    final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice = new com.helger.ebinterface.EbInterface40Marshaller ().read (aResource);
    if (aInvoice == null)
      throw new IllegalArgumentException ("The passed resource is not a valid ebInterface 4.0 document. See the console for details.");
    return aInvoice;
  }

  /**
   * Write the passed ebInterface 3.0 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be null.
   * @param aFile
   *        The file to read the invoice from. May not be null.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  @Nonnull
  public void writeEbInterface30File (@Nonnull final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice,
                                      @Nonnull final java.io.File aFile)
  {
    if (new com.helger.ebinterface.EbInterface30Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 3.0 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be null.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public org.w3c.dom.Document getEbInterface30Document (@Nonnull final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice)
  {
    final org.w3c.dom.Document ret = new com.helger.ebinterface.EbInterface30Marshaller ().write (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0 invoice. See the console for details.");
    return ret;
  }

  /**
   * Write the passed ebInterface 3.0.2 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be null.
   * @param aFile
   *        The file to read the invoice from. May not be null.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  @Nonnull
  public void writeEbInterface302File (@Nonnull final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice,
                                       @Nonnull final java.io.File aFile)
  {
    if (new com.helger.ebinterface.EbInterface302Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0.2 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 3.0.2 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be null.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public org.w3c.dom.Document getEbInterface302Document (@Nonnull final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice)
  {
    final org.w3c.dom.Document ret = new com.helger.ebinterface.EbInterface302Marshaller ().write (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 3.0.2 invoice. See the console for details.");
    return ret;
  }

  /**
   * Write the passed ebInterface 4.0 invoice to the specified file.
   *
   * @param aInvoice
   *        The invoice to be written. May not be null.
   * @param aFile
   *        The file to read the invoice from. May not be null.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         written to the file
   */
  @Nonnull
  public void writeEbInterface40File (@Nonnull final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice,
                                      @Nonnull final java.io.File aFile)
  {
    if (new com.helger.ebinterface.EbInterface40Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.0 invoice. See the console for details.");
  }

  /**
   * Convert the passed ebInterface 4.0 invoice to an XML document.
   *
   * @param aInvoice
   *        The invoice to be written. May not be null.
   * @throws IllegalArgumentException
   *         If the content of the passed invoice is incomplete and cannot be
   *         converted to XML
   */
  @Nonnull
  public org.w3c.dom.Document getEbInterface40Document (@Nonnull final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice)
  {
    final org.w3c.dom.Document ret = new com.helger.ebinterface.EbInterface40Marshaller ().write (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("The passed invoice is not a valid ebInterface 4.0 invoice. See the console for details.");
    return ret;
  }
}
