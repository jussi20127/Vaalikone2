<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone Ehdokkaat</title>

<link rel="stylesheet" type="text/css" href="../css/show_candidates.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<div class="header">
<h1>Vaalikone - Ehdokkaat</h1>
</div>

<div class="candidateTable">

<div class="wrapper">
<table id="candidateTable">
	<tr>
		<th>Ehdokkaan numero</th>
		<th>Etunimi</th>
		<th>Sukunimi</th>
		<th>Ikä</th>
		<th>Kotipaikkakunta</th>
		<th>Puolue</th>
		<th>Ammatti</th>
		
	</tr>
	
	<%
	
	ArrayList<Candidates> candidateList=(ArrayList<Candidates>)request.getAttribute("candidatelist");
	for (int i=0;candidateList!=null && i<candidateList.size();i++){
	Candidates c=candidateList.get(i);
	String Poistetaanko = "Poistetaanko varmasti "+c.getEtunimi()+ " "+c.getSukunimi()+"?";
	%>
		<tr class="row">
			<td class="bold"><%out.println(c.getNumero());%></td>
			<td><%out.println(c.getEtunimi());%></td>
			<td><%out.println(c.getSukunimi());%></td>
			<td><%out.println(c.getIka());%></td>
			<td><%out.println(c.getKotipaikkakunta());%></td>
			<td><%out.println(c.getPuolue());%></td>
			<td><%out.println(c.getAmmatti());%></td>
			<td><a href="/readCandidateToUpdate?ehdokas_id=<%out.println(c.getId());%>">update</a></td>
			<td><a href="/deletecandidate?ehdokas_id=<%out.println(c.getId());%>" onclick='return confirm(<%out.println('"'+Poistetaanko+'"');%>)'>delete</a></td>
		</tr>
	<%};
	%>
</table>



<br>
<a href="/">Palaa etusivulle</a>
<a href="/AddCandidate">Lisää ehdokas</a>
</div>
</div>
</body>
</html>