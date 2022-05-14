<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read list of Candidates</title>
</head>
<body>
<form action="ReadAllQuestionsForCandidates" method='post'>
<ol>
<c:forEach var="candidate" items="${requestScope.candidatelist }">
<li>${candidate.sukunimi}, ${candidate.etunimi}
	<ul>
		<c:forEach var="candidate" items="${candidate.answers}">
			<li>${answer.vastaus}</li>	
		</c:forEach>
	</ul>	
</c:forEach>
</ol>
</form>
</body>
</html>