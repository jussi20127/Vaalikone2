<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="data.Candidate" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ehdokastiedot</title>

</head>
<body>
<div class="header">
	<h1>Vaalikone</h1>
	</div>
	<ol>
	
	<c:forEach var="candidate" items="${requestScope.candidateinfo}">
	
	<li>${candidate}
	</c:forEach>
	
	</ol>
	<br>
    <a href="/">Palaa etusivulle</a>
  
</body>
</html>