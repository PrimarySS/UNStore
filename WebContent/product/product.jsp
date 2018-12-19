<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'product.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">

body{
	background: url("../img/商品管理背景.jpg");
	 /* 背景图垂直、水平均居中 */
	background-position: center center;
	 /* 背景图不平铺 */
	background-repeat: no-repeat;
	/*当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
	background-attachment: fixed; 
	/*图片铺满*/
	background-size:100% 100%;
	overflow-x: hidden;
	overflow-y: hidden;
}

.center {
	width: 900px;
	height: 600px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.center_a1 {
	width: 200px;
	height: 80px;
	font-size: 20px;
	text-align: center;
	background: #999;
	margin-top: 70px;
	margin-left: 70px;
	background: #202340;
	background-color:rgb(0,0,0,0.3);
}

.center_a2 {
	width: 200px;
	height: 80px;
	font-size: 20px;
	text-align: center;
	margin-top: 10px;
	background: #333;
	margin-left: 70px;
	background: #202340;
	background-color:rgb(0,0,0,0.3);
}

.center_a3 {
	width: 200px;
	height: 80px;
	font-size: 20px;
	text-align: center;
	margin-top: 10px;
	background: #666;
	margin-left: 70px;
	background: #202340;
	background-color:rgb(0,0,0,0.3);
}

a {
	color: white;
	text-decoration: none;
	font-weight: bold;
	margin-top: 25px;
	margin-left: 60px;
	display: block;
	float: left;
}

a:HOVER {
	/* width: 200px;
	height: 80px; */
	margin-top:20px;
	/* background-color:#202340;
	background-color:rgb(0,0,0,0.6); */
}

.hp{
	color: white;
	font-size: 24px;
	margin-left: 130px;
	font-weight: bold;
	margin-top: 30px;
}
</style>

</head>

<body>
	<div class="center">
		<p class="hp">商品管理</p>
		<div class="center_a1"><a href="<%=context%>/product/proSave.jsp">添加商品</a> </div>
		<div class="center_a2"><a href="<%=context%>/listproduct.action">商品列表</a> </div>
		<div class="center_a3"><a href="<%=context%>/menu.jsp">返回首页</a></div>
	</div>

</body>
</html>
