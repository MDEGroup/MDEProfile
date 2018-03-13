<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="EMOOSE4KM3"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="self"/>
		<constant value="WRC"/>
		<constant value="MKM3!Classifier;"/>
		<constant value="0"/>
		<constant value="allReferences"/>
		<constant value="J.size():J"/>
		<constant value="23:2-23:6"/>
		<constant value="23:2-23:20"/>
		<constant value="23:2-23:28"/>
		<constant value="DIT"/>
		<constant value="isRoot"/>
		<constant value="26"/>
		<constant value="J.PARN():J"/>
		<constant value="1"/>
		<constant value="J.=(J):J"/>
		<constant value="10"/>
		<constant value="11"/>
		<constant value="parents"/>
		<constant value="2"/>
		<constant value="J.DIT():J"/>
		<constant value="J.+(J):J"/>
		<constant value="27"/>
		<constant value="31:5-31:9"/>
		<constant value="31:5-31:16"/>
		<constant value="33:11-33:15"/>
		<constant value="33:11-33:22"/>
		<constant value="33:25-33:26"/>
		<constant value="33:11-33:26"/>
		<constant value="35:10-35:11"/>
		<constant value="34:10-34:11"/>
		<constant value="33:8-36:9"/>
		<constant value="36:53-36:54"/>
		<constant value="36:12-36:16"/>
		<constant value="36:12-36:24"/>
		<constant value="36:55-36:58"/>
		<constant value="36:61-36:62"/>
		<constant value="36:61-36:68"/>
		<constant value="36:55-36:68"/>
		<constant value="36:12-36:69"/>
		<constant value="33:8-36:69"/>
		<constant value="32:8-32:9"/>
		<constant value="31:2-37:7"/>
		<constant value="c"/>
		<constant value="acc"/>
		<constant value="NOC"/>
		<constant value="J.CHIN():J"/>
		<constant value="45:2-45:6"/>
		<constant value="45:2-45:13"/>
		<constant value="CBO"/>
		<constant value="coupledClasses"/>
		<constant value="53:2-53:6"/>
		<constant value="53:2-53:21"/>
		<constant value="53:2-53:29"/>
		<constant value="SIZE2"/>
		<constant value="J.NRN():J"/>
		<constant value="J.NAN():J"/>
		<constant value="65:2-65:6"/>
		<constant value="65:2-65:12"/>
		<constant value="65:15-65:19"/>
		<constant value="65:15-65:25"/>
		<constant value="65:2-65:25"/>
	</cp>
	<operation name="1">
		<context type="2"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="4">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<load arg="6"/>
			<get arg="7"/>
			<call arg="8"/>
		</code>
		<linenumbertable>
			<lne id="9" begin="0" end="0"/>
			<lne id="10" begin="0" end="1"/>
			<lne id="11" begin="0" end="2"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="2"/>
		</localvariabletable>
	</operation>
	<operation name="12">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<load arg="6"/>
			<get arg="13"/>
			<if arg="14"/>
			<load arg="6"/>
			<call arg="15"/>
			<pushi arg="16"/>
			<call arg="17"/>
			<if arg="18"/>
			<pushi arg="6"/>
			<goto arg="19"/>
			<pushi arg="16"/>
			<pushi arg="6"/>
			<store arg="16"/>
			<load arg="6"/>
			<get arg="20"/>
			<iterate/>
			<store arg="21"/>
			<load arg="16"/>
			<load arg="21"/>
			<call arg="22"/>
			<call arg="23"/>
			<store arg="16"/>
			<enditerate/>
			<load arg="16"/>
			<call arg="23"/>
			<goto arg="24"/>
			<pushi arg="6"/>
		</code>
		<linenumbertable>
			<lne id="25" begin="0" end="0"/>
			<lne id="26" begin="0" end="1"/>
			<lne id="27" begin="3" end="3"/>
			<lne id="28" begin="3" end="4"/>
			<lne id="29" begin="5" end="5"/>
			<lne id="30" begin="3" end="6"/>
			<lne id="31" begin="8" end="8"/>
			<lne id="32" begin="10" end="10"/>
			<lne id="33" begin="3" end="10"/>
			<lne id="34" begin="11" end="11"/>
			<lne id="35" begin="13" end="13"/>
			<lne id="36" begin="13" end="14"/>
			<lne id="37" begin="17" end="17"/>
			<lne id="38" begin="18" end="18"/>
			<lne id="39" begin="18" end="19"/>
			<lne id="40" begin="17" end="20"/>
			<lne id="41" begin="11" end="23"/>
			<lne id="42" begin="3" end="24"/>
			<lne id="43" begin="26" end="26"/>
			<lne id="44" begin="0" end="26"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="45" begin="16" end="21"/>
			<lve slot="1" name="46" begin="12" end="23"/>
			<lve slot="0" name="3" begin="0" end="26"/>
		</localvariabletable>
	</operation>
	<operation name="47">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<load arg="6"/>
			<call arg="48"/>
		</code>
		<linenumbertable>
			<lne id="49" begin="0" end="0"/>
			<lne id="50" begin="0" end="1"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<load arg="6"/>
			<get arg="52"/>
			<call arg="8"/>
		</code>
		<linenumbertable>
			<lne id="53" begin="0" end="0"/>
			<lne id="54" begin="0" end="1"/>
			<lne id="55" begin="0" end="2"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="2"/>
		</localvariabletable>
	</operation>
	<operation name="56">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<load arg="6"/>
			<call arg="57"/>
			<load arg="6"/>
			<call arg="58"/>
			<call arg="23"/>
		</code>
		<linenumbertable>
			<lne id="59" begin="0" end="0"/>
			<lne id="60" begin="0" end="1"/>
			<lne id="61" begin="2" end="2"/>
			<lne id="62" begin="2" end="3"/>
			<lne id="63" begin="0" end="4"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="4"/>
		</localvariabletable>
	</operation>
</asm>
