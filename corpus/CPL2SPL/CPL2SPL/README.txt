This project contains a relatively complex example, which handles several aspects of two telephony DSLs: SPL and CPL.
The complexity of this project shows that ATL can be used to handle such scenarios.
It is not necessary to understand all the details in order to learn from this transformation example.
However, we advise users to first familiarize themselves with ATL on simpler examples like Class2Relational and KM32Problem.
The Doc/CPL2SPL.pdf document is a paper, which briefly presents CPL, SPL as well as motivation, challenges, and results of this experiment.

Transformation files:
  - CPL/XMLSyntax/XML2CPL.atl: ATL transformation that transforms an XML model into a CPL model.
  - CPL/XMLSyntax/XMLHelpers.atl: ATL library of helpers used by XML2CPL.atl.
  - CPL2SPL.atl: ATL transformation that transforms CPL models into SPL models.
  - CPL2SPL.xml:
  		ant script that automatically applies the CPL2SPL transformation to all the examples provided in the Samples/ directory.
	    It also handles getting from XML document (*.cpl) to XML model, then to CPL model, and from SPL model to SPL program.
	    This is an example of batch execution of ATL transformations.
    	It can be executed by right-clicking on it, then clicking on "Run As->Ant Build".
    	It creates *.spl files in the Samples/ directory as well as *.ecore files in the DebuggingInformation/ directory.
    	These *.ecore files correspond to the intermediary steps of the transformation (i.e. XML model, CPL model, and SPL model).
    	They have the same base name as the original *.cpl file and the -<metamodel-name>Model.ecore suffix.
    	They are serialized for debugging purpose and to allow viewing these intermediary results.

Metamodel files:
  - AMMACore/XML.ecore: XML metamodel in EMF XMI 2.0 format.
    This metamodel is part of standard metamodels used with ATL.
    It is used when XML documents are tranformed into models.
  - AMMACore/TCS.ecore: TCS metamodel in EMF XMI 2.0 format.
    This metamodel is part of standard metamodels used with ATL.
    It is used to represent textual syntaxes of metamodels.
    This file is used here to transform SPL models into their equivalent textual representations (i.e. programs).
  - CPL/CPL.km3: CPL metamodel in KM3 textual syntax.
  - CPL/CPL.ecore: CPL metamodel in Ecore EMF XMI 2.0 format.
  - SPL/SPL.km3: SPL metamodel in KM3 textual syntax.
  - SPL/SPL.ecore: SPL metamodel in Ecore EMF XMI 2.0 format.

Sample files:
  - The Samples/ directory contains a set of *.cpl files.
    These examples are CPL programs (therefore in XML) taken from the CPL specification (i.e. RFC3880).
    They are transformed into *.spl programs with the same base name by the CPL2SPL.xml ant script.
  - The StepByStep/ directory contains a set of files prepared for step-by-step execution of the CPL2SPL
    transformation. We give here the actions to perform in order to get to the result
    (all paths are relative to the StepByStep/ directory):
      - transform AComplexExample.cpl.xml XML document into an XML model:
        right-click on it and select "Inject XML file to XML model (Ecore based)".
        Note that this action is only available from "AM3 Resource Navigator" view.
        It can be activated by switching to AM3 perspective or going in menu
        "Window->Show View->Other..." and then in "ATL".
        This results in file AComplexExample.cpl-XML.ecore.
      - transform XML model into CPL model: go to menu "Run->Run...",
        then choose "XML2CPL" in the left pane and click on "Run" button on the bottom right.
        This results in file AComplexExample.cpl-CPL.ecore.
      - transform CPL model into SPL model: go to menu "Run->Run...",
        then choose "CPL2SPL" in the left pane and click on "Run" button on the bottom right.
        This results in file AComplexExample.cpl-SPL.ecore.
      - transform SPL model into SPL program: right-click on "SPL2Text.xml",
        then click on "Run As->Ant Build".
        This results in file AComplexExample.cpl-SPL.spl.
