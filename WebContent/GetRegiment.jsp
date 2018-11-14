<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="GetRegiment" method="post"> <!-- action=specifies which servlet (controller) to send data to -->
		<h1>Access a Patient's Treatment Regiment</h1>
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
	
	<h1>Patient Treatment Regiment</h1>
        <table border="1">
            <tr>
                <th>PatientID</th>
                <th>A1C</th>
                <th>Daytime Bg Target</th>
                <th>NightTime Bg Target</th>
                <th>Daytime Correction</th>
                <th>Nighttime Correction</th>
                <th>Breakfast Ratio</th>
                <th>Lunch Ratio</th>
                <th>Dinner Ratio</th>
                <th>BedTime Ratio</th>
            </tr>
            <tr> 
                <td><c:out value='${regiment.getPt().getPtID()}'/></td>
                <td><c:out value='${regiment.getA1C()}'/></td>
                <td><c:out value='${regiment.getDayTimeTarget()}'/></td>
                <td><c:out value='${regiment.getNighttimeTarget()}'/></td>
                <td><c:out value='${regiment.getDaytimeCorrection()}'/></td>
                <td><c:out value='${regiment.getNighttimeCorrection()}'/></td>
                <td><c:out value='${regiment.getBreakfastRatio()}'/></td>
                <td><c:out value='${regiment.getLunchRatio()}'/></td>
                <td><c:out value='${regiment.getDinnerRatio()}'/></td>
                <td><c:out value='${regiment.getBedtimeRatio()}'/></td>
              
           </tr> 
              
       </table>
       
       
       	<p>Click <a href="Home.html">here</a> to return to homepage.</p>
       
   
   
       
</body>
</html>