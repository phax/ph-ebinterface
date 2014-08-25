/**
 * Copyright (C) 2006-2014 phloc systems (www.phloc.com)
 * Copyright (C) 2014 Philip Helger (www.helger.com)
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
package com.helger.ebinterface.visualization;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.io.IReadableResource;
import com.helger.commons.state.ESuccess;
import com.helger.commons.xml.XMLFactory;
import com.helger.commons.xml.transform.TransformSourceFactory;
import com.helger.commons.xml.transform.XMLTransformerFactory;
import com.helger.ebinterface.EEbInterfaceVersion;

/**
 * This class is responsible for visualizing ebInterface documents as HTML
 * documents.
 * 
 * @author Philip Helger
 */
@ThreadSafe
public final class VisualizationManager
{
  private static final Logger s_aLogger = LoggerFactory.getLogger (VisualizationManager.class);
  // Map<NamespaceURI, Templates>
  private static final Map <String, Templates> s_aTemplates = new HashMap <String, Templates> ();
  private static final ReadWriteLock s_aRWLock = new ReentrantReadWriteLock ();

  private VisualizationManager ()
  {}

  /**
   * Get the precompiled XSLT template to be used. It is lazily initialized upon
   * first call.
   * 
   * @return The XSLT {@link Templates} to be used to visualize invoices or
   *         <code>null</code> if the template is buggy!
   */
  @Nullable
  public static Templates getXSLTTemplates (@Nonnull final EEbInterfaceVersion eVersion)
  {
    final String sNamespaceURI = eVersion.getNamespaceURI ();
    Templates ret;
    s_aRWLock.readLock ().lock ();
    try
    {
      ret = s_aTemplates.get (sNamespaceURI);
    }
    finally
    {
      s_aRWLock.readLock ().unlock ();
    }

    if (ret == null)
    {
      s_aRWLock.writeLock ().lock ();
      try
      {
        // Try again in write lock
        ret = s_aTemplates.get (sNamespaceURI);
        if (ret == null)
        {
          // Definitely not present - init
          final IReadableResource aXSLTRes = eVersion.getXSLTResource ();
          ret = XMLTransformerFactory.newTemplates (aXSLTRes);
          if (ret == null)
            s_aLogger.error ("Failed to parse XSLT template " + aXSLTRes);
          else
            if (s_aLogger.isDebugEnabled ())
              s_aLogger.debug ("Compiled XSLT template " + aXSLTRes);
          s_aTemplates.put (sNamespaceURI, ret);
        }
      }
      finally
      {
        s_aRWLock.writeLock ().unlock ();
      }
    }
    return ret;
  }

  @Nonnull
  public static ESuccess visualize (@Nonnull final EEbInterfaceVersion eVersion,
                                    @Nonnull final Source aSource,
                                    @Nonnull final Result aResult)
  {
    if (eVersion == null)
      throw new NullPointerException ("artefact");

    // Get cache XSL templates
    final Templates aTemplates = getXSLTTemplates (eVersion);
    if (aTemplates == null)
      return ESuccess.FAILURE;

    // Start the main transformation
    try
    {
      final Transformer aTransformer = aTemplates.newTransformer ();
      aTransformer.transform (aSource, aResult);
      return ESuccess.SUCCESS;
    }
    catch (final TransformerException ex)
    {
      s_aLogger.error ("Failed to apply transformation for ebInterface " + eVersion + " invoice", ex);
      return ESuccess.FAILURE;
    }
  }

  @Nullable
  public static Document visualizeToDOMDocument (@Nonnull final EEbInterfaceVersion eVersion,
                                                 @Nonnull final Source aSource)
  {
    final Document aDoc = XMLFactory.newDocument ();
    return visualize (eVersion, aSource, new DOMResult (aDoc)).isSuccess () ? aDoc : null;
  }

  @Nullable
  public static Document visualizeToDOMDocument (@Nonnull final EEbInterfaceVersion eVersion,
                                                 @Nonnull final IReadableResource aResource)
  {
    return visualizeToDOMDocument (eVersion, TransformSourceFactory.create (aResource));
  }

  @Nullable
  public static ESuccess visualizeToFile (@Nonnull final EEbInterfaceVersion eVersion,
                                          @Nonnull final Source aSource,
                                          @Nonnull final File aDestinationFile)
  {
    return visualize (eVersion, aSource, new StreamResult (aDestinationFile));
  }

  @Nullable
  public static ESuccess visualizeToFile (@Nonnull final EEbInterfaceVersion eVersion,
                                          @Nonnull final IReadableResource aResource,
                                          @Nonnull final File aDestinationFile)
  {
    return visualize (eVersion, TransformSourceFactory.create (aResource), new StreamResult (aDestinationFile));
  }
}
