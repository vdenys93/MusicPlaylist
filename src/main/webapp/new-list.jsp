<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New List</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Date Created: <input type="text" name="month" placeholder="mm" size="4">
	<input type="text" name="day" placeholder="dd" size="4">, 
	<input type="text" name="year" placeholder="yyyy" size="4">
	Playlist Name: <input type="text" name="playlistName"><br />
	
	Available Songs: <br />
	<select name="allSongsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allSongs }" var="currentsong">
	<option value="${currentsong.id}">${currentsong.title }, by ${currentsong.artist }</option>
	</c:forEach></select>
	<br />
	<input type="submit" value="Create Playlist and Add Songs">
	</form>
	<a href="index.html">Add more Songs</a>
</body>
</html>