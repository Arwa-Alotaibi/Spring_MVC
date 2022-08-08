<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
          
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="windows-1256">
<title>Search</title>
<style>
.container{
border-style: solid;
}

</style>
</head>
<body>
<h1> Top Ten Songs</h1>
<a href="/dashboard" >dashboard</a>
<div class="container">

<c:forEach var="song" items="${playlist}">


	<p><c:out value="${song.rating}">- </c:out>
	-<a href="/songs/${song.id}"><c:out value="${song.title}"> </c:out></a>-
	<c:out value="${song.artist}"> </c:out>
	
	</p>

	</c:forEach>

</div>
</body>
</html>