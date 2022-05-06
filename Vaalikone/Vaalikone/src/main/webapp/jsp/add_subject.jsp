<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Questions" %>
 <%@ page import="data.Subjects" %>  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone Lisää aihealue</title>


<link rel="stylesheet" type="text/css" href="../css/add_subject.css">
<!--<script src="myscriptfile.js"></script> -->

</head>
<body>

<%
// Hakee viimeisen ehdokkaan ID:n lisää 1 ja asettaa nextFree arvoksi, joka annetaan uudelle kysymykselle ID:ksi.
ArrayList<Subjects> subjectList=(ArrayList<Subjects>)request.getAttribute("subjectlist");
int last = 1;
int nextNumber =1;
int nextFree =0;
if(subjectList.size()>0){
	last = subjectList.size();	
	Subjects s = subjectList.get(last-1);
	nextNumber = s.getId()+1;


for (int i=0;subjectList!=null && i<subjectList.size();i++){
	
	s=subjectList.get(i);
	if(i+1 != s.getId()){
	nextFree = i+1;
	break;}
	}
}

%>




<h1>Lisää uusi aihealue</h1>
<div>
<form action='newsubject' method='post' onsubmit="return confirm('Haluatko varmasti lisätä aihealueen?')">
	
	<label for="aihealue">Aihe:</label><br>
	<input type="hidden"required name="id" value="<%=nextNumber %> " ><br>
	<textarea required name="aihealue" rows="2" cols="30" maxlength="25" placeholder="Kirjoita aihe tähän...(max 25 merkkiä)"></textarea><br>
	
	<input type="submit" name="sendButton" value="Lisää"><br>
</form>
</div>
<br>
	
	<a href='index.html'>Takaisin etusivulle</a><br>
	<a href='ShowQuestions'>Takaisin kysymysten selaukseen</a><br>
	


</body>
</html>