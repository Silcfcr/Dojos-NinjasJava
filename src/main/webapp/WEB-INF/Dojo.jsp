<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Dojos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div>
			<div>
				<form:form action="/createDojo" method="POST" modelAttribute="dojo">
					<div>
						<c:out value="${errorMessage}"></c:out>
					</div>
				    <div class="form-group">
				        <form:label path="name">Name:</form:label>
				        <form:input type="text" path="name"/>
				    </div>
				    <div>
				    	<button type="submit">Create Dojo</button>
				    </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
