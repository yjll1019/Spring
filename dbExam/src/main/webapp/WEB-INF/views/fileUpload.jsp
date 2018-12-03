<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<% 
	String result = String.valueOf(request.getAttribute("r"));
	String id = String.valueOf(request.getAttribute("id"));

%>
<script>
	var r = "<%= result%>";
	   if(r == "-1"){
	       alert('업로드 실패 혹은 선택된 파일이 없습니다.');
	    }
    
</script>
<body>
	<form action="mySubject_upload" method="post" enctype="multipart/form-data" style="margin-left: 10px">
                     		<div class="form-group">
                     		<label for="file" class="cols-sm-2 control-label">수강목록 업로드</label>
                     			<div class="cols-sm-10">
                        			<div class="input-group">
                           				<span class="input-group-addon"><i class="fa fa-file-upload fa" aria-hidden="true" style="margin-top: 10px;"></i></span>
                           				&nbsp;&nbsp;
                           				<input type="file" name="file" style="width: 250px;" />
                           				<button type="submit" class="btn btn-outline-primary" style="font-size: 13px;">업로드</button>
                        				<input type="hidden" name="id" value="<%=id %>"/>
                        			</div>
                     			</div>
                  			</div>               
</form>
</body>
</html>	
	