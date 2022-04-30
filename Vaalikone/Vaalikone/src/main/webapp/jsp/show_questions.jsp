<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Questions" %>   
    
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
	
	ArrayList<Questions> questionList=(ArrayList<Questions>)request.getAttribute("questionlist");
	for (int i=0;questionList!=null && i<questionList.size();i++){
	Questions q=questionList.get(i);
	String Poistetaanko = "Poistetaanko varmasti "+q.getAihe()+ " "+q.getKysymys()+"?";
	%>
		<tr class="row">
			<td class="bold"><%out.println(q.getKysymys_Id());%></td>
			<td><%out.println(q.getAihe());%></td>
			<td><%out.println(q.getKysymys());%></td>
			<td><a href="/EditUpdate?kysymys_id=<%out.println(q.getKysymys_Id());%>">update</a></td>
			<td><a href="/deleteQuestion?kysymys_id=<%out.println(q.getKysymys_Id());%>" onclick='return confirm(<%out.println('"'+Poistetaanko+'"');%>)'>delete</a></td>
		</tr>
	<%};
	%>
</table>


<br>
<a href="/">Palaa etusivulle</a>
<a href="/AddQuestion">Lisää Kysymys</a>
</body>
</html>