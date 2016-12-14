#ph-ebinterface

Java library encapsulating the usage of ebInterface 3.0, 3.0.2, 4.0, 4.1, 4.2 and 4.3 within your application. 
See [First Steps](https://github.com/phax/ph-ebinterface/wiki/FirstSteps) (English; v3.x) or 
[Erste Schritte](https://github.com/phax/ph-ebinterface/wiki/ErsteSchritte) (Deutsch; v3.x) for some code examples on how to read and write the different ebInterface versions.

Features:

  * Read and write ebInterface 3.0 invoices
  * Read and write ebInterface 3.0.2 invoices
  * Read and write ebInterface 4.0 invoices
  * Read and write ebInterface 4.1 invoices
  * Read and write ebInterface 4.2 invoices
  * Read and write ebInterface 4.3 invoices
  * Validate the signature of ebInterface documents
  * Visualize ebInterface documents as HTML documents
  
#News and noteworthy
  * Version 5.1.1 - 2016-12-14
    * Fixed case sensitivity error in a filename
  * Version 5.1.0 - 2016-12-13
    * Added support for ebInterface 4.3
  * Version 5.0.1 - 2016-07-15
    * Using a separate artefact for XMLDSig JAXB artefacts for easier reuse (ph-xsds-xmldsig)
  * Version 5.0.0 - 2016-06-11
    * Requires Java 1.8
  * Version 4.0.3 - 2015-11-25
    * Made the `BIC` element in `SEPADirectDebit` of ebInterface 4.2 optional
    * update to BouncyCastle 1.54
  * Version 4.0.2 - 2015-11-25
    * Added support for ebInterface 4.2
  * Version 4.0.1 - 2015-10-19
    * update to BouncyCastle 1.53
  * Version 4.0.0 - 2015-07-23   

This library is used by [WWW.E-RECHNUNG.GV.AT](http://www.e-rechnung.gv.at) - the Austrian Government "E-Rechnung an die öffentliche Verwaltung" solution for reading ebInterface files!

The library can e.g. be used in combination with the [E-RECHNUNG.GV.AT Webservice Client](https://github.com/phax/erechnung.gv.at-webservice-client) to automatically deliver invoices to the Austrian Government. Alternatively the library [ph-ubl](https://github.com/phax/ph-ubl) is available to read and write UBL 2.0 and 2.1 invoices (and other document types).

This is originally the follow-on project of phloc-ebinterface originally residing on Google Code. 

#Usage with Maven
```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ebinterface</artifactId>
  <version>5.1.1</version>
</dependency>
```

Technically this library requires libraries from [ph-commons](https://github.com/phax/ph-commons) and [ph-xmldsig](https://github.com/phax/ph-xmldsig)

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodeingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
