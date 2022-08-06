<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- for rendering errors on PUT routes -->



<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<meta charset="windows-1256">
<title>Edit My Task </title>
</head>
<body>
<h1> Expense Details</h1>

<a href="/expenses">Go Back</a>


<form:form action="/expenses/edit/${editpokebook.id}" method="POST"   modelAttribute ="pokebook" >
        <input type="hidden" name="_method" value="put">

<p>
<form:label path="name">Expense</form:label>
<form:errors path="name"/> 
<form:input path="name" value="${editpokebook.name}"/>
</p>

<p>
<form:label path="vender">Vender</form:label>
<form:errors path="vender"/>
<form:input path="vender"  value="${editpokebook.vender}"/>
</p>


<p>
<form:label path="amount">amount</form:label>
<form:errors path="amount"/>
<form:input path="amount" value="${editpokebook.amount}"/>
</p>


<p>
<form:label path="description">description</form:label>
<form:errors path="description"/>
<form:input path="description"  value="${editpokebook.description}"/>
</p>


 <input type="submit" value="Submit" >


</form:form>

</body>
</html>