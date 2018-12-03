<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<% String user = (String)request.getAttribute("user"); %>
</head>
<body>
 <form:form method="post" modelAttribute="student">
 학번: <input type="text" name="userId" value="${student.userId}">
 <br/>
 학과: <input type="text" name="department" value="${student.department}">
 <br/>
 이름 : <input type="text" name="name" value="${student.name }">
  <br/>
 성별: <input type="text" name="gender" value="${student.gender}">
 <br/>
 학년: <input type="text" name="grade" value="${student.grade}">
 <br/>
 휴대폰: <input type="text" name="phone" value="${student.phone}">
 <br/>
  이메일: <input type="text" name="email" value="${student.email}">
 <br/>
  비밀번호 : <input type="text" name="password" value="${student.password}">
 <br/>
 <button type="submit">수정</button>
<br/>
 </form:form>
 <a href="fileUpload?id=<%=user%>">엑셀파일업로드!</a> 
</body>
</html>