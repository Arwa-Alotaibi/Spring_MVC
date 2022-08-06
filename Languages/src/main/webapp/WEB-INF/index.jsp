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
<title>Languages</title>
</head>
<body>
<div class="container mt-3">

<table class="table table-striped">
<tr>
<th>Name </th>

<th>Creator </th>

<th>Version </th>

<th>Action </th>
</tr>

<c:forEach  var="item"  items="${languages}">

<tr>
<td> <a href="/languages/${item.id}"><c:out value="${item.name}"></c:out> </a></td>
<td> <c:out value="${item.creator}" ></c:out> </td>
<td> <c:out value="${item.version}" ></c:out> </td>

<td> <a href="/languages/${item.id}/edit">edit </a> 

<form action ="/delete/languages/${item.id}" method="POST">
<input type="hidden" name="_method" value="delete">
<input type ="Submit"  value="Delete" class="btn btn-danger">
</form>


</td>


</tr>
</c:forEach>
</table>

<form:form action="/languages" method = "POST"  modelAttribute="programming">

<p>
<form:label path="name">Name:</form:label>
<form:input path="name" class="form-control" />
<form:errors path="name"/>
</p>


<p>
<form:label path="creator">creator:</form:label>
<form:input path="creator" class="form-control" />
<form:errors path="creator"/>
</p>


<p>
<form:label path="version">version:</form:label>
<form:input path="version" class="form-control"/>
<form:errors path="version"/>
</p>
 <input type="submit" value="Submit" class="btn btn-primary">


</form:form>
</div>
</body>
</html>