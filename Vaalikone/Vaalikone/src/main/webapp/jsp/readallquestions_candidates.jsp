<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/show_questions.css">
<title>Vaalikoneen kysymykset</title>
</div>
</head>
<body>
<div class="header">
	<h1>Vaalikone</h1>
</div>
	
	<div class="header">
		<h3>Vastaa alla oleviin väittämiin. Voit myös jättää kysymyksen vastaamatta, vastaamattomia kysymyksiä ei huomioida.</h3>
	</div>
	<div class="questionTable">
	<div class="wrapper">
	<form method="post" action="Save_Answers"><ol>
	<h3>Ehdokasnumerosi:</h3>
	<input type="field" name="ehdokas_id"/>
	<c:forEach var="kysymys" items="${requestScope.questionlist}">
	<h3>${kysymys.aihealue}</h3>
	<h3><li>${kysymys.kysymys}: <input type='field' name='question_id' value='${requestScope.question.id}'></h3>
	    <input type="checkbox" name="vastaus"  value="1"/>Täysin eri mieltä<br>
	    <input type="checkbox" name="vastaus" value="2"/>Eri mieltä<br>
	    <input type="checkbox" name="vastaus"  value="3"/>En osaa sanoa<br>
	    <input type="checkbox" name="vastaus"  value="4"/>Samaa mieltä<br>
	    <input type="checkbox" name="vastaus" value="5"/>Täysin samaa mieltä<br>
	    </li>
	    <br>
	</c:forEach>
	<input type="submit" value="Submit">
	</div>
	</ol></form>
	<div id="buttons">
    <a href="/">Palaa etusivulle</a>
    </div>
    </div>
</body>
</html>