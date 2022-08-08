<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<link rel="icon" type="image/x-icon" href="images\logo.png">
<title>Healthy Meal</title>
</head>
<body class="bg-light">
	<%@ include file="head.jsp"%>
	<%
  String s1=request.getParameter("res");
  if(s1!=null)
  {
	  if(s1.equals("success"))
	  {
     %>
	<div>
		<p class="bg-primary text-white">Plan Buyed SuccessFully</p>
	</div>
	<%
	
	  }
	  else if(s1.equals("Already"))
	  {
     %>
	<div>
		<p class="bg-primary text-white">Already Have an Active Plan</p>
	</div>
	<%
	
	  }
	  else if(s1.equals("failer"))
	  {
     %>
	<div>
		<p class="bg-danger text-white">Something went wrong</p>
	</div>
	<%
	  }
  }%>
	<%@ include file="UserOptions.jsp"%>

</body>
</html>