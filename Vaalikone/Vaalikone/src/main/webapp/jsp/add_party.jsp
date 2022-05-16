<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidate" %>
 <%@ page import="data.Party" %>  
    
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

</style>
<meta charset="UTF-8">
<title>Vaalikone Lisää puolue</title>


<link rel="stylesheet" type="text/css" href="../css/add_subject.css">
<!--<script src="myscriptfile.js"></script> -->

</head>
<body>

<%
// Hakee viimeisen ehdokkaan ID:n lisää 1 ja asettaa nextFree arvoksi, joka annetaan uudelle kysymykselle ID:ksi.
ArrayList<Party> partyList=(ArrayList<Party>)request.getAttribute("partylist");
int last = 1;
int nextNumber =1;
int nextFree =0;
if(partyList.size()>0 && partyList!=null){
	last = partyList.size();	
	Party p = partyList.get(last-1);
	nextNumber = p.getId()+1;


for (int i=0;partyList!=null && i<partyList.size();i++){
	
	p=partyList.get(i);
	if(i+1 != p.getId()){
	nextFree = i+1;
	break;}
	}
}

%>




<h1>Lisää uusi puolue</h1>
<div>
<form action='newparty' method='post' onsubmit="return confirm('Haluatko varmasti lisätä puolueen?')">
	
	<label for="puolue">Puolue:</label><br>
	<input type="hidden"required name="id" value="<%=nextNumber %> " ><br>
	<textarea required name="puolue" rows="2" cols="30" maxlength="25" placeholder="Kirjoita aihe tähän...(max 25 merkkiä)"></textarea><br>
	
	<input type="submit" name="sendButton" value="Lisää"><br>
</form>
</div>
<br>
	
	<ol>
	<a href='ShowQuestions'>Takaisin</a><br><br>
	<a href='index.html'>Etusivu</a></ol>
	


</body>
</html>