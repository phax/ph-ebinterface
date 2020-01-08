/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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

import java.io.File;

import javax.annotation.Nonnull;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.helger.ebinterface.EbInterface302Marshaller;
import com.helger.ebinterface.EbInterface30Marshaller;
import com.helger.ebinterface.EbInterface40Marshaller;
import com.helger.ebinterface.EbInterface41Marshaller;
import com.helger.ebinterface.EbInterface42Marshaller;
import com.helger.ebinterface.v30.Ebi30InvoiceType;
import com.helger.ebinterface.v302.Ebi302InvoiceType;
import com.helger.ebinterface.v40.Ebi40InvoiceType;
import com.helger.ebinterface.v41.Ebi41InvoiceType;
import com.helger.ebinterface.v42.Ebi42InvoiceType;

/**
 * Diese Tests sind als copy-paste Beispiele fürs Wiki gedacht.
 *
 * @author Philip Helger
 */
public final class WikiReadWriteDEFuncTest
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
  public static Ebi30InvoiceType readEbInterface30 (@Nonnull final File aFile)
  {
    final Ebi30InvoiceType aInvoice = new EbInterface30Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 3.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 3.0 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht <code>null</code> sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 3.0
   *         Rechnung ist
   */
  @Nonnull
  public static Ebi30InvoiceType readEbInterface30 (@Nonnull final Node aNode)
  {
    final Ebi30InvoiceType aInvoice = new EbInterface30Marshaller ().read (aNode);
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
  public static Ebi302InvoiceType readEbInterface302 (@Nonnull final File aFile)
  {
    final Ebi302InvoiceType aInvoice = new EbInterface302Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 3.0.2 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 3.0.2 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht <code>null</code> sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 3.0.2
   *         Rechnung ist
   */
  @Nonnull
  public static Ebi302InvoiceType readEbInterface302 (@Nonnull final Node aNode)
  {
    final Ebi302InvoiceType aInvoice = new EbInterface302Marshaller ().read (aNode);
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
  public static Ebi40InvoiceType readEbInterface40 (@Nonnull final File aFile)
  {
    final Ebi40InvoiceType aInvoice = new EbInterface40Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 4.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 4.0 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht <code>null</code> sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 4.0
   *         Rechnung ist
   */
  @Nonnull
  public static Ebi40InvoiceType readEbInterface40 (@Nonnull final Node aNode)
  {
    final Ebi40InvoiceType aInvoice = new EbInterface40Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Der angegebene DOM Knoten ist kein valides ebInterface 4.0 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 4.1 Rechnung aus einer Datei.
   *
   * @param aFile
   *        Die Datei aus der die Rechnung gelesen werden soll. Darf nicht null
   *        sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Datei keine gültige ebInterface 4.1 Rechnung
   *         ist
   */
  @Nonnull
  public static Ebi41InvoiceType readEbInterface41 (@Nonnull final File aFile)
  {
    final Ebi41InvoiceType aInvoice = new EbInterface41Marshaller ().read (aFile);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Die angebene Datei ist kein valides ebInterface 4.1 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Lese eine ebInterface 4.1 Rechnung aus einem XML DOM Knoten.
   *
   * @param aNode
   *        Der existierende DOM Knoten. Darf nicht <code>null</code> sein.
   * @return Die gelesene Rechnung.
   * @throws IllegalArgumentException
   *         Falls der Inhalt des DOM Knotens keine gültige ebInterface 4.1
   *         Rechnung ist
   */
  @Nonnull
  public static Ebi41InvoiceType readEbInterface41 (@Nonnull final Node aNode)
  {
    final Ebi41InvoiceType aInvoice = new EbInterface41Marshaller ().read (aNode);
    if (aInvoice == null)
      throw new IllegalArgumentException ("Der angegebene DOM Knoten ist kein valides ebInterface 4.1 Dokument. Auf der Konsole befinden sich die Details.");
    return aInvoice;
  }

  /**
   * Schreibt die angegebene ebInterface 3.0 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht
   *        <code>null</code> sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  public static void writeEbInterface30File (@Nonnull final Ebi30InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface30Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 3.0 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @return Das ebInterface-Dokument als XML DOM Document.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public static Document getEbInterface30Document (@Nonnull final Ebi30InvoiceType aInvoice)
  {
    final Document ret = new EbInterface30Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }

  /**
   * Schreibt die angegebene ebInterface 3.0.2 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht
   *        <code>null</code> sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  public static void writeEbInterface302File (@Nonnull final Ebi302InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface302Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0.2 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 3.0.2 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @return Das ebInterface-Dokument als XML DOM Document.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public static Document getEbInterface302Document (@Nonnull final Ebi302InvoiceType aInvoice)
  {
    final Document ret = new EbInterface302Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 3.0.2 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }

  /**
   * Schreibt die angegebene ebInterface 4.0 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht
   *        <code>null</code> sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  public static void writeEbInterface40File (@Nonnull final Ebi40InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface40Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.0 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 4.0 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @return Das ebInterface-Dokument als XML DOM Document.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public static Document getEbInterface40Document (@Nonnull final Ebi40InvoiceType aInvoice)
  {
    final Document ret = new EbInterface40Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.0 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }

  /**
   * Schreibt die angegebene ebInterface 4.1 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht
   *        <code>null</code> sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  public static void writeEbInterface41File (@Nonnull final Ebi41InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface41Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.1 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 4.1 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @return Das ebInterface-Dokument als XML DOM Document.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public static Document getEbInterface41Document (@Nonnull final Ebi41InvoiceType aInvoice)
  {
    final Document ret = new EbInterface41Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.1 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }

  /**
   * Schreibt die angegebene ebInterface 4.2 Rechnung in die angegebene Datei.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @param aFile
   *        Die Zieldatei in die geschrieben werden soll. Darf nicht
   *        <code>null</code> sein.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht auf die Platte geschrieben werden kann.
   */
  public static void writeEbInterface42File (@Nonnull final Ebi42InvoiceType aInvoice, @Nonnull final File aFile)
  {
    if (new EbInterface42Marshaller ().write (aInvoice, aFile).isFailure ())
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.2 Rechnung. Auf der Konsole befinden sich die Details.");
  }

  /**
   * Konvertiert die angegebene ebInterface 4.2 Rechnung in ein XML DOM
   * Dokument.
   *
   * @param aInvoice
   *        Die zu schreibende Rechnung. Darf nicht <code>null</code> sein.
   * @return Das ebInterface-Dokument als XML DOM Document.
   * @throws IllegalArgumentException
   *         Falls der Inhalt der Rechnung ungültig ist und die Rechnung daher
   *         nicht in einen XML DOM Knoten umgewandelt werden kann.
   */
  @Nonnull
  public static Document getEbInterface42Document (@Nonnull final Ebi42InvoiceType aInvoice)
  {
    final Document ret = new EbInterface42Marshaller ().getAsDocument (aInvoice);
    if (ret == null)
      throw new IllegalArgumentException ("Die angebene Rechnung ist keine valide ebInterface 4.2 Rechnung. Auf der Konsole befinden sich die Details.");
    return ret;
  }
}
