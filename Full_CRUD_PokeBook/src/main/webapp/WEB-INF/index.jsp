<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<meta charset="windows-1256">
<title>Read a share</title>
</head>
<body>

<h1> Poke Book</h1>
<table   class="table table-striped">
<tr>
<th> Expense</th>
<th> vendor</th>
<th> Amount</th>
<th>Actions </th>

</tr>
<c:forEach  var="item"  items="${poke}">

<tr>

<td><a href="/expenses/${item.id}"><c:out value="${item.name }"></c:out></a></td>



<td><c:out value="${item.vender }" ></c:out></td>
<td><c:out value="${item.amount }" ></c:out></td>
<td><a href="expenses/edit/${item.id}">edit</a>
<form action ="expenses/delete/${item.id}" method="POST">
<input type="hidden" name="_method" value="Delete">
<input type ="Submit"  value="Delete" class="btn btn-danger">
</form>



 </td>


</tr>

</c:forEach>

</table>



<h1> Track an expence</h1>

<form:form action="/expenses"  method="POST"   modelAttribute ="pokebook" >

<p>
<form:label path="name">Expense</form:label>
<form:errors path="name"/> 
<form:input path="name"/>
</p>

<p>
<form:label path="vender">Vender</form:label>
<form:errors path="vender"/>
<form:input path="vender"/>
</p>


<p>
<form:label path="amount">amount</form:label>
<form:errors path="amount"/>
<form:input path="amount"/>
</p>


<p>
<form:label path="description">description</form:label>
<form:errors path="description"/>
<form:input path="description"/>
</p>


 <input type="submit" value="Submit" class="btn btn-info">


</form:form>

</body>
</html>