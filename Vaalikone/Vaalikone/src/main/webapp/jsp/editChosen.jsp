<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
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
		<option value='Verotus'>Verotus</option>
		<option value='Maanpuolustus'>Maanpuolustus</option>
		<option value='Kulttuuri ja vapaa-aika'>Kulttuuri ja vapaa-aika</option>
		<option value='Ilmasto ja ympäristö'>Ilmasto ja ympäristö</option>
		<option value='Koulutus'>Koulutus</option>
	</select><br>
<input type='submit' name='ok' value='Send'> 
</form>

</div>
<br><a href='ShowQuestions'>Takaisin kysymysten selaukseen</a><br>
<br><a href='index.html'>Takaisin etusivulle</a><br>
</body>
</html>