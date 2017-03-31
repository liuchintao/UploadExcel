<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<%@include file="common/head.jsp" %>
</head>
<body>
<form action="<%=basePath %>upload" enctype="multipart/form-data" method="post">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>上传EXCEL文件</h2>
			</div>
			<div class="panel-body"> 
				选择文件：<input type="file" name="xlsfile">
				<input type="submit" value="SUBMIT" class="btn btn-info">
			</div>
		</div>
	</div>
</form>
</body>
</html>