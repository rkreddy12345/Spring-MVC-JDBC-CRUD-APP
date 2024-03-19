<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>EMS-Add Employee</title>
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
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="add">Add</a></li>
					<li class="nav-item"><a class="nav-link" href="getAll">All</a>
					</li>
				</ul>

			</div>
		</div>
	</nav>
	<br>

	<div class="card border-info mb-3">
		<div class="card-body">
			
			<br>
			<form action="update" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">ID</label>
					<input type="text" class="form-control" id="id" name="id" readonly value="<c:out value="${emp.id}" />">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input type="text" class="form-control" id="name" name="name" value="<c:out value="${emp.name}" />">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Email</label>
					<input type="text" class="form-control" id="email" name="email" value="<c:out value="${emp.email}" />">
				</div>

				<div class="mb-3">
					<select class="form-select" aria-label="Default select example"
						name="dept" id="dept">
						<option selected>Select department</option>
						<option value="PMS">PMS</option>
						<option value="GMS">GMS</option>
						<option value="LARS">LARS</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Salary</label>
					<input type="text" class="form-control" id="salary" name="salary" value="<c:out value="${emp.salary}" />">
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</form>
		</div>

	</div>
</body>
<script>
    
    var empDepartment = "<c:out value="${emp.dept}" />";

    var selectElement = document.getElementById("dept");

    for (var i = 0; i < selectElement.options.length; i++) {
        if (selectElement.options[i].value === empDepartment) {
            selectElement.options[i].selected = true;
            break;
        }
    }
</script>
</html>