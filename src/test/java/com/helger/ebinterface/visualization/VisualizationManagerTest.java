/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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

import org.junit.Test;

import com.helger.commons.io.file.FilenameHelper;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.ebinterface.EEbInterfaceTestFiles;
import com.helger.ebinterface.EEbInterfaceVersion;

/**
 * Test class for class {@link VisualizationManager}
 *
 * @author Philip Helger
 */
public final class VisualizationManagerTest
{
  private static File _buildHTMLFileName (final IReadableResource aExampleFile)
  {
    return new File ("target/" + FilenameHelper.getBaseName (aExampleFile.getPath ()) + ".html");
  }

  @Test
  public void testV30 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V30.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V30, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV302 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V302.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V302, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV40 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V40.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V40, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV41 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V41.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V41, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV42 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V42.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V42, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV43 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V43.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V43, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV50 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V50.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V50, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV60 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V60.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V60, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }

  @Test
  public void testV61 ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V61.getTestResources ())
    {
      VisualizationManager.visualizeToFile (EEbInterfaceVersion.V61, aExampleFile, _buildHTMLFileName (aExampleFile));
    }
  }
}
