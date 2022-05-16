<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}
body {
	margin:0px;
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
form{
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
font-weight: bold;
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
input[type=text], select {
  width: max-content;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: max-content;
  background-color: #C9E1B5;
  color:black;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #86bc5a;
}

</style>
<meta charset="ISO-8859-1">
<title>Vastaa kysymyksiin</title>
</head>
<body>

<div class="header">
	<h1>Vaalikone</h1>
</div>

<form method="post" action="/rest/saveanswers/saveallanswers"><ol>
	
	<label for="id">Ehdokastunnus:</label><br>
	<input type="text" required name="id" value="" ><br>
	
	<br>
 <c:forEach var="questionMap" items="${requestScope.questionslist}">
<p style="color:MediumSeaGreen;">${questionMap.key}</p><br>

 <c:forEach var="kysymys" items="${questionMap.value}" varStatus="status">         
         <b> ${status.count}: ${kysymys.kysymys}</b><br>
          <input type="hidden" required name="question_id" value="${kysymys.id}" >
        <input type="checkbox" name="vastaus"  value="1"/>Täysin eri mieltä<br>
	    <input type="checkbox" name="vastaus" value="2"/>Eri mieltä<br>
	    <input type="checkbox" name="vastaus"  value="3"/>En osaa sanoa<br>
	    <input type="checkbox" name="vastaus"  value="4"/>Samaa mieltä<br>
	    <input type="checkbox" name="vastaus" value="5"/>Täysin samaa mieltä<br>
	    <br>
	     
           </c:forEach> 
           <br>
            </c:forEach>
          </a><input type="submit" value="Submit">
       </ol></form>
       <ol><a href="/candidate.html">Peruuta</a></ol>
      
</body>
</html>