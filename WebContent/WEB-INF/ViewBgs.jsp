<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bg History</title>
</head>
<body>

<form action="getBgs" method="post"> <!-- action=specifies which servlet (controller) to send data to -->
		<h1>Last Ten Blood Glucose Entries</h1>
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
	
	<h1>Blood Glucose Values</h1>
	<h3>Click the value to edit it</h3>
        <table border="1">
            <tr>
                <th>Patient ID</th>
                <th>BgID</th>
                <th>Bg Date</th>
                <th>BgTime</th>
                <th>BgValue</th>
                <th>Delete Bg</th>
            </tr>
            <c:forEach items="${bloodGlucoses}" var="bloodGlucose" >
                <tr>
                    <td><c:out value="${bloodGlucose.getPtID()}" /></td>
                    <td><a href="EditBg?BgID=<c:out value="${bloodGlucose.getBgID()}"/>">Edit Blood Glucose Value</a></td>
                    <td><c:out value="${bloodGlucose.getBgDate()}" /></td>
                    <td><c:out value="${bloodGlucose.getBgTime()}" /></td>
                    <td><c:out value="${bloodGlucose.getBloodGlucose()}"/>"></td>
                    <td><a href="DeleteBg?BgID=<c:out value="${blogUser.getUserName()}"/>">Delete Blood Glucose Value</a></td>
                </tr>
            </c:forEach>
       </table>

</body>
</html>