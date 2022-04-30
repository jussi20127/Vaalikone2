<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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

Puolue:<br>
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

Kotipaikkakunta:<br> <input type='text' name='kotipaikkakunta' value='${requestScope.candidatelist.kotipaikkakunta}' required><br>
Ikä:<br> <input type='text' name='ika' value='${requestScope.candidatelist.ika}' required><br>
Ammatti:<br> <input type='text' name='ammatti' value='${requestScope.candidatelist.ammatti}' required><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
<br>

<a href='index.html'>Takaisin etusivulle</a><br>
<a href='ShowCandidates'>Takaisin ehdokkaiden selaukseen</a><br>

</body>
</html>