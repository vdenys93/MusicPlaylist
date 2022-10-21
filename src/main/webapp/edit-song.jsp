<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Song</title>
</head>
<body>
	<form action="editSongServlet" method="post">
	Title: <input type="text" name="title" value="${toEdit.title }">
	Artist: <input type="text" name="artist" value="${toEdit.artist }">
	<input type="hidden" name="id" value="${toEdit.id }">
	<input type="submit" value="Save Changes">
	</form>
</body>
</html>