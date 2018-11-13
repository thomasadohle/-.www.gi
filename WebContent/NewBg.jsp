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
			<label for="patientId">UserName</label>
			<input id="patientId" name="patientId" value="">
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
	
	
</body>
</html>