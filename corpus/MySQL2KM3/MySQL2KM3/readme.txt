Metamodel files
---------------
 * KM3.ecore
 * KM3.km3
 * MySQL.ecore
 * MySQL.km3
 * XML.ecore
 * XML.km3

Example files
-------------
 * euro2004.xml: source xml file describing a MySQL database.
 * euro2004-XML.ecore: corresponding XML model after injection.
 * euro2004-XML-2.ecore: new XML model obtained from the previous one (after cleaning transformation).
 * euro2004-MySQL.ecore: MySQL model obtained from the previous XML model.
 * euro2004-KM3.ecore: KM3 model obtained from the previous KM3 model.

Transformation files
--------------------
 * XML2XML.atl
 * XML2MySQL.atl
 * MySQL2KM3.atl

"KM3.ecore", "XML.ecore" and "MySQL.ecore" are the metamodels for KM3, XML and MySQL models.
Km3 files provide readable versions of these metamodels in the km3 format.

The XML2XML transformation ("XML2XML.atl") can be tested with the first XML model ("euro2004-XML.ecore") as input.
This model can be obtained by injecting the source xml file ("euro2004.xml") into an XML model.
This transformation produces a cleaned XML model by removing the Text elements that only contains blank characters.
The transformation returns a new XML model ("euro2004-XML-2.ecore").

The XML2MySQL transformation ("XML2MySQL.atl") can be tested with the obtained XML model ("euro2004-XML-2.ecore") as input.
The transformation returns a MySQL model ("euro2004-MySQL.ecore").

The MySQL2KM3 transformation ("MySQL2KM3.atl") can be tested with the MySQL model ("euro2004-MySQL.ecore") as input.
The transformation returns a KM3 model ("euro2004-KM3.ecore").
