/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.resource.IReadableResource;

public enum EEbInterfaceTestFiles
{
  V30 ("external/ebinterface/v30/",
       new String [] { "230A001-FA08-3242.XML",
                       "230A004-FA08-3244.XML",
                       "230A004-FA08-3245.XML",
                       "beispielwordrechnung.xml",
                       // "ebInterface_Instance_withExtension.xml",
                       "ebInterface-Beispiel-GU-public.xml",
                       "ebInterface-Beispiel-RE-public.xml",
                       // "InvoiceExample-invalid.xml",
                       // "InvoiceExample1.xml",
                       "valid1.xml",
                       "valid2.xml",
                       "valid3.xml",
                       "valid4.xml",
                       "valid5.xml",
                       "valid6.xml",
       // "valid6-signed.xml",
       }),
  V302 ("external/ebinterface/v302/",
        new String [] { "2011-0001-2011-09-12.XML",
                        // "InvoiceExample-invalid.xml",
                        "InvoiceExample1.xml",
                        "InvoiceExample2.xml",
                        "mesonic1-corrupted.xml",
                        "mesonic1.xml",
                        "mesonic2-corrupted.xml",
                        "mesonic2.xml",
                        "mesonic3-corrupted.xml",
                        "valid_and_signed.xml", }),
  V40 ("external/ebinterface/v40/",
       new String [] { "86516_203053.xml",
                       "86523_203054.xml",
                       "86525_203055.xml",
                       "86526_203056.xml",
                       "86528_203057.xml",
                       "86529_203058.xml",
                       // "ebinterface4-signed.xml",
                       "ebinterface4-test1.xml",
                       // "ebinterface4-test1-noprefix.xml",
                       "ebinterface4-test2.xml",
                       "handysignature.xml",
                       // "Rechnung-R_00156_3_00.xml",
                       // "testinstance-invalid-billerscontractpartnernumber.xml",
                       // "testinstance-invalid-schema.xml",
                       // "testinstance-invalid-svnr.xml",
                       // "testinstance-no-billerscontractpartnernumberpresent.xml",
                       "testinstance-no-svnr.xml",
                       // "testinstance-valid-billerscontractpartnernumber.xml",
                       "testinstance-valid-schema.xml",
       // "testinstance-valid-sv.xml",
       // "testinstance-valid-svnr.xml",
       }),
  V41 ("external/ebinterface/v41/", new String [] { "testinstance-valid-schema.xml" }),
  V42 ("external/ebinterface/v42/", new String [] { "testinstance-valid-schema.xml" }),
  V43 ("external/ebinterface/v43/",
       new String [] { "testinstance-tax-exemption.xml", "testinstance-valid-schema.xml" }),
  V50 ("external/ebinterface/v50/", new String [] { "testinstance-valid-schema.xml" }),
  V60 ("external/ebinterface/v60/",
       new String [] { "ebinterface_6p0_sample_dokumentation.xml",
                       // "ebinterface_6p0_sample_ecosio_invalid.xml",
                       "ebinterface_6p0_sample_ecosio.xml",
                       "ebinterface_6p0_sample_ph1.xml" }),
  V61 ("external/ebinterface/v61/",
       new String [] { "ebinterface_6p1_sample_dokumentation.xml",
                       // "ebinterface_6p1_sample_ecosio_invalid.xml",
                       "ebinterface_6p1_sample_ecosio.xml",
                       "ebinterface_6p1_sample_more_consistent.xml",
                       "ebinterface_6p1_sample_ph1.xml" });

  private final ICommonsList <IReadableResource> m_aTestFiles = new CommonsArrayList <> ();

  EEbInterfaceTestFiles (@Nonnull @Nonempty final String sBaseDir, @Nonnull final String [] aFiles)
  {
    for (final String sFile : aFiles)
      m_aTestFiles.add (new ClassPathResource (sBaseDir + sFile));
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <IReadableResource> getTestResources ()
  {
    return m_aTestFiles.getClone ();
  }
}
