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

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.Nonempty;
import com.helger.base.lang.EnumHelper;
import com.helger.base.string.StringHelper;
import com.helger.base.version.Version;
import com.helger.io.resource.IReadableResource;

/**
 * This enumeration encapsulates the supported ebInterface versions in a common way.
 *
 * @author Philip Helger
 */
public enum EEbInterfaceVersion
{
  /** ebInterface 3.0 */
  V30 (CEbInterface.EBINTERFACE_30_NS, CEbInterface.EBINTERFACE_30_XSLT, new Version (3)),
  /** ebInterface 3.02 */
  V302 (CEbInterface.EBINTERFACE_302_NS, CEbInterface.EBINTERFACE_302_XSLT, new Version (3, 0, 2)),
  /** ebInterface 4.0 */
  V40 (CEbInterface.EBINTERFACE_40_NS, CEbInterface.EBINTERFACE_40_XSLT, new Version (4)),
  /** ebInterface 4.1 */
  V41 (CEbInterface.EBINTERFACE_41_NS, CEbInterface.EBINTERFACE_41_XSLT, new Version (4, 1)),
  /** ebInterface 4.2 */
  V42 (CEbInterface.EBINTERFACE_42_NS, CEbInterface.EBINTERFACE_42_XSLT, new Version (4, 2)),
  /** ebInterface 4.3 */
  V43 (CEbInterface.EBINTERFACE_43_NS, CEbInterface.EBINTERFACE_43_XSLT, new Version (4, 3)),
  /** ebInterface 5.0 */
  V50 (CEbInterface.EBINTERFACE_50_NS, CEbInterface.EBINTERFACE_50_XSLT, new Version (5)),
  /** ebInterface 6.0 */
  V60 (CEbInterface.EBINTERFACE_60_NS, CEbInterface.EBINTERFACE_60_XSLT, new Version (6)),
  /** ebInterface 6.1 */
  V61 (CEbInterface.EBINTERFACE_61_NS, CEbInterface.EBINTERFACE_61_XSLT, new Version (6, 1));

  private final String m_sNamespaceURI;
  private final IReadableResource m_aXSLTRes;
  private final Version m_aVersion;

  EEbInterfaceVersion (@NonNull @Nonempty final String sNamespaceURI,
                       @Nullable final IReadableResource aXSLTRes,
                       @NonNull final Version aVersion)
  {
    m_sNamespaceURI = sNamespaceURI;
    m_aXSLTRes = aXSLTRes;
    m_aVersion = aVersion;
  }

  /**
   * @return The namespace URI for this ebInterface version
   */
  @NonNull
  @Nonempty
  public String getNamespaceURI ()
  {
    return m_sNamespaceURI;
  }

  /**
   * @return The resource to be used to visualize ebInterface invoices of this version. May be
   *         <code>null</code> as not all versions have XSLTs assigned.
   */
  @Nullable
  public IReadableResource getXSLTResource ()
  {
    return m_aXSLTRes;
  }

  /**
   * @return <code>true</code> if an XSLT resource for visualization is present, <code>false</code>
   *         if not.
   */
  public boolean hasXSLTResource ()
  {
    return m_aXSLTRes != null;
  }

  /**
   * @return The version number of this ebInterface version. Never <code>null</code>.
   * @since 6.1.1
   */
  @NonNull
  public Version getVersion ()
  {
    return m_aVersion;
  }

  /**
   * Get the ebInterface version that matches the specified namespace.
   *
   * @param sNamespaceURI
   *        The namespace URI to resolve. May be <code>null</code>.
   * @return <code>null</code> if the passed namespace URI could not be resolved to a supported
   *         ebInterface version.
   */
  @Nullable
  public static EEbInterfaceVersion getFromNamespaceURIOrNull (@Nullable final String sNamespaceURI)
  {
    if (StringHelper.isEmpty (sNamespaceURI))
      return null;
    return EnumHelper.findFirst (EEbInterfaceVersion.class, x -> x.getNamespaceURI ().equals (sNamespaceURI));
  }
}
