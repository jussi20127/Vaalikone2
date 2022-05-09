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

<%
// Hakee viimeisen kysymyksen ID:n lisää 1 ja asettaa nextFree arvoksi, joka annetaan uudelle kysymykselle ID:ksi.
ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
int last = 1;
int nextNumber =1;
int nextFree =0;
if(questionList.size()>0 && questionList!=null){
	last = questionList.size();	
	Question q = questionList.get(last-1);
	nextNumber = q.getId()+1;


for (int i=0;questionList!=null && i<questionList.size();i++){
	
	q=questionList.get(i);
	if(i+1 != q.getId()){
		nextFree = i+1;
	break;}
	}
}

%>




<h1>Lisää uusi kysymys</h1>
<div>
<form action='addupdate' method='post' onsubmit="return confirm('Haluatko varmasti lisätä kysymyksen?')">
	
	<!--  <label for="kysymys_numero">Kysymysnumero:</label><br>
	<%if (nextFree !=0){%>
	<input type="radio" name="kysymys_numero" value="<%=nextFree %>" required><%=nextFree %> (välistä puuttuva numero)<br>
	<%};%>
	<input type="radio" name="kysymys_numero" value="<%=nextNumber %>" required><%=nextNumber %> (seuraava vapaa numero)<br>-->
	
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