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
package com.helger.ebinterface;

import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v30.ObjectFactory;
import com.helger.jaxb.GenericJAXBMarshaller;

/**
 * This is the reader and writer for ebInterface 3.0 documents. This class may
 * be derived to override protected methods from {@link GenericJAXBMarshaller}.
 *
 * @author Philip Helger
 */
public class EbInterface30Marshaller extends GenericJAXBMarshaller <Ebi30InvoiceType>
{
  /**
   * Constructor
   */
  public EbInterface30Marshaller ()
  {
    super (Ebi30InvoiceType.class, CEbInterface.EBINTERFACE_30_XSDS, new ObjectFactory ()::createInvoice);
    setNamespaceContext (EbInterface30NamespaceContext.getInstance ());
  }
}
