<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
	<input type="hidden" name="id" value="${listToEdit.id }">
	List Name: <input type="text" name="listName" value="${listToEdit.listName }"><br />
	
	Date Created: <input type="text" name="month" placeholder="mm" size="4" value="${month }">
	<input type="text" name="day" placeholder="dd" size="4" value="${day }">, 
	<input type="text" name="year" placeholder=yyyy" size="4" value="${year }">
	
	Playlist Name: <input type="text" name="playlistName" value="${listToEdit.playlist.playlistName }"><br />
	
	Available Songs: <br />
	
	<select name="allSongsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allSongs }" var="currentsong">
	<option value="${currentsong.id }">${currentsong.title }, by ${currentsong.artist }</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Save Changes">
	</form>
	<a href="index.html">Add more Songs</a>
</body>
</html>