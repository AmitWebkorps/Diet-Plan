function addIngredients()
{
	input=document.getElementById('input');
	output=document.getElementById('output');
	x=input.value;
	if(x!="")
	{
	if(output.value!="")
	 output.value=output.value+","+x;
	else 
		 output.value=input.value;
	}
	input.value="";
}