<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<meta charset="windows-1256">
<title><c:out value="${languages.name}"></c:out></title>
</head>
<body>
<a href="/languages" style="text-align-last: right;">Dashboard</a>

<div class="container mt-3">


<p> Name: <c:out value="${languages.name}"></c:out></p>
<p> creator: <c:out value="${languages.creator}"></c:out></p>
<p> version: <c:out value="${languages.version}"></c:out></p>


<a href="/languages/${languages.id}/edit">edit </a> 


<form action ="/delete/languages/${languages.id}" method="POST">
<input type="hidden" name="_method" value="Delete">
<input type ="Submit"  value="Delete" class="btn btn-danger">
</form>
</div>
</body>
</html>