function indexOf(node, item)
{
  var index = 0;
  var current = first_child(node);
  
  while (current != null)
  {
    if (current == item)
    {
      return index;
    }
    else
    {
      current = node_after(current);
      index++;
    }
  }
  
  return 0;
}

function at(node, index)
{
  var i = 0;
  var current = first_child(node);
  
  while (current != null)
  {
    if (i == index)
    {
      return current;
    }
    else
    {
      current = node_after(current);
      i++;
    }
  }
  
  return current;
}

function matchPreferredValue(rawValue, inputText)
{    
  var result = false;
  var value = parseFloat(rawValue);
  
  if (inputText.value.substring(0,2) == "<=")
  {
    result = (value <= parseFloat(inputText.value.substring(2,inputText.value.length)));
  }
  else if (inputText.value.substring(0,2) == ">=")
  {
    result = (value >= parseFloat(inputText.value.substring(2,inputText.value.length)));
  }
  else if (inputText.value.substring(0,2) == "==")
  {
    result = (value == parseFloat(inputText.value.substring(2,inputText.value.length)));
  }
  else if (inputText.value.substring(0,2) == "!=")
  {
    result = (value != parseFloat(inputText.value.substring(2,inputText.value.length)));
  }
  else if (inputText.value.substring(0,1) == "<")
  {
    result = (value < parseFloat(inputText.value.substring(1,inputText.value.length)));
  }
  else if (inputText.value.substring(0,1) == ">")
  {
    result = (value > parseFloat(inputText.value.substring(1,inputText.value.length)));
  }
  else if (inputText.value.substring(0,1) == "=")
  {
    result = (value == parseFloat(inputText.value.substring(1,inputText.value.length)));
  } 
  else if (inputText.value.substring(0,1) == "!")
  {
    result = (value != parseFloat(inputText.value.substring(1,inputText.value.length)));
    }
  else
  {
    result = (value <= parseFloat(inputText.value));
    if (inputText.value != "")
    {
      inputText.value = "<=" + inputText.value
    }
  }
  
  return result;
}

function changeStyleOnEnter(event, inputText)
{
  if (event.keyCode == 13)
  {
  	changeStyle(inputText);
  }
}

function changeStyle(inputText)
{
  var tdInputText = inputText.parentNode;
  var index = indexOf(tdInputText.parentNode,tdInputText);
     
  if (index != -1)
  {
    for (var trValue = node_after(tdInputText.parentNode); trValue != null; trValue = node_after(trValue))
    {
      var tdValue = at(trValue,index)
    
      if (matchPreferredValue(tdValue.innerHTML,inputText))
      {
        tdValue.className = "";
      }
      else
      {
        tdValue.className = "ignoredValue";
      }
    }
  }
}

function is_all_ws(nod)
{
  return !(/[^\t\n\r ]/.test(nod.data));
}

function is_ignorable(nod)
{
  return (nod.nodeType == 8) ||
         ((nod.nodeType == 3) && is_all_ws(nod));
}
function node_after(sib)
{
  while ((sib = sib.nextSibling)) {
    if (!is_ignorable(sib)) return sib;
  }
  return null;
}
function first_child(par)
{
  var res=par.firstChild;
  while (res) {
    if (!is_ignorable(res)) return res;
    res = res.nextSibling;
  }
  return null;
}