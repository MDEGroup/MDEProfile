The KM3 plugin implements several transformations, including the generation of an Ecore metamodel
from a KM3 model: KM32EMF.
This distribution provides source code for the KM32EMF transformation
available in the KM3 plugin as of May 24th, 2006.

KM32EMF is usually used through the KM3 plugin, as the "Inject KM3 to Ecore metamodel" action available
on *.km3 files. Some users may however want to customize this transformation.
Here is the procedure to replace the standard transformation with a custom one:
	* modify KM32EMF.atl to support desired features,
	* compile it into KM32EMF.asm (this is normally automatically performed by the ATL builder),
	* copy KM32EMF.asm into org.atl.eclipse.km3 / src / org / atl / eclipse / km3 / resources,
	* restart Eclipse.

Files:
	* README.txt: this small note.
	* KM32EMF.atl: an ATL transformation that transforms KM3 models into Ecore metamodels.
	* Sample-KM3.ecore: a sample KM3 model that may be used as input for KM32EMF.atl.
	* Sample.ecore: a sample Ecore metamodel that was obtained by applying KM32EMF.atl to Sample-KM3.ecore.
	* KM32EMF.launch: the launch configuration for running KM32EMF.atl on Sample-KM3.ecore to obtain
	Sample.ecore. Note that the KM3 metamodel is not loaded from an XMI file but referenced to by its XML namespace URI.
	This mechanism ensures that the latest version of KM3 is always used. It however requires a version of
	ADT more recent than May 24th, 2006.

	
Remarks:

This transformation illustrates how various metadata may be specified as KM3 comments and translated
into EMF-specific constructs. The getMetadata(name : String) helper is used to get the value of nsURI
and nsPrefix from KM3 comments. The values returned by the helper are then used to initialize the
corresponding EMF properties of EPackage.
