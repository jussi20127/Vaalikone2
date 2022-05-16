<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="data.Subject" %>
<%@ page import="java.util.ArrayList" %>
  
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
<title>Kysymyksen muokkaus</title>

<link rel="stylesheet" type="text/css" href="../css/add_question.css">

</head>
<body>
<h2>Muokkaa valittua kysymystä</h2>
 
 <div>
 
<%-- 'update/editing': kun klikataan submit-nappulaa, otetaan yhteys Update.javaan, jonka urlPattern on update/editing --%>
<form action='update/editing' method='post' onsubmit="return confirm('Haluatko varmasti muuttaa tietoja?')">
<%-- kenttiin tulee arvot question-nimiseltä oliolta, joka saatiin edellä EditUpdatelta --%>


Id-numero: <input type='text' name='id' value='${requestScope.question.id}' readonly><br>
Kysymys: <input type='text' name='kysymys' value='${requestScope.question.kysymys}' size="60" required><br>
<%--Aihe: <input type='text' name='aihealue' value='${requestScope.question.aihe}'><br>--%>
Aihealue:
	<select name='aihealue' required>
		<%
		ArrayList<Subject> subjectList=(ArrayList<Subject>)request.getAttribute("subjectlist");
		String aihealue;
		
		for (int i=0;subjectList!=null && i<subjectList.size();i++){
			aihealue = subjectList.get(i).getAihealue();
			%><option value='<%=aihealue%>'><%=aihealue%></option>
			<%} %>
	</select><br>
<input type='submit' name='ok' value='Lähetä'> 
</form>

</div>
<ol><br><a href='ShowQuestions'>Takaisin</a><br>
<br><a href='index.html'>Etusivu</a><br></ol>
</body>
</html>