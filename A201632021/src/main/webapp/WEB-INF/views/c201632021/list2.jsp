<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<%

	int departmentId = Integer.parseInt(request.getParameter("departmentId"));
%>
<div class="container">
	<h1>교수목록</h1>
	<form method="get">
		<div class="form-group">
			<label>학과:  </label>
			<input type="number" name="departmentId" value=<%=departmentId%>>
	 	<button type="submit" class="btn btn-primary"> 조회</button>
	</div>

	 <table class="table table-bordered mt5">
    <thead>
      <tr>
        <th>id</th>
        <th>교수이름</th>
        <th>학과</th>
      </tr>
    </thead>
    <tbody>
    
      <c:forEach var="professor" items="${ professors }"> 
         <tr>
          <td>${ professor.id }</td>
          <td>${ professor.professorName }</td>
          <td>${ professor.departmentName}</td>
          </tr>
      </c:forEach>
    </tbody>
  </table>
 </form>
</div>
</body>
</html>