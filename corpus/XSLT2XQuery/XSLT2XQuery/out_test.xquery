for $var in document("xmlFile.xml")/*
return
<emps>{fctemployee($var/employee)}</emps>

define function fctemployee($paramVar)
{
for $var in $paramVar
return
let $var := $var
where $var/salary>2000
return
<emp>{$var/name}{$var/firstname}</emp>

}
