<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidate" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
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

<%
// Hakee viimeisen ehdokkaan ID:n lisää 1 ja asettaa nextFree arvoksi, joka annetaan uudelle kysymykselle ID:ksi.
ArrayList<Candidate> candidateList=(ArrayList<Candidate>)request.getAttribute("candidatelist");
int last = 1;
int nextNumber =1;
int nextFree =0;
if(candidateList.size()>0){
	last = candidateList.size();	
	Candidate c = candidateList.get(last-1);
	nextNumber = c.getId()+1;


for (int i=0;candidateList!=null && i<candidateList.size();i++){
	
	c=candidateList.get(i);
	if(i+1 != c.getId()){
		nextFree = i+1;
	break;}
	}
}

%>




<h1>Lisää uusi ehdokas</h1>

<div>
<form action='newcandidate' method='post' onsubmit="return confirm('Haluatko varmasti lisätä ehdokkaan?')">

	<!-- <label for="ehdokas_id">Ehdokkaan ID:</label><br>
	<%if (nextFree !=0){%>
	<input type="radio" name="ehdokas_id" value="<%=nextFree %>" required><%=nextFree %> (välistä puuttuva numero)<br>
	<%};%>
	<input type="radio" name="ehdokas_id" value="<%=nextNumber %>" required><%=nextNumber %> (seuraava vapaa numero)<br><label for="ehdokas_id"></label><br>
	 -->
	Puolue:
	<select name='puolue' required>
		<option value="SDP">SDP</option>
		<option value="KoK">KoK</option>
		<option value="Kesk.">Kesk.</option>
		<option value="Vihr.">Vihr.</option>
		<option value="Vas.">Vas.</option>
		<option value="PS">PS</option>
		<option value="RKP">RKP</option>
		<option value="KD">KD</option>
		<option value="Liik.">Liik.</option>
		<option value="VKK">VKK</option>
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
	
	<a href='index.html'>Takaisin etusivulle</a><br>
	<a href='ShowCandidates'>Takaisin ehdokkaiden selaukseen</a><br>
	


</body>
</html>