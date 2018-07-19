# ph-ebinterface

Java library encapsulating the usage of ebInterface 3.0, 3.0.2, 4.0, 4.1, 4.2, 4.3 and 5.0 within your application. 
See [First Steps](https://github.com/phax/ph-ebinterface/wiki/FirstSteps) (English; v3.x) or 
[Erste Schritte](https://github.com/phax/ph-ebinterface/wiki/ErsteSchritte) (Deutsch; v3.x) for some code examples on how to read and write the different ebInterface versions.

Features:

* Read and write ebInterface 3.0 invoices
* Read and write ebInterface 3.0.2 invoices
* Read and write ebInterface 4.0 invoices
* Read and write ebInterface 4.1 invoices
* Read and write ebInterface 4.2 invoices
* Read and write ebInterface 4.3 invoices
* Read and write ebInterface 5.0 invoices
* Validate the signature of ebInterface documents
* Visualize ebInterface documents as HTML documents
  
# News and noteworthy

* v6.0.2 - work in progress
  * Requires ph-commons 9.1.3
  * Added new `EbInterface..NamespaceContext` classes for easy consistent usage.
  * The marshaller classes, use theses namespace contexts by default
* v6.0.1 - 2018-04-04
  * Updated to BouncyCastle 1.59
  * Updated to final ebInterface 5.0 XSD
* v6.0.0 - 2018-01-05
  * Updated to BouncyCastle 1.58
  * Updated to ph-commons 9.0.0
  * Added support for ebInterface 5.0 (RC)
* v5.1.2 - 2017-01-09
  * Updated to BouncyCastle 1.56
  * Binds to ph-commons 8.6.0
* v5.1.1 - 2016-12-14
  * Fixed case sensitivity error in a filename
* v5.1.0 - 2016-12-13
  * Added support for ebInterface 4.3
* v5.0.1 - 2016-07-15
  * Using a separate artefact for XMLDSig JAXB artefacts for easier reuse (ph-xsds-xmldsig)
* v5.0.0 - 2016-06-11
  * Requires Java 1.8
* v4.0.3 - 2015-11-25
  * Made the `BIC` element in `SEPADirectDebit` of ebInterface 4.2 optional
  * update to BouncyCastle 1.54
* v4.0.2 - 2015-11-25
  * Added support for ebInterface 4.2
* v4.0.1 - 2015-10-19
  * update to BouncyCastle 1.53
* v4.0.0 - 2015-07-23   

This library is used by [WWW.E-RECHNUNG.GV.AT](http://www.e-rechnung.gv.at) - the Austrian Government "E-Rechnung an die öffentliche Verwaltung" solution for reading ebInterface files!

The library can e.g. be used in combination with the [E-RECHNUNG.GV.AT Webservice Client](https://github.com/phax/erechnung.gv.at-webservice-client) to automatically deliver invoices to the Austrian Government. Alternatively the library [ph-ubl](https://github.com/phax/ph-ubl) is available to read and write UBL 2.0 and 2.1 invoices (and other document types).

This is originally the follow-on project of phloc-ebinterface originally residing on Google Code. 

# Usage with Maven

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ebinterface</artifactId>
  <version>6.0.1</version>
</dependency>
```

Technically this library requires libraries from [ph-commons](https://github.com/phax/ph-commons) and [ph-xmldsig](https://github.com/phax/ph-xmldsig)

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
