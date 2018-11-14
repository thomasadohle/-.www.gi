<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find a Patient</title>
</head>
<body>

<form action="findpatient" method="post"> <!-- action=specifies which servlet (controller) to send data to -->
		<h1>Search for a Patient by PatientID</h1>
		<p>
			<label for="patientID">PatientID</label>
			<input id="patientID" name="patientID" value="${fn:escapeXml(param.patientID)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<br/>
	
	<h1>Patient Information</h1>
	<h5>Click <a href="GetRegiment?patientId=<c:out value="${patient.getPtID()}"/>">here</a> to view treatment regiment</h5>
        <table border="1">
            <tr>
                <th>PatientID</th>
                <th>Master User</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>DOB</th>
                <th>Past Bg Values</th>
                <th>Add a Blood glucose</th>
            </tr>
            <tr> 
                <td><c:out value='${patient.getPtID()}'/></td>
                <td><c:out value='${patient.getMasterUser().getUserName()}'/></td>
                <td><c:out value='${patient.getPtContactInfo().getFirstName()}'/></td>
                <td><c:out value='${patient.getPtContactInfo().getLastName()}'/></td>
                <td><c:out value='${patient.getPtContactInfo().getEmail()}'/></td>
                <td><c:out value='${patient.getPtContactInfo().getGender()}'/></td>
                <td><c:out value='${patient.getPtContactInfo().getDOB()}'/></td>
                <td><a href="ViewBgs?patientId=<c:out value="${patient.getPtID()}"/>">View Past Bgs</a></td>
                <td><a href="AddBg?patientId=<c:out value="${patient.getPtID()}"/>">Add New Bg</a></td>
           </tr> 
              
       </table>
       
       
       	<p>Click <a href="Home.html">here</a> to return to homepage.</p>
       
   
   
       
</body>
</html>