<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Reading Books</title>
</head>
<body>

<h1>${book.title}</h1>

<p> Description : ${book.description }</p>
<p> Language : ${book.language} </p>
<p> Number of pages : ${book.numberOfPages } </p>

</body>
</html>