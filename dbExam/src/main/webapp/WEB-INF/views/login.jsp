<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<% 
	String result = String.valueOf(request.getAttribute("result"));
String id = String.valueOf(request.getAttribute("id"));
	
%>
<script>
	var r = "<%= result%>";
    if(r == 1){
        alert('로그인이 완료되었습니다.');
        window.location.href = 'userEdit?id=<%= id%>';
     } else if(r == -1){
        alert('해당 아이디가 존재하지 않습니다. 아이디는 학번입니다.');
     } else if(r == -2){
    	   alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');   	 
     }
</script>
</head>
<body>
<form method="post">
아이디<input type="text" name="id">
비밀번호<input type="text" name="password">
<button type="submit">로그인</button>
</form>
<br/>
</body>
</html>