<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>
 <%@ page import="data.Subject" %>  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone Lisää kysymys</title>


<link rel="stylesheet" type="text/css" href="../css/add_question.css">
<!--<script src="myscriptfile.js"></script> -->

</head>
<body>






<h1>Lisää uusi kysymys</h1>
<div>
<form action='addupdate' method='post' onsubmit="return confirm('Haluatko varmasti lisätä kysymyksen?')">
	
	
	
	<label for="aihe">Aihealue:</label><br>
	<select name='aihe' required>
		
		<%
		ArrayList<Subject> subjectList=(ArrayList<Subject>)request.getAttribute("subjectlist");
		String aihealue;
		
		for (int i=0;subjectList!=null && i<subjectList.size();i++){
			aihealue = subjectList.get(i).getAihealue();
			%><option value='<%=aihealue%>'><%=aihealue%></option>
			<%} %>
		
	</select><br>
	
	<label for="kysymys">Kysymys:</label><br> 
	<textarea required name="kysymys" rows="3" cols="50" maxlength="150" placeholder="Kirjoita kysymys tähän...(max 150 merkkiä)"></textarea><br>
	
	<input type="submit" name="sendButton" value="Lisää"><br>
</form>
</div>
<br>
	
	<a href='index.html'>Takaisin etusivulle</a><br>
	<a href='ShowQuestions'>Takaisin kysymysten selaukseen</a><br>
	<a href='AddSubject'>Lisää aihealue</a><br>
	


</body>
</html>