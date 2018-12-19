<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加名片</title>

<style type="text/css">

body{
	background: url("../img/名片管理主页.jpg");
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
	width: 400px;
	height: 500px;
	background: #202340;
	background-color:rgb(0,0,0,0.2);
	position: absolute;
	top: 50%;
	left: 30%;
	transform: translate(-50%, -50%);
}

.t {
	color: white;
	font-weight:bold;
	border-style: none;
	margin-top: 30px;
	margin-bottom: 30px;
	margin-left: 70px;
	border: 0px;
	border-spacing: 10px;
	border-collapse: 5px;
}

.btn {
	width:100px;
	height:40px;
	font-weight: bold;
	color: #333;
	background: #999;
	border-style: none;
	margin-left: 60px;
	background: #202340;
	background-color:rgb(0,0,0,0.4);
	color: white;
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

.hp{
	color: white;
	font-size: 24px;
	margin-left:140px;
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="center">
		<a href="<%=basePath%>listcard.action">返回列表</a><br><br>
		<h3 class="hp">添加名片</h3>
		<form action="<%=path%>/insertcard.action" method="post">
			<table class="t">
				<s:textfield label="姓名" name="name"></s:textfield>
				<s:radio label="性别" list="#{'男':'男','女':'女'}" name="sex" value="'男'"></s:radio>
				<s:textfield label="单位" name="department"></s:textfield>
				<s:textfield label="手机" name="mobile"></s:textfield>
				<s:textfield label="电话" name="phone"></s:textfield>
				<s:textfield label="Email" name="email"></s:textfield>
				<s:textfield label="地址" name="address"></s:textfield>
			</table>
			<table>
				<tr>
					<td><s:submit value="提交" theme="simple" class="btn" /></td>
					<td><s:reset value="重置" theme="simple" class="btn"/></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>