<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Show Expense</title>



</head>
<body>
<h1> Expense Details :)</h1>
<a href="/expenses">Go Back</a>

<p> Expense Name : <c:out value="${pokebook.name }"></c:out> </p>

<p> Expense Description  : <c:out value="${pokebook.description }"></c:out> </p>

<p>Vender  : <c:out value="${pokebook.vender }"></c:out> </p>

<p>Amount Spent  : <c:out value="${pokebook.amount }"></c:out> </p>

</body>
</html>