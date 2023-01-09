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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;

import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.ebinterface.builder.EbInterfaceWriter;
import com.helger.ebinterface.v50.Ebi50InvoiceType;
import com.helger.ebinterface.v50.Ebi50ItemListType;
import com.helger.ebinterface.v50.Ebi50ListLineItemType;
import com.helger.jaxb.validation.LoggingValidationEventHandler;
import com.helger.xml.serialize.read.DOMReader;

import jakarta.xml.bind.JAXBElement;

/**
 * Test class for class {@link EbInterface50Marshaller}.
 *
 * @author Philip Helger
 */
public final class EbInterface50MarshallerTest
{
  @Test
  public void testReadValid ()
  {
    for (final IReadableResource aExampleFile : EEbInterfaceTestFiles.V50.getTestResources ())
    {
      // Read from file as XML
      final Document aDoc = DOMReader.readXMLDOM (aExampleFile);
      assertNotNull (aDoc);

      final EbInterface50Marshaller aMarshaller = new EbInterface50Marshaller ();
      aMarshaller.setValidationEventHandler (new LoggingValidationEventHandler ().andThen (aMarshaller.getValidationEventHandler ()));

      // Convert to domain object
      final Ebi50InvoiceType aInvoice = aMarshaller.read (aDoc);
      assertNotNull (aExampleFile.getPath (), aInvoice);

      // Convert again to XML document
      final Document aDoc2 = aMarshaller.getAsDocument (aInvoice);
      assertNotNull (aExampleFile.getPath (), aDoc2);
      assertSame (EEbInterfaceVersion.V50,
                  EEbInterfaceVersion.getFromNamespaceURIOrNull (aDoc2.getDocumentElement ().getNamespaceURI ()));

      // Convert to domain object again
      final Ebi50InvoiceType aInvoice2 = aMarshaller.read (aDoc2);
      assertNotNull (aExampleFile.getPath (), aInvoice2);

      // Find the issue
      assertTrue (EqualsHelper.equals (aInvoice.getInvoiceNumber (), aInvoice2.getInvoiceNumber ()));
      assertTrue (EqualsHelper.equals (aInvoice.getInvoiceDate (), aInvoice2.getInvoiceDate ()));
      assertTrue (EqualsHelper.equals (aInvoice.getCancelledOriginalDocument (),
                                       aInvoice2.getCancelledOriginalDocument ()));
      assertTrue (EqualsHelper.equals (aInvoice.getRelatedDocument (), aInvoice2.getRelatedDocument ()));
      assertTrue (EqualsHelper.equals (aInvoice.getAdditionalInformation (), aInvoice2.getAdditionalInformation ()));
      assertTrue (EqualsHelper.equals (aInvoice.getDelivery (), aInvoice2.getDelivery ()));
      assertTrue (EqualsHelper.equals (aInvoice.getBiller (), aInvoice2.getBiller ()));
      assertTrue (EqualsHelper.equals (aInvoice.getInvoiceRecipient (), aInvoice2.getInvoiceRecipient ()));
      assertTrue (EqualsHelper.equals (aInvoice.getOrderingParty (), aInvoice2.getOrderingParty ()));
      assertTrue (EqualsHelper.equals (aInvoice.getDetails ().getFooterDescription (),
                                       aInvoice2.getDetails ().getFooterDescription ()));
      assertTrue (EqualsHelper.equals (aInvoice.getDetails ().getHeaderDescription (),
                                       aInvoice2.getDetails ().getHeaderDescription ()));
      assertEquals (aInvoice.getDetails ().getItemListCount (), aInvoice2.getDetails ().getItemListCount ());
      for (int i = 0; i < aInvoice.getDetails ().getItemListCount (); ++i)
      {
        final Ebi50ItemListType aItemList = aInvoice.getDetails ().getItemListAtIndex (i);
        final Ebi50ItemListType aItemList2 = aInvoice2.getDetails ().getItemListAtIndex (i);
        assertTrue (EqualsHelper.equals (aItemList.getFooterDescription (), aItemList2.getFooterDescription ()));
        assertTrue (EqualsHelper.equals (aItemList.getHeaderDescription (), aItemList2.getHeaderDescription ()));
        assertEquals (aItemList.getListLineItemCount (), aItemList2.getListLineItemCount ());
        for (int j = 0; j < aItemList.getListLineItemCount (); ++j)
        {
          final Ebi50ListLineItemType aItem = aItemList.getListLineItemAtIndex (j);
          final Ebi50ListLineItemType aItem2 = aItemList2.getListLineItemAtIndex (j);
          assertTrue (EqualsHelper.equals (aItem.getAdditionalInformation (), aItem2.getAdditionalInformation ()));
          assertTrue (EqualsHelper.equals (aItem.getArticleNumber (), aItem2.getArticleNumber ()));
          assertTrue (EqualsHelper.equals (aItem.getBillersOrderReference (), aItem2.getBillersOrderReference ()));
          assertTrue (EqualsHelper.equals (aItem.getClassification (), aItem2.getClassification ()));
          assertTrue (EqualsHelper.equals (aItem.getDelivery (), aItem2.getDelivery ()));
          assertTrue (EqualsHelper.equals (aItem.getDescription (), aItem2.getDescription ()));
          assertTrue (EqualsHelper.equals (aItem.getInvoiceRecipientsOrderReference (),
                                           aItem2.getInvoiceRecipientsOrderReference ()));
          assertTrue (EqualsHelper.equals (aItem.getLineItemAmount (), aItem2.getLineItemAmount ()));
          assertTrue (EqualsHelper.equals (aItem.getPositionNumber (), aItem2.getPositionNumber ()));
          assertTrue (EqualsHelper.equals (aItem.getQuantity (), aItem2.getQuantity ()));
          final List <JAXBElement <?>> aRSLL = aItem.getReductionAndSurchargeListLineItemDetails ()
                                                    .getReductionListLineItemOrSurchargeListLineItemOrOtherVATableTaxListLineItem ();
          final List <JAXBElement <?>> aRSLL2 = aItem2.getReductionAndSurchargeListLineItemDetails ()
                                                      .getReductionListLineItemOrSurchargeListLineItemOrOtherVATableTaxListLineItem ();
          assertEquals (aRSLL.size (), aRSLL2.size ());
          for (int k = 0; k < aRSLL.size (); ++k)
          {
            // JAXBElement does not implement equals!
            assertTrue (aRSLL.get (k) + "\nvs.\n" + aRSLL2.get (k),
                        EqualsHelper.equals (aRSLL.get (k), aRSLL2.get (k)));
          }
          assertEquals (aRSLL.getClass (), aRSLL2.getClass ());
          assertTrue (EqualsHelper.equalsCollection (aRSLL, aRSLL2));
          if (false)
            assertTrue ("Error when list has " + aRSLL.size () + " element(s)", EqualsHelper.equals (aRSLL, aRSLL2));
          assertEquals (aItem.getReductionAndSurchargeListLineItemDetails ().getClass (),
                        aItem2.getReductionAndSurchargeListLineItemDetails ().getClass ());
          assertEquals (aItem.getReductionAndSurchargeListLineItemDetails (),
                        aItem2.getReductionAndSurchargeListLineItemDetails ());
          assertTrue (EqualsHelper.equals (aItem.getTaxItem (), aItem2.getTaxItem ()));
          assertTrue (EqualsHelper.equals (aItem.getUnitPrice (), aItem2.getUnitPrice ()));
          assertEquals (aItem, aItem);
        }
        assertEquals (aItemList.getListLineItem (), aItemList2.getListLineItem ());
        assertEquals (aItemList, aItemList2);
      }
      assertTrue (EqualsHelper.equals (aInvoice.getDetails ().getItemList (), aInvoice2.getDetails ().getItemList ()));
      assertTrue (EqualsHelper.equals (aInvoice.getDetails (), aInvoice2.getDetails ()));
      assertTrue (EqualsHelper.equals (aInvoice.getReductionAndSurchargeDetails (),
                                       aInvoice2.getReductionAndSurchargeDetails ()));
      assertTrue (EqualsHelper.equals (aInvoice.getTax (), aInvoice2.getTax ()));
      assertTrue (EqualsHelper.equals (aInvoice.getTotalGrossAmount (), aInvoice2.getTotalGrossAmount ()));
      assertTrue (EqualsHelper.equals (aInvoice.getPrepaidAmount (), aInvoice2.getPrepaidAmount ()));
      assertTrue (EqualsHelper.equals (aInvoice.getRoundingAmount (), aInvoice2.getRoundingAmount ()));
      assertTrue (EqualsHelper.equals (aInvoice.getPayableAmount (), aInvoice2.getPayableAmount ()));
      assertTrue (EqualsHelper.equals (aInvoice.getPaymentMethod (), aInvoice2.getPaymentMethod ()));
      assertTrue (EqualsHelper.equals (aInvoice.getPaymentConditions (), aInvoice2.getPaymentConditions ()));
      assertTrue (EqualsHelper.equals (aInvoice.getComment (), aInvoice2.getComment ()));
      assertTrue (EqualsHelper.equals (aInvoice.getGeneratingSystem (), aInvoice2.getGeneratingSystem ()));
      assertTrue (EqualsHelper.equals (aInvoice.getDocumentType (), aInvoice2.getDocumentType ()));
      assertTrue (EqualsHelper.equals (aInvoice.getInvoiceCurrency (), aInvoice2.getInvoiceCurrency ()));
      assertTrue (EqualsHelper.equals (aInvoice.isManualProcessing (), aInvoice2.isManualProcessing ()));
      assertTrue (EqualsHelper.equals (aInvoice.getDocumentTitle (), aInvoice2.getDocumentTitle ()));
      assertTrue (EqualsHelper.equals (aInvoice.getLanguage (), aInvoice2.getLanguage ()));
      assertTrue (EqualsHelper.equals (aInvoice.isIsDuplicate (), aInvoice2.isIsDuplicate ()));

      // Must be equals
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice.clone ());
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice2, aInvoice2.clone ());
      assertEquals (EbInterfaceWriter.ebInterface50 ().getAsString (aInvoice),
                    EbInterfaceWriter.ebInterface50 ().getAsString (aInvoice2));
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aInvoice, aInvoice2);
    }
  }
}
