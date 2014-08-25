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
package com.helger.ebinterface.supplementary.wiki;

import javax.annotation.Nonnull;

/**
 * Diese Tests sind als copy-paste Beispiele fürs Wiki gedacht.
 *
 * @author Philip Helger
 */
public final class FuncTestWikiReadWriteDE
{
  /**
   * Lese eine ebInterface 3.0 Rechnung aus einer Datei.
   *
   * @param aFile
   *        Die Datei aus der die Rechnung gelesen werden soll. Darf nicht null
   *        sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Datei keine gültige ebInterface 3.0 Rechnung
   *         ist
   */
  @Nonnull
  public com.helger.ebinterface.v30.Ebi30InvoiceType readEbInterface30 (@Nonnull final java.io.File aFile)
  {
    final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice = new com.helger.ebinterface.EbInterface30Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 3.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 3.0 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht null sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 3.0
   *         Rechnung ist
   */
  @Nonnull
  public com.helger.ebinterface.v30.Ebi30InvoiceType readEbInterface30 (@Nonnull final org.w3c.dom.Node aNode)
  {
    final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice = new com.helger.ebinterface.EbInterface30Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Der angegebene DOM Knoten ist kein valides ebInterface 3.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 3.0.2 Rechnung aus einer Datei.
   *
   * @param aFile
   *        Die Datei aus der die Rechnung gelesen werden soll. Darf nicht null
   *        sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Datei keine gültige ebInterface 3.0.2 Rechnung
   *         ist
   */
  @Nonnull
  public com.helger.ebinterface.v302.Ebi302InvoiceType readEbInterface302 (@Nonnull final java.io.File aFile)
  {
    final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice = new com.helger.ebinterface.EbInterface302Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 3.0.2 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 3.0.2 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht null sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 3.0.2
   *         Rechnung ist
   */
  @Nonnull
  public com.helger.ebinterface.v302.Ebi302InvoiceType readEbInterface302 (@Nonnull final org.w3c.dom.Node aNode)
  {
    final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice = new com.helger.ebinterface.EbInterface302Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Der angegebene DOM Knoten ist kein valides ebInterface 3.0.2 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 4.0 Rechnung aus einer Datei.
   *
   * @param aFile
   *        Die Datei aus der die Rechnung gelesen werden soll. Darf nicht null
   *        sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Datei keine gültige ebInterface 4.0 Rechnung
   *         ist
   */
  @Nonnull
  public com.helger.ebinterface.v40.Ebi40InvoiceType readEbInterface40 (@Nonnull final java.io.File aFile)
  {
    final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice = new com.helger.ebinterface.EbInterface40Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 4.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 4.0 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht null sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 4.0
   *         Rechnung ist
   */
  @Nonnull
  public com.helger.ebinterface.v40.Ebi40InvoiceType readEbInterface40 (@Nonnull final org.w3c.dom.Node aNode)
  {
    final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice = new com.helger.ebinterface.EbInterface40Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Der angegebene DOM Knoten ist kein valides ebInterface 4.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Schreibt die angegebene ebInterface 3.0 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht null sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht null sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  @Nonnull
  public void writeEbInterface30File (@Nonnull final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice,
                                      @Nonnull final java.io.File aFile)
  {
    if (new com.helger.ebinterface.EbInterface30Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 3.0 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht null sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public org.w3c.dom.Document getEbInterface30Document (@Nonnull final com.helger.ebinterface.v30.Ebi30InvoiceType aInvoice)
  {
    final org.w3c.dom.Document ret = new com.helger.ebinterface.EbInterface30Marshaller ().write (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }

  /**
   * Schreibt die angegebene ebInterface 3.0.2 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht null sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht null sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  @Nonnull
  public void writeEbInterface302File (@Nonnull final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice,
                                       @Nonnull final java.io.File aFile)
  {
    if (new com.helger.ebinterface.EbInterface302Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0.2 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 3.0.2 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht null sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public org.w3c.dom.Document getEbInterface302Document (@Nonnull final com.helger.ebinterface.v302.Ebi302InvoiceType aInvoice)
  {
    final org.w3c.dom.Document ret = new com.helger.ebinterface.EbInterface302Marshaller ().write (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0.2 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }

  /**
   * Schreibt die angegebene ebInterface 4.0 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht null sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht null sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  @Nonnull
  public void writeEbInterface40File (@Nonnull final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice,
                                      @Nonnull final java.io.File aFile)
  {
    if (new com.helger.ebinterface.EbInterface40Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.0 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 4.0 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht null sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public org.w3c.dom.Document getEbInterface40Document (@Nonnull final com.helger.ebinterface.v40.Ebi40InvoiceType aInvoice)
  {
    final org.w3c.dom.Document ret = new com.helger.ebinterface.EbInterface40Marshaller ().write (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.0 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }
}
