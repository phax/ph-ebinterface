ph-ebinterface
==============

Java library encapsulating the usage of ebInterface 3.0, 3.0.2, 4.0 and 4.1 within your application. 
See [First Steps](https://github.com/phax/ph-ebinterface/wiki/FirstSteps) (English; v3.x) or 
[Erste Schritte](https://github.com/phax/ph-ebinterface/wiki/ErsteSchritte) (Deutsch; v3.x) for some code examples on how to read and write the different ebInterface versions. This is the follow-project for phloc-ebinterface originally residing on Google Code. 

Features:

  * Read and write ebInterface 3.0 invoices
  * Read and write ebInterface 3.0.2 invoices
  * Read and write ebInterface 4.0 invoices
  * Read and write ebInterface 4.1 invoices
  * Validate the signature of ebInterface documents
  * Visualize ebInterface documents as HTML documents

This library is used by [WWW.E-RECHNUNG.GV.AT](http://www.e-rechnung.gv.at) - the Austrian Government "E-Rechnung an die öffentliche Verwaltung" solution for reading ebInterface files!

The library can e.g. be used in combination with the [E-RECHNUNG.GV.AT Webservice Client](https://github.com/phax/erechnung.gv.at-webservice-client) to automatically deliver invoices to the Austrian Government. Alternatively the library [ph-ubl](https://github.com/phax/ph-ubl) is available to read and write UBL 2.0 and 2.1 invoices (and other document types).

#Usage with Maven
```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ebinterface</artifactId>
  <version>3.1.0</version>
</dependency>
```

Technically this library requires [ph-commons](https://github.com/phax/ph-commons) and [ph-xmldsig](https://github.com/phax/ph-xmldsig)

---

On Twitter: <a href="https://twitter.com/philiphelger">Follow @philiphelger</a>
