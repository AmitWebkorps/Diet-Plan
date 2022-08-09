<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList,com.healthymeal.modal.Plans" %>
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
	<%@ include file="UserOptions.jsp"%>
                  <%
                   Plans plans=(Plans)request.getAttribute("plan");
                  if(plans!=null)
                  {
                   %>
	<div class="container bg-white">
		<div class="mt-5">
			<div class="mt-5 text-muted">
              <form action="ViewPlanDetails" method="get">
		       <h3>Buyed Plan:</h3>
				<table class="table">
                  <thead>
                   <tr>
                   <th scope="col">Plan Name</th>
                   <th scope="col">Plan Days</th>
                   <th scope="col">Plan Price</th>
                   <th scope="col">Details</th>
                   </tr>
                  </thead>
                  <tbody>
                  <tr>
                 <td scope="col"> 
                         <div class="col-sm-10">
                                 <input type="text" readonly class="form-control-plaintext" name="planName" id="staticEmail" value="<%=plans.getPlanName()%>">
                        </div>
                  </td>
                  <td scope="col"> 
                         <div class="col-sm-10">
                                 <input type="text" readonly class="form-control-plaintext" name="planDays" id="staticEmail" value="<%=plans.getPlanDays()%>">
                        </div>
                  </td>
                  <td scope="col"> 
                         <div class="col-sm-10">
                                 <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="<%=plans.getPlanPrice()%>Rs">
                        </div>
                  </td>
                  
                   <td scope="col"><input type="submit"  value="View Details" class="btn btn-success"></td>
                  </tr>
                  </tbody>
                  </table>
                  </form>
			</div>
		</div>
	</div>
	<%} 
      else
      {
       %>
          <h1>No Data Found</h1>
       <%
      }
	%>
</body>
</html>