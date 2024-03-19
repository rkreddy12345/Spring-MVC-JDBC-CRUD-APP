<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>EMS-Home</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">EMS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="add">Add</a></li>
					<li class="nav-item"><a class="nav-link" href="getAll">All</a>
					</li>

				</ul>

			</div>
		</div>
	</nav>
	<br>
	<div class="card border-info mb-3 text-dark bg-light">
	<div class="card-body">
		<h5 class="card-title">Employee Management System</h5>
		
		<p class="card-text">EMS (Employee Management System) streamlines the process of adding
			new employees by dynamically generating a unique ID for each one and
			updating their details whenever necessary. It also facilitates
			deleting employees and displaying all employee records. <a
				href="add">Click here to Add an Employee</a></p>
		</div>
	</div>
</body>
</html>