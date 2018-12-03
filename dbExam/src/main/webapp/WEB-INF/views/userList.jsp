<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList</title>
</head>
<body>

<form method="post"> 
<select name="search" class="form-control">
	<option value="0">id</option>
	<option value="1">이름</option>
</select>

<input type="text" name="searchText">

<button type="submit">검색
</button>
</form>

<table>
			<thead>
				<tr>
					<th>id</th>
					<th>이름</th>

				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${userList }">
				<tr>
					<td><a href="userEdit?id=${user.id}">${user.id}</a></td>
					<td>${user.name }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

</body>
</html>