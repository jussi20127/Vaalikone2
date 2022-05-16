<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}
body {
	margin:0;
	font-family: Arial, Helvetica, sans-serif;
}
.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
	border-bottom: 2px solid gray;
}
.header3 {
	border-radius: 5px;
	padding: 20px;
	 background-color: white;
}
.wrapper{
	width: max-content;
	padding-top: 40px;
	margin:auto;
	text-align: left;
}
table{
	border-collapse: collapse;
	text-align:left;
}
.row{
	border-bottom:1px solid gray;
}
.bold{
	font-weight: bold;
}

p
{
font-family:verdana;
}

a:link, a:visited {
  background-color: #C9E1B5;
  color: black;
  padding: 12px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
}

a:hover, a:active {
  background-color: #86bc5a;
}
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>
<meta charset="UTF-8">
<title>Ehdokastiedot</title>
</head>
<body>
<div class="header">
	<h1>Vaalikone</h1>
	</div>
	
<div class="header3">	
	<h3>Ehdokas:</h3>
	</div>
	<div class="info">
	<table id="infotable">
	
	<c:forEach var="candidate" items="${requestScope.candidateinfo}">
	<tr>
	<th><b><p style="color:MediumSeaGreen;">${candidate.numero}</p></b></th>
	 </tr>
	 <tr>
	<th>${candidate.sukunimi}, ${candidate.etunimi} (${candidate.ika})</th>
	 </tr>
	  <tr>
	<th>${candidate.puolue}</th>
	 </tr>
	 <tr>
	<th>${candidate.kotipaikkakunta}</th>
	</tr>
	 <tr>
	<th>${candidate.ammatti}</th>
	</tr>
		
			<c:forEach var="answer" items="${candidate.answers}">
			${answer.questions.kysymys}
			<li>${answer.id}: ${answer.vastaus}
			
		</c:forEach>
	</c:forEach>
	</table>
	</div>
	
	<br>
	<ol>
    <a href="/">Etusivu</a>
    <c:forEach var="candidate" items="${requestScope.candidateinfo}">
    <a href="/rest/questionansweringservice/checkmyanswers/${candidate.id}">Näytä vastaukseni</a>
  	</c:forEach>
  	</ol>
</body>
</html>