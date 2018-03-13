<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="A2B"/>
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
		<constant value="A.__matchRoot():V"/>
		<constant value="A.__matchElement():V"/>
		<constant value="__exec__"/>
		<constant value="Root"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyRoot(NTransientLink;):V"/>
		<constant value="Element"/>
		<constant value="A.__applyElement(NTransientLink;):V"/>
		<constant value="__matchRoot"/>
		<constant value="RootA"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="s"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="t"/>
		<constant value="RootB"/>
		<constant value="B"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="first_element"/>
		<constant value="ElementB"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="13:7-13:14"/>
		<constant value="13:3-15:4"/>
		<constant value="16:19-16:29"/>
		<constant value="16:3-18:4"/>
		<constant value="__applyRoot"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="OrderedSet"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="elms"/>
		<constant value="B_"/>
		<constant value="J.+(J):J"/>
		<constant value="14:24-14:37"/>
		<constant value="14:39-14:40"/>
		<constant value="14:39-14:45"/>
		<constant value="14:12-14:46"/>
		<constant value="14:4-14:46"/>
		<constant value="17:12-17:16"/>
		<constant value="17:19-17:20"/>
		<constant value="17:19-17:25"/>
		<constant value="17:12-17:25"/>
		<constant value="17:4-17:25"/>
		<constant value="link"/>
		<constant value="__matchElement"/>
		<constant value="ElementA"/>
		<constant value="27:7-27:17"/>
		<constant value="27:3-29:4"/>
		<constant value="__applyElement"/>
		<constant value="28:12-28:16"/>
		<constant value="28:19-28:20"/>
		<constant value="28:19-28:25"/>
		<constant value="28:12-28:25"/>
		<constant value="28:4-28:25"/>
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
			<getasm/>
			<call arg="41"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="49"/>
			<push arg="6"/>
			<findme/>
			<push arg="50"/>
			<call arg="51"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="52"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<call arg="53"/>
			<dup/>
			<push arg="54"/>
			<load arg="19"/>
			<call arg="55"/>
			<dup/>
			<push arg="56"/>
			<push arg="57"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="61"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<pusht/>
			<call arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="63" begin="21" end="23"/>
			<lne id="64" begin="19" end="24"/>
			<lne id="65" begin="27" end="29"/>
			<lne id="66" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="54" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="67">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="68"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="69"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="56"/>
			<call arg="70"/>
			<store arg="71"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="70"/>
			<store arg="72"/>
			<load arg="71"/>
			<dup/>
			<getasm/>
			<push arg="73"/>
			<push arg="8"/>
			<new/>
			<load arg="72"/>
			<call arg="74"/>
			<load arg="29"/>
			<get arg="75"/>
			<call arg="74"/>
			<call arg="30"/>
			<set arg="75"/>
			<pop/>
			<load arg="72"/>
			<dup/>
			<getasm/>
			<push arg="76"/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="77"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="78" begin="18" end="18"/>
			<lne id="79" begin="20" end="20"/>
			<lne id="80" begin="20" end="21"/>
			<lne id="81" begin="15" end="22"/>
			<lne id="82" begin="13" end="24"/>
			<lne id="64" begin="12" end="25"/>
			<lne id="83" begin="29" end="29"/>
			<lne id="84" begin="30" end="30"/>
			<lne id="85" begin="30" end="31"/>
			<lne id="86" begin="29" end="32"/>
			<lne id="87" begin="27" end="34"/>
			<lne id="66" begin="26" end="35"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="56" begin="7" end="35"/>
			<lve slot="4" name="60" begin="11" end="35"/>
			<lve slot="2" name="54" begin="3" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="88" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="89">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="90"/>
			<push arg="6"/>
			<findme/>
			<push arg="50"/>
			<call arg="51"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="52"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<call arg="53"/>
			<dup/>
			<push arg="54"/>
			<load arg="19"/>
			<call arg="55"/>
			<dup/>
			<push arg="56"/>
			<push arg="61"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<pusht/>
			<call arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="91" begin="21" end="23"/>
			<lne id="92" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="54" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="93">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="68"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="69"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="56"/>
			<call arg="70"/>
			<store arg="71"/>
			<load arg="71"/>
			<dup/>
			<getasm/>
			<push arg="76"/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="77"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="94" begin="11" end="11"/>
			<lne id="95" begin="12" end="12"/>
			<lne id="96" begin="12" end="13"/>
			<lne id="97" begin="11" end="14"/>
			<lne id="98" begin="9" end="16"/>
			<lne id="92" begin="8" end="17"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="56" begin="7" end="17"/>
			<lve slot="2" name="54" begin="3" end="17"/>
			<lve slot="0" name="17" begin="0" end="17"/>
			<lve slot="1" name="88" begin="0" end="17"/>
		</localvariabletable>
	</operation>
</asm>
