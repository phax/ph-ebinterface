# ph-ebinterface

Java library encapsulating the usage of ebInterface 3.0, 3.0.2, 4.0, 4.1, 4.2, 4.3, 5.0 and 6.0 within your application. 
See [First Steps](https://github.com/phax/ph-ebinterface/wiki/FirstSteps) (English) or 
[Erste Schritte](https://github.com/phax/ph-ebinterface/wiki/ErsteSchritte) (Deutsch) for some code examples on how to read and write the different ebInterface versions.

Features:

* Read and write ebInterface 3.0 invoices
* Read and write ebInterface 3.0.2 invoices
* Read and write ebInterface 4.0 invoices
* Read and write ebInterface 4.1 invoices
* Read and write ebInterface 4.2 invoices (since v4.0.2)
* Read and write ebInterface 4.3 invoices (since v5.1.0)
* Read and write ebInterface 5.0 invoices (since v6.0.1)
* Read and write ebInterface 6.0 invoices (since v6.1.3)
* Validate the signature of ebInterface documents
* Visualize ebInterface documents as HTML documents

Note: this library is used by [WWW.E-RECHNUNG.GV.AT](http://www.e-rechnung.gv.at) - the Austrian Government "E-Rechnung an die öffentliche Verwaltung" solution for reading ebInterface files.

The library can e.g. be used in combination with the [E-RECHNUNG.GV.AT Webservice Client](https://github.com/phax/erechnung.gv.at-webservice-client) to automatically deliver invoices to the Austrian Government. Alternatively the library [ph-ubl](https://github.com/phax/ph-ubl) is available to read and write UBL 2.0, 2.1 and 2.2 invoices (and other document types).
A converter between ebInterface and UBL is available via the [ebinterface-ubl-mapping](https://github.com/austriapro/ebinterface-ubl-mapping) library.

# Usage with Maven

To use this library with Maven, add the following artefact to your pom.xml, replacing `x.y.z` with the effective version number:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ebinterface</artifactId>
  <version>x.y.z</version>
</dependency>
```

Technically this library requires libraries from [ph-commons](https://github.com/phax/ph-commons) and [ph-xmldsig](https://github.com/phax/ph-xmldsig)


# Gradle considerations

This project relies on JDK version based Maven profile activation.
See https://github.com/phax/ph-jaxb-pom#gradle-usage for help on this specific issue. 
  
# News and noteworthy

* v6.5.0 - 2022-08-08
    * Added support of ebInterface 6.1
* v6.4.0 - 2021-05-02
    * Updated to ph-commons 10.1
* v6.3.0 - 2021-03-21
    * Updated to ph-commons 10
* v6.2.1 - 2020-09-17
    * Updated to Jakarta JAXB 2.3.3
* v6.2.0 - 2020-08-28
    * Updated to ph-commons 9.4.7
    * Using Java 8 date and time classes for JAXB created classes
* v6.1.6 - 2020-06-25
    * Updated to ph-xmldsig 4.3.2 which uses XMLSec 2.2.0
* v6.1.5 - 2020-05-26
    * Updated to ph-xsds 2.3.0 (changed Maven groupId)
* v6.1.4 - 2020-05-15
    * Fixed an invalid CSS link in the ebInterface 5.0 XSLT
* v6.1.3 - 2020-05-01
    * Updated to the final version of ebInterface 6.0 - only documentation changes
* v6.1.2 - 2020-04-01
    * Added `xsi` default namespace prefix to the `EbInterface...NamespaceContext` classes for ebInterface 3.x and 4.0 
    * Added initial draft of ebInterface 6.0
    * Updated to ph-commons 9.4.0
    * Added ebInterface extension namespace prefixes to the `EbInterface...NamespaceContext` classes for ebInterface 4.x 
* v6.1.1 - 2019-06-05
    * Added Java 12 compatibility
* v6.1.0 - 2018-11-12
    * Requires ph-commons 9.2.0
    * Added ebInterface 5.0 visualization XSLT
* v6.0.2 - 2018-07-27
    * Requires ph-commons 9.1.3
    * Added new `EbInterfaceXXNamespaceContext` classes for easy consistent usage.
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

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a> |
Kindly supported by [YourKit Java Profiler](https://www.yourkit.com)