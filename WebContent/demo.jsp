<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="update">

enter id which you want to update<input type="text" name="id"> <br>
enter new address <input type="text" name="address"><br><br>
<input type="submit" value="Update">

</form>
<br><br>
<form action="display">
<br>
enter submit to see the details<br><br>
<input type="submit" value="Display">

</form><br><br>
<form action="delete">

enter id which you want to delete<input type="text" name="idd"> <br>
<br>
<input type="submit" value="Delete">

</form><br><br>
<form action="insert" onsubmit="return validate()">

enter id of employee<input type="text" name="ids" id="id"> <br>
<span id="ide" style="color:red;"></span><br>
enter name of employee<input type="text" name ="names" id="name"><br>
<span id="namee" style="color:red;"></span><br>
enter address <input type="text" name="addres" id="adress"><br>
<span id="add" style="color:red;"></span><br>
select state <select name="state">
<option value="">Madhya Pradsh</option>
<option value="">Uttar Pradsh</option>
<option value="">Andhra Pradsh</option>
</select>
<br><br>
<input type="submit" value="Insert">

</form>

<script>
document.getElementById("ide").innerHTML=" "
	document.getElementById("namee").innerHTML=" "
		document.getElementById("add").innerHTML=" "
function validate() {
	if(document.getElementById("id").value== ""){
		alert("Please enter the id");
		document.getElementById("ide").innerHTML="Please enter the id"
		
		return false;
	}
	if(document.getElementById("name").value== ""){
		alert("Please enter the name");
		document.getElementById("namee").innerHTML="Please enter the name"
		return false;
	}
	if(document.getElementById("adress").value== ""){
		alert("Please enter the adress");
		document.getElementById("add").innerHTML="Please enter the address"
		return false;
	}	
}
</script>
</body>
</html>