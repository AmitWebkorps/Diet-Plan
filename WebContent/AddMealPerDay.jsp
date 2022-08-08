<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
	
<%@ taglib prefix = "c" uri ="http://java.sun.com/jstl/core_rt" %>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
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

<title>Insert title here</title>
</head>
<body class="bg-light">
	<%@ include file="head.jsp"%>
	<%
  String res=request.getParameter("res");
  if(res!=null)
  {
	  if(res.equals("success"))
	  {
     %>
	<div>
		<p class="bg-primary text-white">Uploaded Successfully</p>
	</div>
	<%
	
	  }
	  else if(res.equals("failer"))
	  {
     %>
	<div>
		<p class="bg-danger text-white">Something went wrong</p>
	</div>
	<%
	  }
	  else if(res.equals("duplicate"))
	  {
	%>
	<div>
		<p class="bg-warning text-white">Duplicate Plan Name: This name is already being used</p>
	</div>
	<% 	  
	  }
  }%>
	<%@ include file="Options.jsp"%>


	<div class="container-fluid">
		<form action="AddMealPerDay" method="Post">
		  <div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Enter
					Plan Name</label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter plan name"
					name="planname" required>
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Enter
					Plan Price</label> <input type="Number" class="form-control"
					id="formGroupExampleInput" placeholder="Enter plan price"
					name="planPrice" required>
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Enter
					weight range from:</label> <input type="Number" class="form-control"
					id="formGroupExampleInput" placeholder="Enter plan weight"
					name="weightFrom" required>
					<label for="formGroupExampleInput" class="form-label">to :</label> 
					<input type="Number" class="form-control"
					id="formGroupExampleInput" placeholder="Enter plan weight"
					name="weightTo" required>
			</div>
			<table class="table">
				<tr>
					<th scope="col">Days</th>
					<th scope="col">Breakfast</th>
					<th scope="col">Morning snacks</th>
					<th scope="col">Lunch</th>
					<th scope="col">Afternoon snacks</th>
					<th scope="col">Dinner</th>
					<th scope="col">Hydration</th>
				</tr>
				<tbody>
					<%
	                 int days=Integer.parseInt(request.getParameter("Days"));
					 for(int i=1;i<=days;i++)
					 {
					%>
					<tr>
						<th scope="row"><%=i %> Day</th>
						<%
						 for(int j=1;j<=6;j++)
						 {
						  ArrayList<String> meals =(ArrayList<String>)request.getAttribute("mealName");
						 %>
						<td><select class="form-select" 
							aria-label="Default select example" name="Day<%=i%>Meal<%=j%>" required>
								<option value="">None</option>
						   <%for(String data:meals) {%>
								<option value="<%=data%>"><%=data%></option>
							<%} %>
							
						</select></td>
						<%} %>

					</tr>
					<%} %>
				</tbody>
			</table>
			<input type="text" value="<%=days%>" name="Days" hidden>
			<button type="submit" class="btn btn-success mx-auto mb-5">Add
				Plans</button>
		</form>
	</div>
</body>
</html>