
<% 
		HttpSession session2=(HttpSession)request.getSession(false);
		String emails=(String)session2.getAttribute("email");
		
		%>
<nav class="container-fluid  align-middle mb-3">
	<div class=" navbar bg-success pt-3 ml-auto">
		<ul class="d-flex list-unstyled ">
			<li class="mx-3 "><a href="UserViewPlan"
				class="text-decoration-none text-light py-1 btn">View Plans</a></li>
			<li class="mx-3"><a href="BuyedPlan"
				class="text-decoration-none text-light py-1 btn">Buyed Plans</a></li>
			<li class="mx-3"><a href="ViewMeal"
				class="text-decoration-none text-light py-1 btn">View Meal</a></li>
		</ul>
		<div>
			<button class="btn btn-primary" type="submit"><%=emails %></button>
			<a href="Logout"
				class="text-decoration-none text-light py-1 btn btn-warning">Logout</a>
		</div>
	</div>
</nav>