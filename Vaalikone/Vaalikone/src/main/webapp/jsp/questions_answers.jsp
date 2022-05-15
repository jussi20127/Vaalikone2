<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
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
<b>${questionMap.key}</b><br>

 <c:forEach var="kysymys" items="${questionMap.value}" varStatus="status">         
          ${status.count}: ${kysymys.kysymys}<br>
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
          <input type="submit" value="Submit">
       </ol></form>
</body>
</html>