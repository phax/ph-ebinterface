/*
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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
public class EbInterface60NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final EbInterface60NamespaceContext s_aInstance = new EbInterface60NamespaceContext ();
  }

  protected EbInterface60NamespaceContext ()
  {
    addDefaultNamespaceURI (CEbInterface.EBINTERFACE_60_NS);
  }

  /**
   * @return The mutable singleton instance. Never <code>null</code>. Please
   *         clone the result before you further modify it.
   */
  @Nonnull
  public static EbInterface60NamespaceContext getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }
}
