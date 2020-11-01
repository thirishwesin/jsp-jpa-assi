<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<jsp:include page="resources/common.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="resources/menu.jsp"></jsp:include>
		<div class="row mt-3">
			<div class="col-8">
				<h3>All Courses</h3>
			</div>
			<div class="col offset-2">
				<a href="student-add.jsp" class="btn btn-success">Add New Student</a>
			</div>
				<table class="table mt-2">
					<thead>
						<tr>
							<th>#</th>
							<th>Student Name</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					
					 <c:forEach items="${student}" var="s">
					<tr>
						<td><c:set var="numberOfRows" value="${numberOfRows+1}"/>
							<c:out value="${numberOfRows}"/></td>
						<td>${s.name }</td>
						<td>${s.email }</td>
						<td>${s.phone }</td>
						
						<td>
						<c:url var="action" value="/student-edit">
						<c:param name="studentid">${s.id }</c:param></c:url>
						<a href="${action}" class="btn btn-outline-success">Edit</a>
						<c:url var="del" value="/student-delete">
						<c:param name="studentid">${s.id }</c:param></c:url>
						<a href="${del }" class="btn btn-outline-danger">Delete</a></td>
						
					</tr>
					</c:forEach>
					
					</tbody>
				</table>
		</div>
	</div>
</body>
</html>