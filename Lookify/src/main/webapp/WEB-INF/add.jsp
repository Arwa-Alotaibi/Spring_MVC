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
<title>Add Song</title>
</head>
<body>
<div class="container mt-3">

<a href="/dashboard" >dashboard</a>
<form:form action="/songs/new" method="POST"  modelAttribute="playlist">


<p>
<form:label path="title">Title</form:label>
<form:errors path="title"/> 
<form:input path="title" class="form-control"/>
</p>


<p>
<form:label path="artist">Artist</form:label>
<form:errors path="artist"/> 
<form:input path="artist" class="form-control"/>
</p>



<p>
<form:label path="rating">Rating(1-10)</form:label>
<form:errors path="rating"/> 
<form:input  type="number" path="rating"  class="form-control"/>
</p>

<input type="submit" value="Add Song" class="btn btn-success">
</form:form>
</div>

</body>
</html>