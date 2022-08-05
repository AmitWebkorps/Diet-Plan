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
<body>
	<%@ include file="head.jsp"%>
	<div class="container">
		<div class="card p-4">
			<h4 class="bg-success text-white px-3 py-2">Categories :</h4>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Days :</label>
				<select class="form-select text-success"
					aria-label="Default select example" name="role">
					<option value="7">7 Days</option>
					<option value="14">14 Days</option>
					<option value="21">21 Days</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Meals
					for Every Day:</label>
				<ol class="">
					<li class="m-3">Breakfast</li>
					<li class="m-3">Morning snacks</li>
					<li class="m-3">Lunch</li>
					<li class="m-3">Afternoon snacks</li>
					<li class="m-3">Dinner</li>
					<li class="m-3">Hydration</li>
				</ol>
			</div>
		</div>
	</div>

</body>
</html>