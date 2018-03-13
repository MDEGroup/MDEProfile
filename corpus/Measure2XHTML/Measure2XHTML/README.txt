--------------------------------------------------------------------------------
For questions and/or comments:

    Eric Vepa (evepa <at> sodius.com)
    
    SODIUS (www.sodius.com)
    6, rue de la Cornouaille - BP 91941
    44319 Nantes, France
--------------------------------------------------------------------------------

The Measure2XHTML project is used to extracts an XHTML file from a Measure
 model.
External files can be used for CSS and JavaScript by setting the helpers
 useCSSFile and useJSFile of the transformation Measure2XHTML to "true".
Any modification of these files must be carried forward in the corresponding
 helpers of the Measure2XHTML transformation.

Developed using:
  - Eclipse SDK (3.3.0)
  - Eclipse EMF (2.3.0)
  - Eclipse M2M-ATL (2.0RC2)

Contents:
  --> "Measure2XHTML": The ATL project folder.
    |--> "conf": The folder which contains configuration files.
      \--> "Measure2XHTML build.xml.launch": The configuration file of the ANT
 script "build.xml".
    |--> "lib": The folder which contains the libraries, used by the
 transformations, in ATL and ASM format.
      \--> "lib": 
        \--> "log4j.jar": The logger used by the com.sodius.atl.xhtml.jar.
      \--> "com.sodius.atl.xhtml.jar": The Jar file used for validating the
 XHTML file generated with ATL.
      \--> "MeasureHelpers.{atl,asm}": The MeasureHelpers library.
    |--> "metamodels":  The folder which contains the meta-models in KM3 and
 Ecore format.
      \--> "Measure.{km3,ecore}": The Measure meta-model.
      \--> "XHTML.{km3,ecore}": The XHTML meta-model.
      \--> "XML.{km3,ecore}": The XML meta-model.
    |--> "models": The folder which contains input and output models.
      \--> "example-Measure.ecore": An example of input model.
      \--> "example-XHTML.html": The file generated for the example.
      \--> "script.js": The external JavaScript file used by the generated
 XHTML file.
      \--> "stylesheet.css": The external CSS file used by the generated
 XHTML file.
    |--> "transformations": The folder which contains the transformations in
 ATL and ASM format.
      \--> "Measure2XHTML.{atl,asm}": The Measure2XHTML transformation.
      \--> "XHTML2XML.{atl,asm}": The XHTML2XML transformation.
    |--> ".project": The Eclipse ATL Project file.  
    |--> "build.xml": The ANT script of the project for launching the
 transformation.
    |--> "build.properties": Project properties for the ANT script.
    |--> "epl-v10.html": This project is under the Eclipse Public License.
    |--> "README.txt": This file.
   
HowTo:
 --> Open the AM3 Perspective.
 --> Run the "build.xml"  (the launch file is already configured):
       Right click on "build.xml" file --> Run As --> Ant Build.
 --> The generated output model is in the "models" folder.
 