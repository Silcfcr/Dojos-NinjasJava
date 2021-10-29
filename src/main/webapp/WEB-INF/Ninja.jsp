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
    <title>Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div>
			<div>
				<form action="createNinja" method="POST">
					<h1>New Ninja</h1>
					<div>
						<c:out value="${errorMessage}"></c:out>
					</div>
					<div class="form-group">
						<label for="dojo_id">Dojo:</label>
						<select name="dojo_id" id="dojo_id">
							<c:forEach items="${DojoList}" var="dojo">
								<option value="${dojo.id}"><c:out value="${dojo.name}"></c:out></option>
							</c:forEach>
						</select>
				    </div>
				    <div class="form-group">
				        <label for="first_name">First name:</label>
				        <input type="text" name="first_name" id="first_name"/>
				    </div>
				    <div class="form-group">
				        <label for="last_name">Last name:</label>
				        <input type="text" name="last_name" id="last_name"/>
				    </div>
				    <div class="form-group">
				        <label for="age">Age:</label>
				        <input type="number" name="age" id="age"/>
				    </div>
				    <div>
				    	<button type="submit">Create ninja</button>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
