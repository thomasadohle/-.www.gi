<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter a New Bg</title>
</head>


<body>
<h1>Add new BloodGlucose</h1>
	<form action="AddBg" method="post">
		<p>
			<label for="patientId">PatientID</label>
			<input id="patientId" name="patientId" value="${fn:escapeXml(param.patientId)}">
		</p>
		<p>
			<label for="bg">BloodGlucose</label>
			<input id="bg" name="bg" value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	
	<!-- Display new BG  -->
	<h3>BG just added</h3>
	<table border=1>
		<tr>
			<th>PatientID</th>
			<th>Bg Time</th>
			<th>Bg Date</th>
			<th>Bg Value</th>
			<th>Edit Bg Value</th>
		
		</tr>
		<tr>
			<td><c:out value="${newBg.getPt().getPtID()}"/></td>
            <td><c:out value='${newBg.getBgTime()}'/></td>
            <td><c:out value='${newBg.getBgDate()}'/></td>
            <td><c:out value='${newBg.getBloodGlucose()}'/></td>
            <td><a href="EditBg?bgID=<c:out value="${bloodGlucose.getBgID()}"/>">Edit Bg</a></td>
        </tr>	
	
	
	
	
	
	
	</table>
	
	<p>Click <a href="Home.html">here</a> to return to homepage.</p>
	
	
</body>
</html>