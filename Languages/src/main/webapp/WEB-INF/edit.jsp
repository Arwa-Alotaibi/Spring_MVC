<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<meta charset="windows-1256">
<title><c:out value="${programming.name}"></c:out></title>
</head>
<body>
<div class="container mt-3">

<a href="/languages" style="text-align-last: right;">Dashboard</a>
<form action ="/delete/languages/${programming.id}" method="POST">
<input type="hidden" name="_method" value="Delete">
<input type ="Submit"  value="Delete" class="btn btn-danger">
</form>

<form:form action="/languages/${programming.id}/edit" method="POST"   modelAttribute ="programming" >
        <input type="hidden" name="_method" value="put">

<p>
<form:label path="name">name</form:label>
<form:errors path="name"/> 
<form:input path="name" value="${programming.name}" class="form-control"/>
</p>

<p>
<form:label path="creator">creator</form:label>
<form:errors path="creator"/>
<form:input path="creator"  value="${programming.creator}" class="form-control"/>
</p>


<p>
<form:label path="version">version</form:label>
<form:errors path="version"/>
<form:input path="version" value="${programming.version}" class="form-control"/>
</p>



 <input type="submit" value="Submit" class="btn btn-success" >


</form:form>

</div>

</body>
</html>