<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete A BloodGlucose</title>
</head>
<body>
<h1>${messages.title}</h1>
<h3>Enter the BgID of the Blood Glucose Value that you would like to delete</h3>
	<form action="DeleteBg" method="post">
		<p>
			<div <c:if test="${messages.disableSubmit}">style="display:none"</c:if> >
				<label for="BgID">BgID</label>
				<input id="BgID" name="BgID" value="${fn:escapeXml(param.bgID)}"></input>
			</div>
		</p>
			
		
		<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit">
			</span>
		</p>
	</form>
	
	
	<br/><br/>
	
	<p>Click <a href="Home.html">here</a> to return to homepage.</p>
</body>
</html>