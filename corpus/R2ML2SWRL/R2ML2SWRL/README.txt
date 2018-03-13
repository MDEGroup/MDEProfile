*********************************************************
** Description: R2ML2SWRL ATL transformation scenario
** Author: 	Milan Milanovic <milan at milanovic.org>
** Date: 	August 25, 2006
********************************************************

This ATL scenario transforms R2ML (REWERSE I1 Markup Language) into SWRL (Semantic Web Rule Language). 
It is composed of R2ML injector (to R2ML metamodel), transformations (R2ML2RDM) and an RDM extractor 
that produces XML documents that conform to the SWRL/OWL syntax defined by W3C. To find more 
details about this transformation scenario, please refer to [1]-[2]. 

See also: 
	-- SWRL2R2ML transformations scenario
	-- R2ML (REWERSE I1 Rule Markup Language) - http://oxygen.informatik.tu-cottbus.de/rewerse-i1/?q=node/6
	-- SWRL (Semantic Web Rule Language) - http://www.w3.org/Submission/SWRL/
	-- RDM metamodel - http://www.aifb.uni-karlsruhe.de/WBS/sbr/publications/owl-metamodeling.pdf
	-- OWL Web Ontology Language: XML Presentation Syntax - http://www.w3.org/TR/owl-xmlsyntax/
	-- OWL (Web Ontology language) - http://www.w3.org/2004/OWL/

Transformation files:
---------------------
	- RDM2XML.atl: ATL transformation that transforms an RDM model into an
	               an XML models with SWRL/OWL syntax elements.

	- R2ML2RDM.atl: The core transformation, that produced an RDM model from
                        a R2ML model (instance of R2ML metamodel).

	- XML2R2ML.atl: ATL transformation that transforms an XML model that are 
                        injected from R2ML XML documents, into R2ML model.

	- R2ML2SWRL.xml: An ANT script that automatically executes the 3 ATL transformations and
	                 the pair XML injector/extractor to produce a R2ML model from R2ML document,
                         and to produce SWRL XML documents from RDM model, respectively. It can be 
                         executed by right-clicking on it, then clicking on "Run As->Ant Build". 
                         To execute this transformation on other R2ML examples, place your R2ML models 
                         in the models/r2ml-xml folder and make necessary changes in ANT script.
	  
Metamodel files:
----------------
	- XML.xmi: XML metamodel in MOF XMI 1.2 format (MOF-1.4). This metamodel is part of standard metamodels 
                   used with ATL. It is used when models are tranformed into XML documents or vice versa.

	- RDM.xmi: RDM metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for
                   the SWRL language.

	- R2ML.xmi: R2ML metamodel in MOF XMI 1.2 format (MOF-1.4). Metamodel of the R2ML language.
		    
	- Every metamodel have KM3 and Ecore EMF XMI 2.0 format versions.
	
Sample files:
-------------
	- Models/swrl-xml/SWRLRule.xml: This file is SWRL rule in the SWRL XML format after executing XML injector,
                                        the XML2R2ML transformation, the R2ML2RDM transformation, the RDM2XML transformation
                                        and XML extractor.

	- Models/r2ml-xml/R2MLRule.xml: This file is the R2ML rule in the R2ML XML format, and is used as input example 
                                        by this transformation scenario.

References:
-----------
[1] Milanoviæ, M., Gaševiæ, D., Guirca, A., Wagner, G., Devedžiæ, V., "Towards Sharing Rules Between OWL/SWRL and UML/OCL", Electronic Communications of the European Association of Software Science and Technology, Volume 5, 2006.
[2] Milanoviæ, M. "Modeling rules on the Semantic Web", master thesis, GOOD OLD AI Lab, Faculty of organizational sciences, University of Belgrade.
