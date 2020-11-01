
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Home</a>
			<ul class="navbar-nav mr-auto">
				<c:url value="/classes" var="classes"></c:url>
				<c:url value="/courses" var="course"></c:url>
				<c:url value="/students" var="student"></c:url>
				<c:url value="/registrations" var="registration"></c:url>
				
				<li class="nav-item"><a class="nav-link" href="${course}">Course</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${classes }">Class
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${student }">Student</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${registration}">Registration</a>
				</li>
			</ul>
		</nav>


