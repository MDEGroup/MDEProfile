--------------------------------------------------------------------------------
For questions and/or comments:

    Eric Vepa (evepa <at> sodius.com)
    
    SODIUS (www.sodius.com)
    6, rue de la Cornouaille - BP 91941
    44319 Nantes, France
--------------------------------------------------------------------------------

The Table2SVGBarChart project is used to extract a SVG file containing bar
 charts from a Table model.

Developed using:
  - Eclipse SDK (3.3.0)
  - Eclipse EMF (2.3.0)
  - Eclipse M2M-ATL (2.0RC2)

Contents:
  --> "Table2SVGBarChart": The ATL project folder.
    |--> "conf": The folder which contains configuration files.
      \--> "Table2SVGBarChart build.xml.launch": The configuration file of the
ANT script "build.xml".
    |--> "lib": The folder which contains the libraries, used by the
 transformations, in ATL and ASM format.
      \--> "TableHelpers.{atl,asm}": The TableHelpers library.
    |--> "metamodels":  The folder which contains the meta-models in KM3 and
 Ecore format.
      \--> "SVG.{km3,ecore}": The SVG meta-model.
      \--> "Table.{km3,ecore}": The Table meta-model.
      \--> "XML.{km3,ecore}": The XML meta-model.
    |--> "models": The folder which contains input and output models.
      \--> "example-Table.ecore": An example of input model.
      \--> "example-SVGBarChart.svg": The file generated for the example.
    |--> "transformations": The folder which contains the transformations in
 ATL and ASM format.
      \--> "SVG2XML.{atl,asm}": The SVG2XML transformation.
      \--> "Table2SVGBarChart.{atl,asm}": The Table2SVGBarChart transformation.
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
 