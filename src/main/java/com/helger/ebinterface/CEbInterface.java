/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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

import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.resource.IReadableResource;

/**
 * Contains all the constants for ebInterface handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CEbInterface
{
  /** XML Schema resource for XMLDSig */
  public static final ClassPathResource XSD_XMLDSIG_RESOURCE = new ClassPathResource ("/schemas/xmldsig-core-schema.xsd");

  /** XML Schema resources for ebInterface 3.0 */
  public static final List <? extends IReadableResource> EBINTERFACE_30_XSDS = CollectionHelper.makeUnmodifiable (XSD_XMLDSIG_RESOURCE,
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebinterface-3.0.xsd"));

  /** XML Schema resources for ebInterface 3.0.2 */
  public static final List <? extends IReadableResource> EBINTERFACE_302_XSDS = CollectionHelper.makeUnmodifiable (XSD_XMLDSIG_RESOURCE,
                                                                                                                   new ClassPathResource ("/schemas/ebinterface/ebinterface-3.0.2.xsd"));

  /** XML Schema resources for ebInterface 4.0 */
  public static final List <? extends IReadableResource> EBINTERFACE_40_XSDS = CollectionHelper.makeUnmodifiable (XSD_XMLDSIG_RESOURCE,
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.0.xsd"),
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ext40/ebInterfaceExtension_SV.xsd"),
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebinterface-4.0.xsd"));

  /** XML Schema resources for ebInterface 4.1 */
  public static final List <? extends IReadableResource> EBINTERFACE_41_XSDS = CollectionHelper.makeUnmodifiable (XSD_XMLDSIG_RESOURCE,
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.1.xsd"),
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ext41/ebInterfaceExtension_SV.xsd"),
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebinterface-4.1.xsd"));

  /** XML Schema resources for ebInterface 4.2 */
  public static final List <? extends IReadableResource> EBINTERFACE_42_XSDS = CollectionHelper.makeUnmodifiable (XSD_XMLDSIG_RESOURCE,
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.2.xsd"),
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ext42/ebInterfaceExtension_SV.xsd"),
                                                                                                                  new ClassPathResource ("/schemas/ebinterface/ebinterface-4.2.xsd"));

  /** Namespace URI for ebInterface 3.0 */
  public static final String EBINTERFACE_30_NS = "http://www.ebinterface.at/schema/3p0/";

  /** Namespace URI for ebInterface 3.0.2 */
  public static final String EBINTERFACE_302_NS = "http://www.ebinterface.at/schema/3p02/";

  /** Namespace URI for ebInterface 4.0 */
  public static final String EBINTERFACE_40_NS = "http://www.ebinterface.at/schema/4p0/";

  /** Namespace URI for ebInterface 4.1 */
  public static final String EBINTERFACE_41_NS = "http://www.ebinterface.at/schema/4p1/";

  /** Namespace URI for ebInterface 4.2 */
  public static final String EBINTERFACE_42_NS = "http://www.ebinterface.at/schema/4p2/";

  /** Stylesheet resource for ebInterface 3.0 */
  public static final IReadableResource EBINTERFACE_30_XSLT = new ClassPathResource ("/visualization/ebInterface-3.0.xslt");

  /** Stylesheet resource for ebInterface 3.0.2 */
  public static final IReadableResource EBINTERFACE_302_XSLT = new ClassPathResource ("/visualization/ebInterface-3.0.2.xslt");

  /** Stylesheet resource for ebInterface 4.0 */
  public static final IReadableResource EBINTERFACE_40_XSLT = new ClassPathResource ("/visualization/ebInterface-4.0.xslt");

  /** Stylesheet resource for ebInterface 4.1 */
  public static final IReadableResource EBINTERFACE_41_XSLT = new ClassPathResource ("/visualization/ebInterface-4.1.xslt");

  /** Stylesheet resource for ebInterface 4.2 */
  public static final IReadableResource EBINTERFACE_42_XSLT = new ClassPathResource ("/visualization/ebInterface-4.2.xslt");

  @PresentForCodeCoverage
  private static final CEbInterface s_aInstance = new CEbInterface ();

  private CEbInterface ()
  {}
}
