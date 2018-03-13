<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="Lib4MMTree"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="self"/>
		<constant value="isTreeNodeRoot"/>
		<constant value="MMMTree!Node;"/>
		<constant value="0"/>
		<constant value="J.refImmediateComposite():J"/>
		<constant value="J.oclIsUndefined():J"/>
		<constant value="13:2-13:6"/>
		<constant value="13:2-13:30"/>
		<constant value="13:2-13:47"/>
		<constant value="getAllChildren"/>
		<constant value="OrderedSet"/>
		<constant value="#native"/>
		<constant value="1"/>
		<constant value="children"/>
		<constant value="2"/>
		<constant value="Node"/>
		<constant value="MMTree"/>
		<constant value="J.oclIsTypeOf(J):J"/>
		<constant value="18"/>
		<constant value="J.append(J):J"/>
		<constant value="22"/>
		<constant value="J.getAllChildren():J"/>
		<constant value="J.union(J):J"/>
		<constant value="20:3-20:15"/>
		<constant value="19:2-19:6"/>
		<constant value="19:2-19:15"/>
		<constant value="21:6-21:11"/>
		<constant value="21:24-21:35"/>
		<constant value="21:6-21:36"/>
		<constant value="24:4-24:12"/>
		<constant value="24:20-24:25"/>
		<constant value="24:4-24:26"/>
		<constant value="22:4-22:12"/>
		<constant value="22:19-22:24"/>
		<constant value="22:19-22:41"/>
		<constant value="22:4-22:42"/>
		<constant value="21:3-25:8"/>
		<constant value="19:2-26:4"/>
		<constant value="child"/>
		<constant value="elements"/>
		<constant value="getLeavesInOrder"/>
		<constant value="Sequence"/>
		<constant value="Leaf"/>
		<constant value="B.not():B"/>
		<constant value="16"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="size"/>
		<constant value="EnumLiteral"/>
		<constant value="big"/>
		<constant value="name"/>
		<constant value="J.=(J):J"/>
		<constant value="37"/>
		<constant value="medium"/>
		<constant value="57"/>
		<constant value="small"/>
		<constant value="78"/>
		<constant value="33:3-33:7"/>
		<constant value="33:3-33:25"/>
		<constant value="33:46-33:55"/>
		<constant value="33:68-33:79"/>
		<constant value="33:46-33:80"/>
		<constant value="33:3-33:81"/>
		<constant value="35:3-35:13"/>
		<constant value="35:29-35:33"/>
		<constant value="35:29-35:38"/>
		<constant value="35:41-35:45"/>
		<constant value="35:29-35:45"/>
		<constant value="35:3-35:46"/>
		<constant value="36:11-36:21"/>
		<constant value="36:37-36:41"/>
		<constant value="36:37-36:46"/>
		<constant value="36:49-36:56"/>
		<constant value="36:37-36:56"/>
		<constant value="36:11-36:57"/>
		<constant value="35:3-36:58"/>
		<constant value="37:11-37:21"/>
		<constant value="37:37-37:41"/>
		<constant value="37:37-37:46"/>
		<constant value="37:49-37:55"/>
		<constant value="37:37-37:55"/>
		<constant value="37:11-37:56"/>
		<constant value="35:3-37:57"/>
		<constant value="32:2-37:57"/>
		<constant value="currChild"/>
		<constant value="leaf"/>
		<constant value="leavesList"/>
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
			<call arg="7"/>
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
			<push arg="13"/>
			<push arg="14"/>
			<new/>
			<store arg="15"/>
			<load arg="6"/>
			<get arg="16"/>
			<iterate/>
			<store arg="17"/>
			<load arg="17"/>
			<push arg="18"/>
			<push arg="19"/>
			<findme/>
			<call arg="20"/>
			<if arg="21"/>
			<load arg="15"/>
			<load arg="17"/>
			<call arg="22"/>
			<goto arg="23"/>
			<load arg="15"/>
			<load arg="17"/>
			<call arg="24"/>
			<call arg="25"/>
			<store arg="15"/>
			<enditerate/>
			<load arg="15"/>
		</code>
		<linenumbertable>
			<lne id="26" begin="0" end="2"/>
			<lne id="27" begin="4" end="4"/>
			<lne id="28" begin="4" end="5"/>
			<lne id="29" begin="8" end="8"/>
			<lne id="30" begin="9" end="11"/>
			<lne id="31" begin="8" end="12"/>
			<lne id="32" begin="14" end="14"/>
			<lne id="33" begin="15" end="15"/>
			<lne id="34" begin="14" end="16"/>
			<lne id="35" begin="18" end="18"/>
			<lne id="36" begin="19" end="19"/>
			<lne id="37" begin="19" end="20"/>
			<lne id="38" begin="18" end="21"/>
			<lne id="39" begin="8" end="21"/>
			<lne id="40" begin="0" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="41" begin="7" end="22"/>
			<lve slot="1" name="42" begin="3" end="24"/>
			<lve slot="0" name="3" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<push arg="44"/>
			<push arg="14"/>
			<new/>
			<load arg="6"/>
			<call arg="24"/>
			<iterate/>
			<store arg="15"/>
			<load arg="15"/>
			<push arg="45"/>
			<push arg="19"/>
			<findme/>
			<call arg="20"/>
			<call arg="46"/>
			<if arg="47"/>
			<load arg="15"/>
			<call arg="48"/>
			<enditerate/>
			<store arg="15"/>
			<push arg="44"/>
			<push arg="14"/>
			<new/>
			<load arg="15"/>
			<iterate/>
			<store arg="17"/>
			<load arg="17"/>
			<get arg="49"/>
			<push arg="50"/>
			<push arg="14"/>
			<new/>
			<dup/>
			<push arg="51"/>
			<set arg="52"/>
			<call arg="53"/>
			<call arg="46"/>
			<if arg="54"/>
			<load arg="17"/>
			<call arg="48"/>
			<enditerate/>
			<push arg="44"/>
			<push arg="14"/>
			<new/>
			<load arg="15"/>
			<iterate/>
			<store arg="17"/>
			<load arg="17"/>
			<get arg="49"/>
			<push arg="50"/>
			<push arg="14"/>
			<new/>
			<dup/>
			<push arg="55"/>
			<set arg="52"/>
			<call arg="53"/>
			<call arg="46"/>
			<if arg="56"/>
			<load arg="17"/>
			<call arg="48"/>
			<enditerate/>
			<call arg="25"/>
			<push arg="44"/>
			<push arg="14"/>
			<new/>
			<load arg="15"/>
			<iterate/>
			<store arg="17"/>
			<load arg="17"/>
			<get arg="49"/>
			<push arg="50"/>
			<push arg="14"/>
			<new/>
			<dup/>
			<push arg="57"/>
			<set arg="52"/>
			<call arg="53"/>
			<call arg="46"/>
			<if arg="58"/>
			<load arg="17"/>
			<call arg="48"/>
			<enditerate/>
			<call arg="25"/>
		</code>
		<linenumbertable>
			<lne id="59" begin="3" end="3"/>
			<lne id="60" begin="3" end="4"/>
			<lne id="61" begin="7" end="7"/>
			<lne id="62" begin="8" end="10"/>
			<lne id="63" begin="7" end="11"/>
			<lne id="64" begin="0" end="16"/>
			<lne id="65" begin="21" end="21"/>
			<lne id="66" begin="24" end="24"/>
			<lne id="67" begin="24" end="25"/>
			<lne id="68" begin="26" end="31"/>
			<lne id="69" begin="24" end="32"/>
			<lne id="70" begin="18" end="37"/>
			<lne id="71" begin="41" end="41"/>
			<lne id="72" begin="44" end="44"/>
			<lne id="73" begin="44" end="45"/>
			<lne id="74" begin="46" end="51"/>
			<lne id="75" begin="44" end="52"/>
			<lne id="76" begin="38" end="57"/>
			<lne id="77" begin="18" end="58"/>
			<lne id="78" begin="62" end="62"/>
			<lne id="79" begin="65" end="65"/>
			<lne id="80" begin="65" end="66"/>
			<lne id="81" begin="67" end="72"/>
			<lne id="82" begin="65" end="73"/>
			<lne id="83" begin="59" end="78"/>
			<lne id="84" begin="18" end="79"/>
			<lne id="85" begin="0" end="79"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="86" begin="6" end="15"/>
			<lve slot="2" name="87" begin="23" end="36"/>
			<lve slot="2" name="87" begin="43" end="56"/>
			<lve slot="2" name="87" begin="64" end="77"/>
			<lve slot="1" name="88" begin="17" end="79"/>
			<lve slot="0" name="3" begin="0" end="79"/>
		</localvariabletable>
	</operation>
</asm>
