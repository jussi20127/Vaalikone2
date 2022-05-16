<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>
 <%@ page import="data.Subject" %>  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

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

</style>
<meta charset="UTF-8">
<title>Vaalikone Lisää aihealue</title>


<link rel="stylesheet" type="text/css" href="../css/add_subject.css">
<!--<script src="myscriptfile.js"></script> -->

</head>
<body>

<%
// Hakee viimeisen ehdokkaan ID:n lisää 1 ja asettaa nextFree arvoksi, joka annetaan uudelle kysymykselle ID:ksi.
ArrayList<Subject> subjectList=(ArrayList<Subject>)request.getAttribute("subjectlist");
int last = 1;
int nextNumber =1;
int nextFree =0;
if(subjectList.size()>0 && subjectList!=null){
	last = subjectList.size();	
	Subject s = subjectList.get(last-1);
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
	<ol><a href='ShowQuestions'>Takaisin</a><br><br>
	<a href='index.html'>Etusivu</a><br></ol>
	
	


</body>
</html>