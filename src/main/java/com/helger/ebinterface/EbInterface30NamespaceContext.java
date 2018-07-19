/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
import javax.xml.crypto.dsig.XMLSignature;

import com.helger.commons.annotation.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xmldsig.XMLDSigCreator;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class EbInterface30NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final EbInterface30NamespaceContext s_aInstance = new EbInterface30NamespaceContext ();
  }

  protected EbInterface30NamespaceContext ()
  {
    addMapping ("eb", CEbInterface.EBINTERFACE_30_NS);
    addMapping (XMLDSigCreator.DEFAULT_NS_PREFIX, XMLSignature.XMLNS);
  }

  @Nonnull
  public static EbInterface30NamespaceContext getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }
}
