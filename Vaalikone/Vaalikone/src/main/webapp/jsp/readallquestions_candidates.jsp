<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikoneen kysymykset</title>
</div>
</head>
<body>
<div class="header">
	<h1>Vaalikone</h1>
	<h3>Vastaa alla oleviin väittämiin. Voit myös jättää kysymyksen vastaamatta, vastaamattomia kysymyksiä ei huomioida.</h3>
	<form><ol>
	<c:forEach var="kysymys" items="${requestScope.questionlist}">
	<li>${kysymys.kysymys}<br>
	    <input type="checkbox" id="yksi" name="${vastaus}"  value="${yksi}"/>Täysin eri mieltä<br>
	    <input type="checkbox" id="kaksi" name="${vastaus}" value="${kaksi}"/>Eri mieltä<br>
	    <input type="checkbox" id="kolme" name="${vastaus}"  value="${kolme}"/>En osaa sanoa<br>
	    <input type="checkbox" id="neljä" name="${vastaus}"  value="${neljä}"/>Samaa mieltä<br>
	    <input type="checkbox" id="viisi" name="${vastaus}" value="${viisi}"/>Täysin samaa mieltä<br>
	    </li>
	</c:forEach>
	<input type="submit" value="Submit">
	</ol></form>
	<div id="buttons">
    <a href="/">Palaa etusivulle</a>
    </div>
</body>
</html>