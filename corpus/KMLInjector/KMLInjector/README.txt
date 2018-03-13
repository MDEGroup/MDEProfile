The KMLInjector inject a KML file into an XML model.

Contents:
 - ATL project directory named "KMLInjector".
   - This "README.txt".
   - InputModels directory with a sample XML model file named "example-XML.ecore" 
   - Metamodels directory with KML and XML file in .km3 and .ecore format.
   - OutputModels directory.
   - Transformations directory with XML2KML.atl transformation file.
   - "build.xml" ANT script file and his shared configuration file "KMLInjector build.xml.launch".
   - "XML2KML.launch" file.
   
 - Open the AM3 Perspective.
 - Rename any KML file to a .xml extension and delete the kml tag at the begining of the file (don't forget the closing kml tag).

The ANT script method:
 - Open "build.xml" file and give a correct ant-contrib.jar path.
 - Run the "build.xml" with: Right click -> Run As -> ANT Build (the launch file is already configured).
 - The ouput KML model obtained is in the OutputModels directory and is named "example-KML.ecore".
 
Alternative method with configurations:
 - In InputModels directory, on the file "example.xml":  Right click -> Inject XML file to XML model (Ecore based).
 - Run -> ATL Transformation named "XML2KML".
 - Rename the extracted file "example-XML.xml" to "example-XML.html".
 