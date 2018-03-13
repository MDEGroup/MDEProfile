The ATL2Tracer transformation shows how traceability generating code can be relatively easily added to
ATL code. It moreover shows that this process can be fully automated.
To find more details concerning dealing traceability in ATL, please refer to [1].

This transformation uses ATL refining mode as defined in [2].
This kind of transformation is a HOT (Higher Order Transformation): it takes a transformation as source and as target.

Source and target models conform to ATL metamodel.
A sample source model (sample-ATL-0.2.ecore in ATL2Tracer folder) and its corresponding target model (sample-ATL-0.2-Tracer.ecore in Tracertest/Input) are given.

File configurationATL2Tracer.png shows how to configure the transformation for launch.
It is now possible to use the "Metamodel by URI" button to use a metamodel already registered in EMF.
We advise you to use this new feature to configure this transformation because ATL metamodel is already registered in EMF by ADT plugins.
Thanks to that, the latest version of ATL metamodel will always be used.

To serialize the generated ATL transformation you can use ATL extractor available in AM3 project (http://dev.eclipse.org/viewcvs/indextech.cgi/~checkout~/gmt-home/subprojects/AM3/index.html).
You can create easily input models thanks to ATL injector (also available in AM3 project).

Once the target model with tracer is created. You can test this transformation.
File configurationTracerTest.png shows how to configure the transformation for launch.
Sample target models (sample-ATL-0.2-OUT.ecore and sample-Trace-OUT.ecore in Tracertest/Output) are given.

If you have some problems, please use ATL mailing list (http://groups.yahoo.com/group/atl_discussion/).

References:
[1] Jouault, F : Loosely Coupled Traceability for ATL. In: Proceedings of the European Conference on Model Driven Architecture (ECMDA) workshop on traceability, Nuremberg, Germany.
[2] Jouault, F., and Kurtev, I., Transforming Models with ATL, in proceedings of the Model Transformation in Practice Workshop, October 3rd 2005, part of the MoDELS 2005 conference
