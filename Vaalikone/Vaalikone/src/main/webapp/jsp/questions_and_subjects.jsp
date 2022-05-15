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
	margin:0;
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
	border-bottom: 2px solid gray;
}

.header3 {
	padding: 20px;
	text-align: center;
}
#questionTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#questionTable td, #questionTable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#questionTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #C9E1B5;
  color: black;
}

.wrapper{
	width: max-content;
	padding-top: 40px;
	margin:auto;
	text-align: left;
}
table{
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
}

a:link, a:visited {
  background-color: #C9E1B5;
  color: black;
  padding: 14px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: #86bc5a;
}

</style>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/show_questions.css">
<title>Vaalikoneen kysymykset</title>
<link rel="stylesheet" type="text/css" href="../css/show_questions.css">
<script src="myscriptfile.js"></script>
</head>
<body>
<div class="header">
	<h1>Vaalikone</h1>
</div>
		<h3 class="header3">Kysymykset</h3>
	
<div class="questionTable">

<div class="wrapper">
	<table id="questionTable">
  <tr><th>Aihe</th><th>Kysymys</th></tr>
  <!-- iterate over each key in the map -->
  <c:forEach var="questionMap" items="${requestScope.questionslist}">
    <tr class="row">
      <td class="bold">${questionMap.key}</td>
      <td>
        <!-- iterate over each item in the list of questions -->
        <c:forEach var="kysymys" items="${questionMap.value}" varStatus="status">         
          ${status.count}: ${kysymys.kysymys}  <a href="/EditUpdate?kysymys_id=${kysymys.id}">update</a>
      <a href="/deleteQuestion?kysymys_id=${kysymys.id}">delete</a><br><br> 
         </c:forEach> 
      </td> 
     
      
    </tr> 
      
  </c:forEach>
</table>
	<br>

	<div id="buttons">
    <a href="/">Palaa etusivulle</a>
    <a href="/AddQuestion">Lisää Kysymys</a>
    </div>
  </div>
  </div>
</body>
</html>