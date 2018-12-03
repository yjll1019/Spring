<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List"%>
<%@ page import="net.skhu.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<form method="post"> 
<%
String id = String.valueOf(request.getAttribute("id"));

%>
<input type="text" name="searchText">
<button type="submit">검색
<input type="hidden" name="id" value="<%=id %>"/>
</button>
</form>

	<div id="jb-content">
				<div style="margin-left: 15%; margin-top: 5%;">
					<h3>수강 목록</h3>
				</div>
	
			<div class="table-responsive"
				style="margin-left: 15%; font-size: 12pt; margin-top: 2%">
				<table class="table" style="width: 70%; margin-bottom: 100px;">
					<thead>
						<tr>
							<th>년도</th>
							<th>학기</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>이수구분</th>
							<th>학점</th>
							<th>성적등급</th>
							<th></th>
						</tr>
					</thead>
					<%
					//List<String> majorAdmitList = (List) request.getAttribute("majorAdmitList");
					List<MySubject> mySubjectlist = (List) request.getAttribute("mySubjectlist");
					
					%>
					<tbody>
						<%
							for(int i=0; i<mySubjectlist.size(); ++i){
						%>
							<tr>
								<td><%= mySubjectlist.get(i).getTakeYear() %></td>
								<td><%= mySubjectlist.get(i).getTakeSemester() %></td>
								<td><%= mySubjectlist.get(i).getSubjectCode() %></td>
								<td><%= mySubjectlist.get(i).getSubjectName() %></td>
								<td><%= mySubjectlist.get(i).getCompletionDivision() %></td>
								<td><%= mySubjectlist.get(i).getCredit() %></td>
								<td><%= mySubjectlist.get(i).getScore() %></td>
							</tr>
						<%
							}
						%>
				
					</tbody>
				</table>
			</div>
			
	</div>
</body>
</html>