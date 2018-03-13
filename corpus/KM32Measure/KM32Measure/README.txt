--------------------------------------------------------------------------------
For questions and/or comments:

    Eric Vepa (evepa <at> sodius.com)
    
    SODIUS (www.sodius.com)
    6, rue de la Cornouaille - BP 91941
    44319 Nantes, France
--------------------------------------------------------------------------------

The KM32Measure project is used to collect measurement data on KM3 meta-models,
 using libraries implementing some metrics (MOOD, MOOD2, MOOSE, EMOOSE and 
 QMOOD).
The measure level can be changed by setting other value for the first helper
 measureLevel of the transformation KM32Measure.

Developed using:
  - Eclipse SDK (3.3.0)
  - Eclipse EMF (2.3.0)
  - Eclipse M2M-ATL (2.0RC2)

Contents:
  --> "KM32Measure": The ATL project folder.
    |--> "conf": The folder which contains configuration files.
      \--> "KM32Measure build.xml.launch": The configuration file of the ANT
 script "build.xml".
    |--> "lib": The folder which contains the libraries, used by the
 transformations, in ATL and ASM format.
      \--> "EMOOSE4KM3.{atl,asm}": The EMOOSE4KM3 library.
      \--> "FLAME4KM3.{atl,asm}": The FLAME4KM3 library.
      \--> "MOOD4KM3.{atl,asm}": The MOOD4KM3 library.
      \--> "QMOOD4KM3.{atl,asm}": The QMOOD4KM3 library.
    |--> "metamodels":  The folder which contains the meta-models in KM3 and
 Ecore format.
      \--> "Measure.{km3,ecore}": The Measure meta-model.
    |--> "models": The folder which contains input and output models.
      \--> "example.km3": An example of input file.
      \--> "example-Measure.ecore": The model generated for the example.
    |--> "transformations": The folder which contains the transformations in
 ATL and ASM format.
      \--> "KM32Measure.{atl,asm}": The KM32Measure transformation.
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
 