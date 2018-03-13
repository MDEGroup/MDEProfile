*********************************************************
** Description: R2ML2OCL ATL transformation scenario
** Author: 	Milan Milanovic <milan at milanovic.org>
** Date: 	October 10, 2006
********************************************************

This ATL scenario transforms R2ML (REWERSE I1 Markup Language) into OCL (Object Constraint Language). 
It is composed of R2ML injector (to R2ML metamodel), transformations (R2ML2OCL) and an OCL extractor 
that produces OCL documents that conform to the OCL grammar. To find more details about this 
transformation scenario, please refer to [1]-[2]. 

See also: 
	-- OCL2R2ML transformations scenario
	-- R2ML (REWERSE I1 Rule Markup Language) - http://oxygen.informatik.tu-cottbus.de/rewerse-i1/?q=node/6
	-- Object Constraint Language - OMG Available Specification, Version 2.0, formal/06-05-01. 
                                        [Online] http://www.omg.org/cgi-bin/doc?formal/06-05-01

Transformation files:
---------------------
	- XML2R2ML.atl: ATL transformation that transforms an XML model that are 
                        injected from R2ML XML documents, into R2ML model.
                        
	- R2ML2OCL.atl: The core transformation, that produced an OCL model from
                        a R2ML model (instance of R2ML metamodel).

	- R2ML2OCL.xml: An ANT script that automatically executes the 2 ATL transformations (XML2R2ML and R2ML2OCL)
	                and the EBNF extractor to produce a OCL code from OCL model. It can be 
                        executed by right-clicking on it, then clicking on "Run As->Ant Build". 
                        To execute this transformation on other R2ML examples, place your R2ML models 
                        in the models/r2ml-xml folder and make necessary changes in ANT script.
Metamodel files:
----------------
	- XML.xmi: XML metamodel in MOF XMI 1.2 format (MOF-1.4). This metamodel is part of standard metamodels 
                   used with ATL. It is used when models are tranformed into XML documents or vice versa.

	- OCL.xmi: OCL metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for
                   the OCL language.

	- R2ML.xmi: R2ML metamodel in MOF XMI 1.2 format (MOF-1.4). Metamodel of the R2ML language.
	
	- TCS.xmi: Textual Concrete Syntax metamodel in MOF XMI 1.2 format (MOF-1.4).
		    
	- Every metamodel have KM3 and Ecore EMF XMI 2.0 format versions.
	
Sample files:
-------------
	- Models/r2ml-xml/R2MLRule.xml: This file is R2ML rule in the R2ML XML format and is used as input example by
					this transformation scenario.
	
	- Models/ocl/m1.ocl: This file is OCL invariant after the XML injector, the R2ML2OCL transformation and
	                     the OCL EBNF extractor.                                

Other files:
------------
	- OCL.tcs: OCL textual concrete syntax

References:
-----------
[1] Milanović, M., Gašević, D., Guirca, A., Wagner, G., Devedžić, V., "Towards Sharing Rules Between OWL/SWRL and UML/OCL", Electronic Communications of the European Association of Software Science and Technology, Volume 5, 2006.
[2] Milanović, M. "Modeling rules on the Semantic Web", master thesis, GOOD OLD AI Lab, Faculty of organizational sciences, University of Belgrade.
