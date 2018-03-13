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
		<constant value="getDefNameSet"/>
		<constant value="MTypeA!RootA;"/>
		<constant value="0"/>
		<constant value="elms"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.asSet():J"/>
		<constant value="9:2-9:6"/>
		<constant value="9:2-9:11"/>
		<constant value="9:23-9:24"/>
		<constant value="9:23-9:29"/>
		<constant value="9:2-9:30"/>
		<constant value="9:2-9:38"/>
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
		<constant value="defBLst"/>
		<constant value="J.getDefNameSet():J"/>
		<constant value="DefinitionB"/>
		<constant value="elmBLst"/>
		<constant value="ElementB"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="16:9-16:20"/>
		<constant value="16:3-21:4"/>
		<constant value="22:59-22:62"/>
		<constant value="22:59-22:79"/>
		<constant value="22:3-24:4"/>
		<constant value="25:54-25:57"/>
		<constant value="25:54-25:62"/>
		<constant value="25:3-28:4"/>
		<constant value="__applyRootA2RootB"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="5"/>
		<constant value="defs"/>
		<constant value="6"/>
		<constant value="CJ.asSequence():QJ"/>
		<constant value="7"/>
		<constant value="QJ.at(I):J"/>
		<constant value="8"/>
		<constant value="B.not():B"/>
		<constant value="51"/>
		<constant value="I.+(I):I"/>
		<constant value="9"/>
		<constant value="J.=(J):J"/>
		<constant value="89"/>
		<constant value="J.first():J"/>
		<constant value="99"/>
		<constant value="definition"/>
		<constant value="18:12-18:19"/>
		<constant value="18:4-18:19"/>
		<constant value="20:12-20:19"/>
		<constant value="20:4-20:19"/>
		<constant value="23:12-23:19"/>
		<constant value="23:4-23:19"/>
		<constant value="27:19-27:22"/>
		<constant value="27:19-27:27"/>
		<constant value="27:41-27:42"/>
		<constant value="27:41-27:47"/>
		<constant value="27:50-27:54"/>
		<constant value="27:50-27:59"/>
		<constant value="27:41-27:59"/>
		<constant value="27:19-27:61"/>
		<constant value="27:19-27:70"/>
		<constant value="27:5-27:70"/>
		<constant value="defName"/>
		<constant value="collection"/>
		<constant value="counter"/>
		<constant value="d"/>
		<constant value="elmA"/>
		<constant value="link"/>
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
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<get arg="48"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<call arg="49"/>
			<enditerate/>
			<call arg="50"/>
		</code>
		<linenumbertable>
			<lne id="51" begin="3" end="3"/>
			<lne id="52" begin="3" end="4"/>
			<lne id="53" begin="7" end="7"/>
			<lne id="54" begin="7" end="8"/>
			<lne id="55" begin="0" end="10"/>
			<lne id="56" begin="0" end="11"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="6" end="9"/>
			<lve slot="0" name="17" begin="0" end="11"/>
		</localvariabletable>
	</operation>
	<operation name="57">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="58"/>
			<push arg="59"/>
			<findme/>
			<push arg="60"/>
			<call arg="61"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="62"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<call arg="63"/>
			<dup/>
			<push arg="64"/>
			<load arg="19"/>
			<call arg="65"/>
			<dup/>
			<push arg="66"/>
			<push arg="67"/>
			<push arg="68"/>
			<new/>
			<call arg="69"/>
			<dup/>
			<push arg="70"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<call arg="71"/>
			<iterate/>
			<pop/>
			<push arg="72"/>
			<push arg="68"/>
			<new/>
			<call arg="49"/>
			<enditerate/>
			<call arg="69"/>
			<dup/>
			<push arg="73"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<get arg="48"/>
			<iterate/>
			<pop/>
			<push arg="74"/>
			<push arg="68"/>
			<new/>
			<call arg="49"/>
			<enditerate/>
			<call arg="69"/>
			<pusht/>
			<call arg="75"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="76" begin="21" end="23"/>
			<lne id="77" begin="19" end="24"/>
			<lne id="78" begin="30" end="30"/>
			<lne id="79" begin="30" end="31"/>
			<lne id="80" begin="25" end="39"/>
			<lne id="81" begin="45" end="45"/>
			<lne id="82" begin="45" end="46"/>
			<lne id="83" begin="40" end="54"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="64" begin="6" end="56"/>
			<lve slot="0" name="17" begin="0" end="57"/>
		</localvariabletable>
	</operation>
	<operation name="84">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="85"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="64"/>
			<call arg="86"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="66"/>
			<call arg="87"/>
			<store arg="88"/>
			<load arg="19"/>
			<push arg="70"/>
			<call arg="87"/>
			<store arg="89"/>
			<load arg="19"/>
			<push arg="73"/>
			<call arg="87"/>
			<store arg="90"/>
			<load arg="88"/>
			<dup/>
			<getasm/>
			<load arg="89"/>
			<call arg="30"/>
			<set arg="91"/>
			<dup/>
			<getasm/>
			<load arg="90"/>
			<call arg="30"/>
			<set arg="48"/>
			<pop/>
			<pushi arg="19"/>
			<store arg="92"/>
			<load arg="29"/>
			<call arg="71"/>
			<call arg="93"/>
			<store arg="94"/>
			<load arg="89"/>
			<iterate/>
			<load arg="94"/>
			<load arg="92"/>
			<call arg="95"/>
			<store arg="96"/>
			<dup/>
			<getasm/>
			<load arg="96"/>
			<dup/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<call arg="97"/>
			<if arg="98"/>
			<load arg="92"/>
			<call arg="95"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="92"/>
			<pushi arg="19"/>
			<call arg="99"/>
			<store arg="92"/>
			<enditerate/>
			<pushi arg="19"/>
			<store arg="92"/>
			<load arg="29"/>
			<get arg="48"/>
			<call arg="93"/>
			<store arg="94"/>
			<load arg="90"/>
			<iterate/>
			<load arg="94"/>
			<load arg="92"/>
			<call arg="95"/>
			<store arg="96"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="88"/>
			<get arg="91"/>
			<iterate/>
			<store arg="100"/>
			<load arg="100"/>
			<get arg="38"/>
			<load arg="96"/>
			<get arg="38"/>
			<call arg="101"/>
			<call arg="97"/>
			<if arg="102"/>
			<load arg="100"/>
			<call arg="49"/>
			<enditerate/>
			<call arg="103"/>
			<dup/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<call arg="97"/>
			<if arg="104"/>
			<load arg="92"/>
			<call arg="95"/>
			<call arg="30"/>
			<set arg="105"/>
			<pop/>
			<load arg="92"/>
			<pushi arg="19"/>
			<call arg="99"/>
			<store arg="92"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="106" begin="19" end="19"/>
			<lne id="107" begin="17" end="21"/>
			<lne id="108" begin="24" end="24"/>
			<lne id="109" begin="22" end="26"/>
			<lne id="77" begin="16" end="27"/>
			<lne id="78" begin="30" end="30"/>
			<lne id="79" begin="30" end="31"/>
			<lne id="110" begin="42" end="42"/>
			<lne id="111" begin="40" end="52"/>
			<lne id="80" begin="28" end="58"/>
			<lne id="81" begin="61" end="61"/>
			<lne id="82" begin="61" end="62"/>
			<lne id="112" begin="76" end="76"/>
			<lne id="113" begin="76" end="77"/>
			<lne id="114" begin="80" end="80"/>
			<lne id="115" begin="80" end="81"/>
			<lne id="116" begin="82" end="82"/>
			<lne id="117" begin="82" end="83"/>
			<lne id="118" begin="80" end="84"/>
			<lne id="119" begin="73" end="89"/>
			<lne id="120" begin="73" end="90"/>
			<lne id="121" begin="71" end="100"/>
			<lne id="83" begin="59" end="106"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="8" name="122" begin="39" end="52"/>
			<lve slot="7" name="123" begin="33" end="58"/>
			<lve slot="6" name="124" begin="29" end="58"/>
			<lve slot="9" name="125" begin="79" end="88"/>
			<lve slot="8" name="126" begin="70" end="100"/>
			<lve slot="7" name="123" begin="64" end="106"/>
			<lve slot="6" name="124" begin="60" end="106"/>
			<lve slot="3" name="66" begin="7" end="106"/>
			<lve slot="4" name="70" begin="11" end="106"/>
			<lve slot="5" name="73" begin="15" end="106"/>
			<lve slot="2" name="64" begin="3" end="106"/>
			<lve slot="0" name="17" begin="0" end="106"/>
			<lve slot="1" name="127" begin="0" end="106"/>
		</localvariabletable>
	</operation>
</asm>
