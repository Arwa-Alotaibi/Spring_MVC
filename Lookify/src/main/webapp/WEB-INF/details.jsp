<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
       
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<meta charset="windows-1256">
<title>Details</title>
</head>
<body>
<div class="container mt-3">

<a href="/dashboard" >dashboard</a>

<p>Title: <c:out value="${playlist.title}"> </c:out> </p>


<p>Artist: <c:out value="${playlist.artist}"> </c:out> </p>

<p>Rating(1-10): <c:out value="${playlist.rating}"> </c:out> </p>




<form action ="/delete/${playlist.id}" method="POST">
	<input type="hidden" name="_method" value="Delete">
	<input type ="Submit"  value="Delete" class="btn btn-danger"></td>

</form>
</body>
</html>