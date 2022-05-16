<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidate" %>   
 <%@ page import="data.Party" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
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
<title>Vaalikone Lisää ehdokas</title>

<link rel="stylesheet" type="text/css" href="../css/add_candidate.css">
<script src="myscriptfile.js"></script>

<!--  
TYYLIT JA SCRIPTIT TOISTAISEKSI KOMMENTOITU POIS
<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script> -->

</head>
<body>





<h1>Lisää uusi ehdokas</h1>

<div>
<form action='newcandidate' method='post' onsubmit="return confirm('Haluatko varmasti lisätä ehdokkaan?')">

	
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
	
	
	<label for="numero">Ehdokasnumero:</label><br>
	<textarea required name="numero"></textarea><br>
	
	<label for="sukunimi">Sukunimi:</label><br> 
	<textarea required name="sukunimi"></textarea><br>
	
	<label for="etunimi">Etunimi:</label><br> 
	<textarea required name="etunimi"></textarea><br>
	
	<label for="ika">Ikä:</label><br> 
	<textarea required name="ika"></textarea><br>
	
	<label for="ammatti">Ammatti:</label><br> 
	<textarea required name="ammatti"></textarea><br>
	
	<label for="kotipaikkakunta">Kotipaikkakunta:</label><br> 
	<textarea required name="kotipaikkakunta"></textarea><br>
	
	<input type="submit" name="sendButton" value="Lisää"><br>
	
	
	
</form>
</div>
<br>
	
	<ol>
	<a href='ShowCandidates'>Takaisin</a><br><br>
	<a href='index.html'>Etusivu</a><br><br>
	<a href='AddParty'>Lisää puolue</a><br></ol>
	


</body>
</html>