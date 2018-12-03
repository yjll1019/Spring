<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<% 
	String result = String.valueOf(request.getAttribute("result"));
String id = String.valueOf(request.getAttribute("id"));
%>
<script>
	var r = "<%= result%>";
    if(r == 0){
        alert('회원가입이 완료되었습니다.');
        window.location.href ='login';
     } else if(r == -1){
        alert('이미 존재하는 아이디입니다. 아이디는 학번입니다.');
     }
    
</script>
<body>
<form method="post" >
 학번: <input type="text" name="userId" >
 <br/>
 학과: <input type="text" name="department" >
 <br/>
 이름 : <input type="text" name="name" >
  <br/>
 성별: <input type="text" name="gender">
 <br/>
 학년: <input type="text" name="grade" >
 <br/>
 휴대폰: <input type="text" name="phone">
 <br/>
  이메일: <input type="text" name="email" }">
 <br/>
  비밀번호 : <input type="text" name="password" >
 <br/>
 <button type="submit">회원가입</button>
<br/>
 </form>

</body>
</html>