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
   <h1> Edit a Book </h1>
   	<form:form action="/books/${book.id }/edit" method="post" modelAttribute="project" class="form-control">
   	<input type="hidden" name="_method" value="put" />
   	
   	<div>
   		<form:label path="title" class="form-label"> Title </form:label>
   		<form:errors path="title" class="text-danger" />
   		<form:input path="title" type="text" class="form-control" />
   	</div>
   	
   	<div>
   		<form:label path="author" class="form-label"> Author </form:label>
   		<form:errors path="author" class="text-danger" />
   		<form:input path="author" type="text" class="form-control" />
   	</div> 
   	
   	<div>
   		<form:label path="description" class="form-label"> Description </form:label>
   		<form:errors path="description" class="text-danger" />
   		<form:textarea path="description" class="form-control"></form:textarea>
   	</div>   
   		
        <form:hidden path="creator" value="${book.author.id }" />  	
        <button class="btn btn-primary">Edit Book</button>
   	</form:form>


   
   </div>
</body>
</html>