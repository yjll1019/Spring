<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
  <h1>학생 목록</h1>
 <table id="articles" class="table table-bordered">
    <thead>
      <tr>
        <th class="text-center" style="width:80px;">id</th>
        <th>name</th>
        <th style="width:150px;">business phone</th>
        <th style="width:150px;">email</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="employees" items="${ list }">
        <tr data-url="edit?id=${ employees.id }">
          <td class="text-center">${ employees.id }</td>
          <td>${ employees.lastName }  ${ employees.firstName }</td>
          <td>${ employees.businessPhone }</td>
          <td>${ employees.emailAddress }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>