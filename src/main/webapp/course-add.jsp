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
			<h4 class="col-6 mt-2">${not empty course ? 'Edit Course':'Add New Course'}</h4>
		</div>

		<c:url value="/course-add" var="save"></c:url>
		<form action="${save }" class="form col-6" method="post" >
			<input type="hidden" name="courseid" value="${course.id }"> 
			
			<div class="form-group">
				<label>Course Name</label> <input type="text" 
					name="coursename" value="${course.name }" class="form-control" required="required"
					placeholder="Enter Course Name" />
					
				 <label>Fees</label> 
				 <input type="number" name="fees" value="${course.fees }" class="form-control" required="required" placeholder="Enter  Fees" />
				 
				 <label>Duration</label> 
				 <input type="text" name="duration" value="${course.duration }" class="form-control" required="required" placeholder="Enter Duration" />

				<label>Level</label> 
				 <select name="level" class="form-control">
				 <option value="Basic" ${"Basic"==course.level?'selected':'' }>Basic</option>
				 <option value="Intermediate" ${"Intermediate"==course.level?'selected':'' }>Intermediate</option>
				 <option value="Advance" ${"Advance"==course.level?'selected':'' }>Advance</option>
				 </select>
				 
				 </div>
			<button type="submit" class="btn btn-success">Save</button>
			<button type="reset" class="btn btn-danger">Clear</button>

		</form>

	</div>
	
</body>
</html>