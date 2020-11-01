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
		<div class="row">
			<h4 class="col-6 mt-2">${not empty classes ? 'Edit Class':'Add New Class'}</h4>
		</div>

		<c:url value="/classes-add" var="save"></c:url>
		<form action="${save }" class="form col-6" method="post" >
			<input type="hidden" name="classid" value="${classes.id }"> 
			
			<div class="form-group">
				<label>Class Name</label> <input type="text" 
					name="classname" value="${classes.name }" class="form-control" required="required"
					placeholder="Enter Class Name" />
					
				 
				 
				 <label>Start Date</label> 
				 <input type="date" name="sdate" value="${classes.start_date }" class="form-control" required="required"/>

				
				 </div>
			<button type="submit" class="btn btn-success">Save</button>
			<button type="reset" class="btn btn-danger">Clear</button>

		</form>
	</div>
</body>
</html>