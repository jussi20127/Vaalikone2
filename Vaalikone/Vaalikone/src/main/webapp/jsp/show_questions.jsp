<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vaalikone Kysymykset</title>

<link rel="stylesheet" type="text/css" href="../css/show_questions.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<div class="header">
<h1>Vaalikone - Kysymykset</h1>
</div>

<div class="questionTable">

<div class="wrapper">
<table id="questionTable">
	<tr>
		<th>Kysymysnumero</th>
		<th>Aihe</th>
		<th>Kysymys</th>
	</tr>
	
	<%
	
	ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
	for (int i=0;questionList!=null && i<questionList.size();i++){
	Question q=questionList.get(i);
	String Poistetaanko = "Poistetaanko varmasti "+q.getAihealue()+ " "+q.getKysymys()+"?";
	%>
		<tr class="row">
			<td class="bold"><%out.println(q.getId());%></td>
			<td><%out.println(q.getAihealue());%></td>
			<td><%out.println(q.getKysymys());%></td>
			<td><a href="/EditUpdate?kysymys_id=<%out.println(q.getId());%>">update</a></td>
			<td><a href="/deleteQuestion?kysymys_id=<%out.println(q.getId());%>" onclick='return confirm(<%out.println('"'+Poistetaanko+'"');%>)'>delete</a></td>
		</tr>
	<%};
	%>
</table>


<br>
<a href="/admin.html">Takaisin</a>
<a href="/AddQuestion">Lisää Kysymys</a>
</body>
</html>