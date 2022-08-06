<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

<meta charset="windows-1256">

<title>Read Share</title>


</head>
<body>
<div class="container mt-3">

<h1 class="text-primary">Poke Book</h1>

<table class="table table-bordered table-sm">
		<tr>
		<th>Expense </th>
		<th>Vender </th>
		<th>$amount </th>
		<th> edit </th>
	</tr>
	<tr>
	<c:forEach  var="book"   items="${Poke }">  
	
	<td> <c:out value="${book.name}"> </c:out> </td>
		<td> <c:out value="${book.vender}"> </c:out> </td>
	
			<td> <c:out value="${book.amount}"> </c:out> </td>
			
			<td> <a href = "/expenses/edit/${book.id }">  edit</a> </td>
	</tr>
	
	</c:forEach>
	

</table>
 
 
 <h1 class="text-primary">Track an expense</h1>
 <form:form action= "/expenses" method="post"  modelAttribute ="pokebook">
 
 <div style="color:red">
  <form:errors path="description" /> 
  <form:errors path="amount" /> 
 
 </div>
 <p>
 		
 <form:label path="name">Expense Name:</form:label>
<form:errors path="name" /> 
 <form:input path="name" /> 
 </p>
 
 <p>
 <form:label path="vender" > Vender: </form:label>
   <form:errors path="vender" /> 
 
  <form:input path="vender" /> 
 </p>
 
 <p>
 <form:label path ="description"> Description </form:label>
 <form:input path="description"/>
 </p>
 <p>
 <form:label path="amount"> Amount </form:label>
 <form:input  path = "amount" />
 </p>
<input type="submit" value="Submit"  class="btn btn-primary"/>

 </form:form>
</div>
</body>
</html>