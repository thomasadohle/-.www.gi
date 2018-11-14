<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Bg Value</title>
</head>
<body>
<h1>Update Bg Value</h1>
	<form action="EditBg" method="post">
		<p>
			<label for="bgID">BgID</label>
			<input id="bgID" name="bgID" value="${fn:escapeXml(param.bgID)}">
		</p>
		<p>
			<label for="newBgVal">New Bg Value</label>
			<input id="newBgVal" name="newBgVal" value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	<p>Click <a href="Home.html">here</a> to return to homepage.</p>
</body>
</html>