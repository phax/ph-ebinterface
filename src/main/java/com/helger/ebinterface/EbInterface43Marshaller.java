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
package com.helger.ebinterface;

import java.util.List;

import javax.annotation.Nonnull;

import com.helger.commons.io.resource.IReadableResource;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.ebinterface.v43.ObjectFactory;
import com.helger.jaxb.AbstractJAXBMarshaller;

/**
 * This is the reader and writer for ebInterface 4.3 documents. This class may
 * be derived to override protected methods from {@link AbstractJAXBMarshaller}.
 *
 * @author Philip Helger
 */
public class EbInterface43Marshaller extends AbstractJAXBMarshaller <Ebi43InvoiceType>
{
  /**
   * Constructor
   */
  public EbInterface43Marshaller ()
  {
    this (CEbInterface.EBINTERFACE_43_XSDS);
  }

  /**
   * Constructor
   *
   * @param aXSDs
   *        The XML schemas to be used. Handle with care.
   */
  public EbInterface43Marshaller (@Nonnull final List <? extends IReadableResource> aXSDs)
  {
    super (Ebi43InvoiceType.class, aXSDs, o -> new ObjectFactory ().createInvoice (o));
  }
}
