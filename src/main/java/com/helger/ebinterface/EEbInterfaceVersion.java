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
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.AbstractJAXBMarshaller;

/**
 * This enumeration encapsulates the supported ebInterface versions in a common
 * way.
 *
 * @author Philip Helger
 */
public enum EEbInterfaceVersion
{
 /** ebInterface 3.0 */
  V30 (CEbInterface.EBINTERFACE_30_NS, CEbInterface.EBINTERFACE_30_XSLT)
  {
    @Override
    public EbInterface30Marshaller createMarshaller ()
    {
      return new EbInterface30Marshaller ();
    }
  },
 /** ebInterface 3.02 */
  V302 (CEbInterface.EBINTERFACE_302_NS, CEbInterface.EBINTERFACE_302_XSLT)
  {
    @Override
    public EbInterface302Marshaller createMarshaller ()
    {
      return new EbInterface302Marshaller ();
    }
  },
 /** ebInterface 4.0 */
  V40 (CEbInterface.EBINTERFACE_40_NS, CEbInterface.EBINTERFACE_40_XSLT)
  {
    @Override
    public EbInterface40Marshaller createMarshaller ()
    {
      return new EbInterface40Marshaller ();
    }
  },
 /** ebInterface 4.1 */
  V41 (CEbInterface.EBINTERFACE_41_NS, CEbInterface.EBINTERFACE_41_XSLT)
  {
    @Override
    public EbInterface41Marshaller createMarshaller ()
    {
      return new EbInterface41Marshaller ();
    }
  },
 /** ebInterface 4.2 */
  V42 (CEbInterface.EBINTERFACE_42_NS, CEbInterface.EBINTERFACE_42_XSLT)
  {
    @Override
    public EbInterface42Marshaller createMarshaller ()
    {
      return new EbInterface42Marshaller ();
    }
  };

  private final String m_sNamespaceURI;
  private final IReadableResource m_aXSLTRes;

  private EEbInterfaceVersion (@Nonnull @Nonempty final String sNamespaceURI, @Nonnull final IReadableResource aXSLTRes)
  {
    m_sNamespaceURI = sNamespaceURI;
    m_aXSLTRes = aXSLTRes;
  }

  /**
   * @return The namespace URI for this ebInterface version
   */
  @Nonnull
  @Nonempty
  public String getNamespaceURI ()
  {
    return m_sNamespaceURI;
  }

  /**
   * @return The resource to be used to visualize ebInterface invoices of this
   *         version
   */
  @Nonnull
  public IReadableResource getXSLTResource ()
  {
    return m_aXSLTRes;
  }

  /**
   * @return A new marshaller that reads and writes the respective invoice
   *         objects. Each time this method is invoked, a new marshaller is
   *         created.
   */
  @Nonnull
  public abstract AbstractJAXBMarshaller <?> createMarshaller ();

  /**
   * Get the ebInterface version that matches the specified namespace.
   *
   * @param sNamespaceURI
   *        The namespace URI to resolve. May be <code>null</code>.
   * @return <code>null</code> if the passed namespace URI could not be resolved
   *         to a supported ebInterface version.
   */
  @Nullable
  public static EEbInterfaceVersion getFromNamespaceURIOrNull (@Nullable final String sNamespaceURI)
  {
    if (StringHelper.hasText (sNamespaceURI))
      for (final EEbInterfaceVersion eVersion : values ())
        if (sNamespaceURI.equals (eVersion.getNamespaceURI ()))
          return eVersion;
    return null;
  }
}
