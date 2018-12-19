<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传记录页面</title>
<style type="text/css">
body {
	background: url("../img/名片管理主页.jpg");
	/* 背景图垂直、水平均居中 */
	background-position: center center;
	/* 背景图不平铺 */
	background-repeat: no-repeat;
	/*当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
	background-attachment: fixed;
	/*图片铺满*/
	background-size: 100% 100%;
	overflow-x: hidden;
	overflow-y: hidden;
	color: white;
}

.center {
	width: 400px;
	height: 500px;
	/* background: #202340;
	background-color:rgb(0,0,0,0.2); */
	position: absolute;
	top: 40%;
	left: 30%;
	transform: translate(-50%, -50%);
	text-align: center;
}

.btn {
	width:100px;
	height:40px;
	font-weight: bold;
	color: #333;
	background: #999;
	border-style: none;
	background: #202340;
	background-color:rgb(0,0,0,0.4);
	color: white;
	margin-top: 20px;
}

.hp{
	color: white;
	font-size: 24px;
	font-weight: bold;
	margin-top: 120px;
}

a {
	color: white;
	text-decoration: none;
	font-weight: bold;
	margin-top: 10px; 
	margin-left:10px; 
	display: block;
	float: left;
}

</style>
</head>
<body>
	<div class="center">
		<a href="<%=basePath%>listcard.action">返回列表</a><br><br>
		<h3 class="hp">上传Excel文档</h3>
		<h4>注意：电子表只能为"*.xls",并且表中有左到右，各字段信息依次为：</h4>
		姓名,性别,单位,手机,电话,电子邮箱,地址
		<br><br>
		<form action="upload.action" method="post" enctype="multipart/form-data">
			<s:file name="file" label="提交文件"></s:file>
			<br> <br> 
			<input type="submit" value="提交" class="btn" />
		</form>
	</div>
</body>
</html>