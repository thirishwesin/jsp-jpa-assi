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
				<a href="classes-add.jsp" class="btn btn-success">Add New Class</a>
			</div>
				<table class="table mt-2">
					<thead>
						<tr>
							<th>#</th>
							<th>Class Name</th>
							<th>Start Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					
					  <c:forEach items="${classes}" var="c">
					<tr>
						<td><c:set var="numberOfRows" value="${numberOfRows+1}"/>
							<c:out value="${numberOfRows}"/></td>
						<td>${c.name }</td>
						<td>${c.start_date }</td>
						
						<td>
						<c:url var="action" value="/class-edit">
						<c:param name="classid">${c.id }</c:param></c:url>
						<a href="${action }" class="btn btn-outline-success">Edit</a>
						<c:url var="del" value="/class-delete">
						<c:param name="classid">${c.id }</c:param></c:url>
						<a href="${del}" class="btn btn-outline-danger">Delete</a></td> 
						
					</tr>
					</c:forEach>
					
					</tbody>
				</table>
		</div>
	</div>
</body>
</html>