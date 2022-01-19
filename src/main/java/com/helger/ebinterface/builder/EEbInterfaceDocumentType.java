/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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

import java.util.List;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.string.StringHelper;
import com.helger.ebinterface.CEbInterface;
import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;
import com.helger.ebinterface.v43.Ebi43InvoiceType;
import com.helger.ebinterface.v50.Ebi50InvoiceType;
import com.helger.ebinterface.v60.Ebi60InvoiceType;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;

/**
 * Enumeration with all available ebInterface document types.
 *
 * @author Philip Helger
 */
public enum EEbInterfaceDocumentType implements IJAXBDocumentType
{
  EBI30 (Ebi30InvoiceType.class, CEbInterface.EBINTERFACE_30_XSDS),
  EBI302 (Ebi302InvoiceType.class, CEbInterface.EBINTERFACE_302_XSDS),
  EBI40 (Ebi40InvoiceType.class, CEbInterface.EBINTERFACE_40_XSDS),
  EBI41 (Ebi41InvoiceType.class, CEbInterface.EBINTERFACE_41_XSDS),
  EBI42 (Ebi42InvoiceType.class, CEbInterface.EBINTERFACE_42_XSDS),
  EBI43 (Ebi43InvoiceType.class, CEbInterface.EBINTERFACE_43_XSDS),
  EBI50 (Ebi50InvoiceType.class, CEbInterface.EBINTERFACE_50_XSDS),
  EBI60 (Ebi60InvoiceType.class, CEbInterface.EBINTERFACE_60_XSDS);

  private final JAXBDocumentType m_aDocType;

  EEbInterfaceDocumentType (@Nonnull final Class <?> aClass, @Nonnull final List <? extends ClassPathResource> aXSDPaths)
  {
    m_aDocType = new JAXBDocumentType (aClass, aXSDPaths, x -> StringHelper.trimEnd (x, "Type"));
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aDocType.getImplementationClass ();
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aDocType.getAllXSDResources ();
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_aDocType.getNamespaceURI ();
  }

  @Nonnull
  @Nonempty
  public String getLocalName ()
  {
    return m_aDocType.getLocalName ();
  }

  @Nonnull
  public Schema getSchema ()
  {
    return m_aDocType.getSchema ();
  }
}
