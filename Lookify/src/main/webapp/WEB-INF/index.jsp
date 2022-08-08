<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
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
<meta charset="windows-1256">
<title>Lookify !</title>
<style>
h1{
text-align:center;
}


div{
  padding: 100px;

}
</style>
</head>
<body>
 <h1>Welcome to Lookify</h1>
 
 <div style="text-align: center">
 
 <a href= "/dashboard">Start Looking ! </a>
 </div>
</body>
</html>