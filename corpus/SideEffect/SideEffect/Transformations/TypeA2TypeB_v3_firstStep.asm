<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="TypeA2TypeB"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchRootA2RootB():V"/>
		<constant value="__exec__"/>
		<constant value="RootA2RootB"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyRootA2RootB(NTransientLink;):V"/>
		<constant value="__matchRootA2RootB"/>
		<constant value="RootA"/>
		<constant value="TypeA"/>
		<constant value="a"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="rtA"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="rtB"/>
		<constant value="RootB"/>
		<constant value="TypeB"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="11:9-11:20"/>
		<constant value="11:3-19:4"/>
		<constant value="__applyRootA2RootB"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="Set"/>
		<constant value="4"/>
		<constant value="elms"/>
		<constant value="5"/>
		<constant value="6"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.includes(J):J"/>
		<constant value="40"/>
		<constant value="J.including(J):J"/>
		<constant value="41"/>
		<constant value="J.Definition(J):J"/>
		<constant value="defs"/>
		<constant value="12:61-12:67"/>
		<constant value="12:12-12:15"/>
		<constant value="12:12-12:20"/>
		<constant value="13:9-13:12"/>
		<constant value="13:26-13:27"/>
		<constant value="13:26-13:32"/>
		<constant value="13:9-13:33"/>
		<constant value="13:44-13:45"/>
		<constant value="13:44-13:50"/>
		<constant value="13:9-13:51"/>
		<constant value="16:6-16:9"/>
		<constant value="16:21-16:22"/>
		<constant value="16:6-16:23"/>
		<constant value="14:6-14:9"/>
		<constant value="13:5-17:10"/>
		<constant value="12:12-18:6"/>
		<constant value="18:20-18:30"/>
		<constant value="18:42-18:43"/>
		<constant value="18:20-18:44"/>
		<constant value="12:12-18:45"/>
		<constant value="12:4-18:45"/>
		<constant value="f"/>
		<constant value="res"/>
		<constant value="link"/>
		<constant value="Definition"/>
		<constant value="MTypeA!ElementA;"/>
		<constant value="s"/>
		<constant value="t"/>
		<constant value="DefinitionB"/>
		<constant value="27:12-27:13"/>
		<constant value="27:12-27:18"/>
		<constant value="27:4-27:18"/>
		<constant value="26:3-28:4"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<call arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<call arg="10"/>
			<call arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<call arg="15"/>
			<getasm/>
			<call arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<call arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="47"/>
			<findme/>
			<push arg="48"/>
			<call arg="49"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<call arg="51"/>
			<dup/>
			<push arg="52"/>
			<load arg="19"/>
			<call arg="53"/>
			<dup/>
			<push arg="54"/>
			<push arg="55"/>
			<push arg="56"/>
			<new/>
			<call arg="57"/>
			<pusht/>
			<call arg="58"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="59" begin="21" end="23"/>
			<lne id="60" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="61">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="62"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="52"/>
			<call arg="63"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="64"/>
			<store arg="65"/>
			<load arg="65"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="66"/>
			<push arg="8"/>
			<new/>
			<store arg="67"/>
			<load arg="29"/>
			<get arg="68"/>
			<iterate/>
			<store arg="69"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="67"/>
			<iterate/>
			<store arg="70"/>
			<load arg="70"/>
			<get arg="38"/>
			<call arg="71"/>
			<enditerate/>
			<load arg="69"/>
			<get arg="38"/>
			<call arg="72"/>
			<if arg="73"/>
			<load arg="67"/>
			<load arg="69"/>
			<call arg="74"/>
			<goto arg="75"/>
			<load arg="67"/>
			<store arg="67"/>
			<enditerate/>
			<load arg="67"/>
			<iterate/>
			<store arg="67"/>
			<getasm/>
			<load arg="67"/>
			<call arg="76"/>
			<call arg="71"/>
			<enditerate/>
			<call arg="30"/>
			<set arg="77"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="78" begin="14" end="16"/>
			<lne id="79" begin="18" end="18"/>
			<lne id="80" begin="18" end="19"/>
			<lne id="81" begin="25" end="25"/>
			<lne id="82" begin="28" end="28"/>
			<lne id="83" begin="28" end="29"/>
			<lne id="84" begin="22" end="31"/>
			<lne id="85" begin="32" end="32"/>
			<lne id="86" begin="32" end="33"/>
			<lne id="87" begin="22" end="34"/>
			<lne id="88" begin="36" end="36"/>
			<lne id="89" begin="37" end="37"/>
			<lne id="90" begin="36" end="38"/>
			<lne id="91" begin="40" end="40"/>
			<lne id="92" begin="22" end="40"/>
			<lne id="93" begin="14" end="43"/>
			<lne id="94" begin="46" end="46"/>
			<lne id="95" begin="47" end="47"/>
			<lne id="96" begin="46" end="48"/>
			<lne id="97" begin="11" end="50"/>
			<lne id="98" begin="9" end="52"/>
			<lne id="60" begin="8" end="53"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="6" name="99" begin="27" end="30"/>
			<lve slot="5" name="33" begin="21" end="41"/>
			<lve slot="4" name="100" begin="17" end="43"/>
			<lve slot="4" name="33" begin="45" end="49"/>
			<lve slot="3" name="54" begin="7" end="53"/>
			<lve slot="2" name="52" begin="3" end="53"/>
			<lve slot="0" name="17" begin="0" end="53"/>
			<lve slot="1" name="101" begin="0" end="53"/>
		</localvariabletable>
	</operation>
	<operation name="102">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="103"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="102"/>
			<call arg="51"/>
			<dup/>
			<push arg="104"/>
			<load arg="19"/>
			<call arg="53"/>
			<dup/>
			<push arg="105"/>
			<push arg="106"/>
			<push arg="56"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<call arg="57"/>
			<pushf/>
			<call arg="58"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="107" begin="25" end="25"/>
			<lne id="108" begin="25" end="26"/>
			<lne id="109" begin="23" end="28"/>
			<lne id="110" begin="22" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="105" begin="18" end="30"/>
			<lve slot="0" name="17" begin="0" end="30"/>
			<lve slot="1" name="104" begin="0" end="30"/>
		</localvariabletable>
	</operation>
</asm>
