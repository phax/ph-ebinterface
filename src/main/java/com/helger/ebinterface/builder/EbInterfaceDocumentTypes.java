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
package com.helger.ebinterface.builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.ArrayHelper;
import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.ICommonsMap;
import com.helger.commons.collection.impl.ICommonsSet;

/**
 * ebInterface document type map. Provides sanity methods for accessing
 * ebInterface document types based on different information items.
 *
 * @author Philip Helger
 */
@Immutable
public final class EbInterfaceDocumentTypes
{
  /** Maps namespaces to document types */
  private static final ICommonsMap <String, EEbInterfaceDocumentType> s_aNamespace2DocType = new CommonsHashMap <> ();

  static
  {
    // Register all ebInterface document types
    for (final EEbInterfaceDocumentType eDocType : EEbInterfaceDocumentType.values ())
    {
      // add to namespace map
      final String sNamespace = eDocType.getNamespaceURI ();
      if (s_aNamespace2DocType.containsKey (sNamespace))
        throw new IllegalArgumentException ("The namespace '" + sNamespace + "' is already mapped!");
      s_aNamespace2DocType.put (sNamespace, eDocType);
    }
  }

  @PresentForCodeCoverage
  private static final EbInterfaceDocumentTypes s_aInstance = new EbInterfaceDocumentTypes ();

  private EbInterfaceDocumentTypes ()
  {}

  /**
   * @return A non-<code>null</code> set of all supported ebInterface
   *         namespaces.
   */
  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsSet <String> getAllNamespaces ()
  {
    return s_aNamespace2DocType.copyOfKeySet ();
  }

  /**
   * Get the document type matching the passed namespace.
   *
   * @param sNamespace
   *        The namespace URI of any ebInterface document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no ebInterface document type matching the
   *         specified namespace URI exists.
   */
  @Nullable
  public static EEbInterfaceDocumentType getDocumentTypeOfNamespace (@Nullable final String sNamespace)
  {
    return s_aNamespace2DocType.get (sNamespace);
  }

  /**
   * Get the domain object class of the passed namespace.
   *
   * @param sNamespace
   *        The namespace URI of any ebInterface document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no such ebInterface document type exists.
   */
  @Nullable
  public static Class <?> getImplementationClassOfNamespace (@Nullable final String sNamespace)
  {
    final EEbInterfaceDocumentType eDocType = getDocumentTypeOfNamespace (sNamespace);
    return eDocType == null ? null : eDocType.getImplementationClass ();
  }

  /**
   * Get the XSD Schema object for the ebInterface document type of the passed
   * namespace.
   *
   * @param sNamespace
   *        The namespace URI of any ebInterface document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no such ebInterface document type exists.
   */
  @Nullable
  public static Schema getSchemaOfNamespace (@Nullable final String sNamespace)
  {
    final EEbInterfaceDocumentType eDocType = getDocumentTypeOfNamespace (sNamespace);
    return eDocType == null ? null : eDocType.getSchema ();
  }

  /**
   * Get the ebInterface document type matching the passed implementation class.
   *
   * @param aImplClass
   *        The implementation class to use. May be <code>null</code>.
   * @return <code>null</code> if the implementation class is <code>null</code>
   *         or if no ebInterface document type has the specified implementation
   *         class.
   */
  @Nullable
  public static EEbInterfaceDocumentType getDocumentTypeOfImplementationClass (@Nullable final Class <?> aImplClass)
  {
    if (aImplClass == null)
      return null;
    return ArrayHelper.findFirst (EEbInterfaceDocumentType.values (),
                                  eDocType -> eDocType.getImplementationClass ().equals (aImplClass));
  }

  /**
   * Get the XSD Schema object for the ebInterface document type of the passed
   * implementation class.
   *
   * @param aImplClass
   *        The implementation class of any ebInterface document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no such ebInterface document type exists.
   */
  @Nullable
  public static Schema getSchemaOfImplementationClass (@Nullable final Class <?> aImplClass)
  {
    final EEbInterfaceDocumentType eDocType = getDocumentTypeOfImplementationClass (aImplClass);
    return eDocType == null ? null : eDocType.getSchema ();
  }
}
