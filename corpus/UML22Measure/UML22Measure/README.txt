--------------------------------------------------------------------------------
For questions and/or comments:

    Eric Vepa (evepa <at> sodius.com)
    
    SODIUS (www.sodius.com)
    6, rue de la Cornouaille - BP 91941
    44319 Nantes, France
--------------------------------------------------------------------------------

The UML22Measure project is used to collect measurement data on UML2 models,
 using libraries implementing some metrics (MOOD, MOOD2, MOOSE, EMOOSE and 
 QMOOD).
The measure level can be changed by setting other value for the first helper
 measureLevel of the transformation UML22Measure.

Developed using:
  - Eclipse SDK (3.3.0)
  - Eclipse EMF (2.3.0)
  - Eclipse M2M-ATL (2.0RC2)
  - Eclipse UML2 Project (2.1.0)
  - [Optional] Eclipse Jar2UML (1.0.10)
 
Requirements:
  - UML2 Eclipse plug-in (the UML2 meta-model is needed by URI)
Optional Requirements:
  - Jar2UML Eclipse plug-in (for more examples from Jar files)

Contents:
  --> "UML22Measure": The ATL project folder.
    |--> "conf": The folder which contains configuration files.
      \--> "UML22Measure build.xml.launch": The configuration file of the ANT
 script "build.xml".
    |--> "lib": The folder which contains the libraries, used by the
 transformations, in ATL and ASM format.
      \--> "EMOOSE4UML2.{atl,asm}": The EMOOSE4UML2 library.
      \--> "FLAME4UML2.{atl,asm}": The FLAME4UML2 library.
      \--> "MOOD4UML2.{atl,asm}": The MOOD4UML2 library.
      \--> "QMOOD4UML2.{atl,asm}": The QMOOD4UML2 library.
    |--> "metamodels":  The folder which contains the meta-models in KM3 and
 Ecore format.
      \--> "Measure.{uml,ecore}": The Measure meta-model.
    |--> "models": The folder which contains input and output models.
      \--> "example.uml": An example of input file.
      \--> "example-Measure.ecore": The model generated for the example.
    |--> "transformations": The folder which contains the transformations in
 ATL and ASM format.
      \--> "UML22Measure.{atl,asm}": The UML22Measure transformation.
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
 