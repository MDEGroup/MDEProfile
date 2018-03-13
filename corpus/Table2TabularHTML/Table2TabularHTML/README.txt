--------------------------------------------------------------------------------
For questions and/or comments:

    Eric Vepa (evepa <at> sodius.com)
    
    SODIUS (www.sodius.com)
    6, rue de la Cornouaille - BP 91941
    44319 Nantes, France
--------------------------------------------------------------------------------

The Table2TabularHTML project is used to extracts an HTML file from a Table
 model.
Please note that the output file is extracted with the XML extractor. So the
 first line should be removed and replaced by:
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
  "http://www.w3.org/TR/html4/strict.dtd">

Developed using:
  - Eclipse SDK (3.3.0)
  - Eclipse EMF (2.3.0)
  - Eclipse M2M-ATL (2.0RC2)

Contents:
  --> "Table2TabularHTML": The ATL project folder.
    |--> "conf": The folder which contains configuration files.
      \--> "Table2TabularHTML build.xml.launch": The configuration file of the
ANT script "build.xml".
    |--> "lib": The folder which contains the libraries, used by the
 transformations, in ATL and ASM format.
      \--> "TableHelpers.{atl,asm}": The TableHelpers library.
    |--> "metamodels":  The folder which contains the meta-models in KM3 and
 Ecore format.
      \--> "HTML.{km3,ecore}": The HTML meta-model.
      \--> "Table.{km3,ecore}": The Table meta-model.
      \--> "XML.{km3,ecore}": The XML meta-model.
    |--> "models": The folder which contains input and output models.
      \--> "example-Table.ecore": An example of input model.
      \--> "example-TabularHTML.html": The file generated for the example.
    |--> "transformations": The folder which contains the transformations in
 ATL and ASM format.
      \--> "HTML2XML.{atl,asm}": The HTML2XML transformation.
      \--> "Table2TabularHTML.{atl,asm}": The Table2TabularHTML transformation.
    |--> ".project": The Eclipse ATL Project file.
    |--> "build.xml": The ANT script of the project for launching the
 transformations.
    |--> "build.properties": Project properties for the ANT script.
    |--> "epl-v10.html": This project is under the Eclipse Public License.
    |--> "README.txt": This file.
   
HowTo:
 --> Open the AM3 Perspective.
 --> Run the "build.xml"  (the launch file is already configured):
       Right click on "build.xml" file --> Run As --> Ant Build.
 --> The generated output file is in the "models" folder.
 