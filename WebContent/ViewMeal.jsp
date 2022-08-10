<%@page import="com.healthymeal.entity.MealDetails,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%@ include file="UserOptions.jsp"%>
	<% ArrayList<MealDetails> meals =(ArrayList<MealDetails>)request.getAttribute("meal");%>
	<div class="container-fluid">
		<form action="AddMealPerDay" method="Post">
			<table class="table">
				<tr>
					<th scope="col">S no.</th>
					<th scope="col">Meal Name</th>
					<th scope="col">Meal Image</th>
					<th scope="col">Meal Price</th>
					<th scope="col">Edit</th>
				</tr>
				<tbody>
					<%
					  
					 for(int i=0;i<meals.size();i++)
					 {%>
					<tr>
						<td scope="row"><%=i+1%></td>
						<td scope="row"><%= meals.get(i).getMealName() %></td>
						<td scope="row"><img alt="meal image"
							src="images/<%= meals.get(i).getMealImage()%>" width="70px"
							height="70px"></td>
						<td scope="row"><%= meals.get(i).getMealPrice()%></td>

					</tr>
					<%}%>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>