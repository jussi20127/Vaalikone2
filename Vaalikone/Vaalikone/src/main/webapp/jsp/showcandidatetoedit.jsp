<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidate" %>   
 <%@ page import="data.Party" %>
 
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
<title>Vaalikone</title>

<link rel="stylesheet" type="text/css" href="../css/showcanidatetoedit.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h1>Muokkaa ehdokkaan tietoja</h1>

<div>
<form action='editedcandidateupdate' method='post' onsubmit="return confirm('Haluatko varmasti muuttaa tietoja?')">
Ehdokas id:<br> <input type='text' name='ehdokas_id' value='${requestScope.candidatelist.id}' required><br>
Ehdokasnumero:<br> <input type='text' name='numero' value='${requestScope.candidatelist.numero}' required><br>
Sukunimi<br> <input type='text' name='sukunimi' value='${requestScope.candidatelist.sukunimi}' required><br>
Etunimi<br> <input type='text' name='etunimi' value='${requestScope.candidatelist.etunimi}' required><br>

Puolue:
	<select name='puolue_id' required>
		
		<%
		ArrayList<Party> partyList=(ArrayList<Party>)request.getAttribute("partylist");
		String puolue;
		int p1;
		for (int i=0;partyList!=null && i<partyList.size();i++){
			puolue = partyList.get(i).getPuolue();
			p1=partyList.get(i).getId();
			
			%>
			<option value='<%=p1%>'><%=puolue%></option>
			
			<%} %>
		
	</select><br>

Kotipaikkakunta:<br> <input type='text' name='kotipaikkakunta' value='${requestScope.candidatelist.kotipaikkakunta}' required><br>
Ikä:<br> <input type='text' name='ika' value='${requestScope.candidatelist.ika}' required><br>
Ammatti:<br> <input type='text' name='ammatti' value='${requestScope.candidatelist.ammatti}' required><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
<br>

<ol>
<a href='ShowCandidates'>Takaisin</a><br><br>
<a href='index.html'>Etusivu</a><br></ol>

</body>
</html>