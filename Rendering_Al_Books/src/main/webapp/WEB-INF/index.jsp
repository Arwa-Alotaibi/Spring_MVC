<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<meta charset="windows-1256">
<title>Reading Books</title>
</head>
<body>
<div class="container">

<h1>All Books</h1>
<table  class="table table-striped" >
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
            <c:forEach var="book" items="${books}">
       
            <tr>
            
            <td>  <c:out value="${book.id }"/>	</td>
            
            <td> <a href ="/books/${book.id}"> <c:out value="${book.title }"/>  </a>	</td>
            
            <td> 	<c:out value="${book.language }"/>	</td>
            
            <td> <c:out value="${book.numberOfPages }"/> </td>
       
            
            </tr>
            
         
            
                    </c:forEach>
            
        
    </tbody>
</table>


</div>

</body>
</html>