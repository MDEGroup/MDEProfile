This project contains the Syntax to SimpleSBVR to SimpleUML scenario. 
 This transformation is used to produce a UML class diagram from controlled English text using SBVR and a Syntax as intermediates layer.

--	--	--	--

Important information :

To open the XMI samples in the reflective editor, it is required to register the corresponding metamodel in EMF's registry (right-click on the .ecore file -> register metamodel).
Note that ATL automatically registers the metamodels when a tranformation is launched.

--	--	--	--

Project Content :

Transformation files:
	- Syntax2SimpleSBVR.atl: ATL transformation that produces a SBVR Model from a Syntax Model.
	- SimpleSBVR2SimpleUML.atl: ATL transformation that produces a UML model from a SBVR Model
	  
Metamodel files:
	- Syntax/Syntax.ecore, Syntax.km3: Syntax Metamodel in ECORE and KM3
	- SimpleSBVR/SimpleSBVR.ecore, SBVR.km3: SimpleSBVR Metamodel in ECORE and KM3
	- SimpleUML/SimpleUML.ecore, SimpleUML.km3: SimpleUML Metamodel in ECORE and KM3
	
Sample files:
	- Samples/Syntax-EachCompanySellsAtLeastOneProduct.xmi: a Syntax model for the text "Each company sells at least one product."
	- Samples/Syntax-CompanyProduct.xmi: a Syntax model for the text "Each company sells at least one product. Each company has a name. Each product is sold by at least one company. A software is a product. MyCode is a software."
	  	
	- Samples/SimpleSBVR-EachCompanySellsAtLeastOneProduct.xmi: a SimpleSBVR model that is obtained with the ATL transformation from the corresponding Syntax model.
	- Samples/SimpleSBVR-CompanyProduct.xmi: a SimpleSBVR model that is obtained with the ATL transformation from the corresponding Syntax model.
	
	- Samples/SimpleUML-EachCompanySellsAtLeastOneProduct.xmi: a SimpleUML model that is obtained with the ATL transformation from the corresponding SimpleSBVR model.
	- Samples/SimpleUML-CompanyProduct.xmi: a SimpleUML model that is obtained with the ATL transformation from the corresponding SimpleSBVR model.
	
Run configurations files:
	- Syntax2SimpleSBVR.launch: run configuration for the ATL transformation of the text "Each company sells at least one product." from Syntax to SBVR
	- SimpleSBVR2SimpleUML.launch: run configuration for the ATL transformation of the text "Each company sells at least one product." from SBVR to SimpleUML
	
The run configurations can be modified to use other samples by changing the source and target models.

--	--	--	--

Additional information:

Rooting:
All metamodels are rooted: a "Root" class is added, which contains elements of class  "Element" from which all other model elements inherit. This is so to allow an easier creation of XMI samples through the "dynamic instance" facility: open a metamodel with the ecore model editor, right-click on the root class and choose "create dynamic instance"; you may now add any type of elements to your model. This rooting has absolutely no effect on the transformations, i.e the root class is ignored and the target model won't be rooted.