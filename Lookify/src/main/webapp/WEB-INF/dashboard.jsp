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
<title>Lookify !</title>
</head>
<body>
<div class="container mt-3">

<div>
<a href="/songs/new">Add new</a>

<a href="/Search/TopTen">Top Songs</a>

</div>

<form  action="/search" method="Get">
<input type="text" name="artist" >

<input type="submit" value="Search artisit"  class="btn btn-success"/>

</form>


<table class="table table-striped">

<tr>
<th> Name</th>
<th> Rating</th>
<th> Actions</th>

</tr>

	<c:forEach var="song" items="${playlist}">
	<td><a href="/songs/${song.id}"><c:out value="${song.title}"> </c:out></a></td>

	<td><c:out value="${song.rating}"> </c:out></td>

	<td><form action ="/delete/${song.id}" method="POST">
	<input type="hidden" name="_method" value="Delete">
	<input type ="Submit"  value="Delete" class="btn btn-danger"></td>

	</tr>
	</c:forEach>

</table>

</div>


</body>
</html>