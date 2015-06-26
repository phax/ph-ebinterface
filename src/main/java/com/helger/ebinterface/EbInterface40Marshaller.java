/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.xml.bind.JAXBElement;

import com.helger.commons.jaxb.AbstractJAXBMarshaller;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v40.ObjectFactory;

/**
 * This is the reader and writer for ebInterface 4.0 documents. This class may
 * be derived to override protected methods from {@link AbstractJAXBMarshaller}.
 *
 * @author Philip Helger
 */
public class EbInterface40Marshaller extends AbstractJAXBMarshaller <Ebi40InvoiceType>
{
  /**
   * Constructor
   */
  public EbInterface40Marshaller ()
  {
    super (Ebi40InvoiceType.class, CEbInterface.EBINTERFACE_40_XSDS);
  }

  @Override
  @Nonnull
  protected final JAXBElement <Ebi40InvoiceType> wrapObject (final Ebi40InvoiceType aInvoice)
  {
    return new ObjectFactory ().createInvoice (aInvoice);
  }
}
