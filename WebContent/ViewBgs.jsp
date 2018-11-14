<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bg History</title>
</head>
<body>

<form action="ViewBgs" method="get"> <!-- action=specifies which servlet (controller) to send data to -->
		<h1>Last Ten Blood Glucose Entries</h1>
		<p>
			<label for="patientId">PatientID</label>
			<input id="patientId" name="patientId" value="${fn:escapeXml(param.patientId)}">
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
            <td><c:out value="${bloodGlucose.getPt().getPtID()}" /></td>
                    <td><a href="EditBg?bgID=<c:out value="${bloodGlucose.getBgID()}"/>">Edit Bg</a></td>
                    <td><c:out value="${bloodGlucose.getBgDate()}" /></td>
                    <td><c:out value="${bloodGlucose.getBgTime()}" /></td>
                    <td><c:out value="${bloodGlucose.getBloodGlucose()}"/></td>
                    <td><a href="DeleteBg?bgID=<c:out value="${bloodGlucose.getBgID()}"/>">Delete Blood Bg</a></td>
           </tr>
           </c:forEach>
        </table>
          
         <p>Click <a href="Home.html">here</a> to return to homepage.</p>



</body>
</html>