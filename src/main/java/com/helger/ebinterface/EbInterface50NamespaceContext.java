/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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

import com.helger.commons.annotation.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class EbInterface50NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final EbInterface50NamespaceContext s_aInstance = new EbInterface50NamespaceContext ();
  }

  protected EbInterface50NamespaceContext ()
  {
    addDefaultNamespaceURI (CEbInterface.EBINTERFACE_50_NS);
    // No XMLDSig from this version on
  }

  /**
   * @return The mutable singleton instance. Never <code>null</code>. Please
   *         clone the result before you further modify it.
   */
  @Nonnull
  public static EbInterface50NamespaceContext getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }
}
