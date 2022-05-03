<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<h1>Using IoC Container</h1>
		<h3>Registrations for ${openClass.course.name}</h3>
		
		<div>
			<c:url var="addNew" value="/registration-edit">
				<c:param name="openClassId" value="${openClass.id}"></c:param>
			</c:url>
			<a class="btn btn-primary" href="${addNew}">Add New Registration</a>
		</div>
		
		<div class="mt-4">
		<c:choose>
				<c:when test="${empty registrations}">
					<div class="alert alert-warning">
							There is no registration for ${openClass.course.name}. Please create new registration.
					</div>
				</c:when>
				
				<c:otherwise>
					
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Student Name</th>
								<th>Phone</th>	
								<th>Email</th>
								<th>Course Name</th>
								<th>Teacher</th>
								<th>Start Date</th>
							</tr>
						</thead>
						
						<tbody>
							
							<c:forEach var="r" items="${registrations}">
								<tr>
									<td>${r.id}</td>
									<td>${r.student}</td>
									<td>${r.phone}</td>
									<td>${r.email}</td>
									<td>${r.openClass.course.name}</td>
									<td>${r.openClass.teacher}</td>
									<td>${r.openClass.startDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>