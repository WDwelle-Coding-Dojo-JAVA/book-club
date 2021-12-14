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
    <title>project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container mt-5">
   	<h1>Book Club</h1>
   	<h2>Welcome, ${name} </h2>
		<table class="table table-striped">
   			<tr>
   				<th> Title </th>
   				<th> Author </th>
   				<th> Posted By </th>
   			</tr>			
			<c:forEach var="book" items="${books}"> 
				<tr>
					<td>${book.name }</td>
					<td>${book.author} </td>
					<td>${book.user_id.name}</td>
				</tr>
			</c:forEach>
		</table>	
	</div>
</body>
</html>