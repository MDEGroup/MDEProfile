--------------------------------------------------------------------------------
For questions and/or comments:

    Eric Vepa (evepa <at> sodius.com)
    
    SODIUS (www.sodius.com)
    6, rue de la Cornouaille - BP 91941
    44319 Nantes, France
--------------------------------------------------------------------------------

The Measure2Table project is used to creates generic tables from a measure
 model.

Developed using:
  - Eclipse SDK (3.3.0)
  - Eclipse EMF (2.3.0)
  - Eclipse M2M-ATL (2.0RC2)

Contents:
  --> "Measure2Table": The ATL project folder.
    |--> "conf": The folder which contains configuration files.
      \--> "Measure2Table build.xml.launch": The configuration file of the ANT
 script "build.xml".
    |--> "lib": The folder which contains the libraries, used by the
 transformations, in ATL and ASM format.
      \--> "MeasureHelpers.{atl,asm}": The MeasureHelpers library.
    |--> "metamodels":  The folder which contains the meta-models in KM3 and
 Ecore format.
      \--> "Measure.{km3,ecore}": The Measure meta-model.
      \--> "Table.{km3,ecore}": The Table meta-model.
    |--> "models": The folder which contains input and output models.
      \--> "example-Measure.ecore": An example of input model.
      \--> "example-Table.ecore": The model generated for the example.
    |--> "transformations": The folder which contains the transformations in
 ATL and ASM format.
      \--> "Measure2Table.{atl,asm}": The Measure2Table transformation.
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
 --> The generated output model is in the "models" folder.
 