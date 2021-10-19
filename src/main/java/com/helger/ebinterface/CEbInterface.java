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

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * Contains all the constants for ebInterface handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CEbInterface
{
  @Nonnull
  private static ClassLoader _getCL ()
  {
    return CEbInterface.class.getClassLoader ();
  }

  /** XML Schema resources for ebInterface 3.0 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_30_XSDS = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebinterface-3.0.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 3.0.2 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_302_XSDS = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                               new ClassPathResource ("/schemas/ebinterface/ebinterface-3.0.2.xsd",
                                                                                                                      _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 4.0 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_40_XSDS = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.0.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ext40/ebInterfaceExtension_SV.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebinterface-4.0.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 4.1 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_41_XSDS = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.1.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ext41/ebInterfaceExtension_SV.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebinterface-4.1.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 4.2 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_42_XSDS = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.2.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ext42/ebInterfaceExtension_SV.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebinterface-4.2.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 4.3 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_43_XSDS = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebInterfaceExtension-4.3.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ext43/ebInterfaceExtension_SV.xsd",
                                                                                                                     _getCL ()),
                                                                                              new ClassPathResource ("/schemas/ebinterface/ebinterface-4.3.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 5.0 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_50_XSDS = new CommonsArrayList <> (new ClassPathResource ("/schemas/ebinterface/ebinterface-5.0.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** XML Schema resources for ebInterface 6.0 */
  @CodingStyleguideUnaware
  public static final List <ClassPathResource> EBINTERFACE_60_XSDS = new CommonsArrayList <> (new ClassPathResource ("/schemas/ebinterface/ebinterface-6.0.xsd",
                                                                                                                     _getCL ())).getAsUnmodifiable ();

  /** Namespace URI for ebInterface 3.0 */
  public static final String EBINTERFACE_30_NS = "http://www.ebinterface.at/schema/3p0/";

  /** Namespace URI for ebInterface 3.0.2 */
  public static final String EBINTERFACE_302_NS = "http://www.ebinterface.at/schema/3p02/";

  /** Namespace URI for ebInterface 4.0 */
  public static final String EBINTERFACE_40_NS = "http://www.ebinterface.at/schema/4p0/";
  public static final String EBINTERFACE_40_NS_EXT = "http://www.ebinterface.at/schema/4p0/extensions/ext";
  public static final String EBINTERFACE_40_NS_SV = "http://www.ebinterface.at/schema/4p0/extensions/sv";

  /** Namespace URI for ebInterface 4.1 */
  public static final String EBINTERFACE_41_NS = "http://www.ebinterface.at/schema/4p1/";
  public static final String EBINTERFACE_41_NS_EXT = "http://www.ebinterface.at/schema/4p1/extensions/ext";
  public static final String EBINTERFACE_41_NS_SV = "http://www.ebinterface.at/schema/4p1/extensions/sv";

  /** Namespace URI for ebInterface 4.2 */
  public static final String EBINTERFACE_42_NS = "http://www.ebinterface.at/schema/4p2/";
  public static final String EBINTERFACE_42_NS_EXT = "http://www.ebinterface.at/schema/4p2/extensions/ext";
  public static final String EBINTERFACE_42_NS_SV = "http://www.ebinterface.at/schema/4p2/extensions/sv";

  /** Namespace URI for ebInterface 4.3 */
  public static final String EBINTERFACE_43_NS = "http://www.ebinterface.at/schema/4p3/";
  public static final String EBINTERFACE_43_NS_EXT = "http://www.ebinterface.at/schema/4p3/extensions/ext";
  public static final String EBINTERFACE_43_NS_SV = "http://www.ebinterface.at/schema/4p3/extensions/sv";

  /** Namespace URI for ebInterface 5.0 */
  public static final String EBINTERFACE_50_NS = "http://www.ebinterface.at/schema/5p0/";

  /** Namespace URI for ebInterface 6.0 */
  public static final String EBINTERFACE_60_NS = "http://www.ebinterface.at/schema/6p0/";

  /** Stylesheet resource for ebInterface 3.0 */
  public static final IReadableResource EBINTERFACE_30_XSLT = new ClassPathResource ("/visualization/ebInterface-3.0.xslt",
                                                                                     _getCL ());

  /** Stylesheet resource for ebInterface 3.0.2 */
  public static final IReadableResource EBINTERFACE_302_XSLT = new ClassPathResource ("/visualization/ebInterface-3.0.2.xslt",
                                                                                      _getCL ());

  /** Stylesheet resource for ebInterface 4.0 */
  public static final IReadableResource EBINTERFACE_40_XSLT = new ClassPathResource ("/visualization/ebInterface-4.0.xslt",
                                                                                     _getCL ());

  /** Stylesheet resource for ebInterface 4.1 */
  public static final IReadableResource EBINTERFACE_41_XSLT = new ClassPathResource ("/visualization/ebInterface-4.1.xslt",
                                                                                     _getCL ());

  /** Stylesheet resource for ebInterface 4.2 */
  public static final IReadableResource EBINTERFACE_42_XSLT = new ClassPathResource ("/visualization/ebInterface-4.2.xslt",
                                                                                     _getCL ());

  /** Stylesheet resource for ebInterface 4.3 */
  public static final IReadableResource EBINTERFACE_43_XSLT = new ClassPathResource ("/visualization/ebInterface-4.3.xslt",
                                                                                     _getCL ());

  /** Stylesheet resource for ebInterface 5.0 */
  public static final IReadableResource EBINTERFACE_50_XSLT = new ClassPathResource ("/visualization/ebInterface-5.0.xslt",
                                                                                     _getCL ());

  /** Stylesheet resource for ebInterface 6.0 */
  public static final IReadableResource EBINTERFACE_60_XSLT = new ClassPathResource ("/visualization/ebInterface-6.0.xslt",
                                                                                     _getCL ());

  @PresentForCodeCoverage
  private static final CEbInterface s_aInstance = new CEbInterface ();

  private CEbInterface ()
  {}
}
