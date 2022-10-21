<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
	<table>
	<c:forEach items="${requestScope.allSongs }" var="currentsong">
	<tr>
		<td><input type="radio" name="id" value="${currentsong.id }"></td>
		<td>${currentsong.title }</td>
		<td>${currentsong.artist }</td>
	</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToSong">
	<input type="submit" value="delete" name="doThisToSong">
	<input type="submit" value="add" name="doThisToSong">
	</form>
</body>
</html>