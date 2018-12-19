<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'admin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">

body{
	background: url("img/login.jpg");
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
	width: 300px;
	height: 450px;
	background: #202340;
	background-color:rgb(0,0,0,0.3);
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.t{
	color: white;
	font-weight:bold;
	font-size: 18px;
	margin-left: 30px;
	margin-top: 40px;
	border-style: none;

}

.sub{
	width:100px;
	height:40px;
	font-size: 20px;
	font-weight: bold;
	margin-left: 30px;
	margin-top: 30px;
	color: white;
	background-color:rgb(0,0,0,0.5);
	font-weight:bold;
	border-style: none;
}

.error {
	width: 120px;
	height: 20px;
	text-align: center;
	margin-left: 40px;
	color: white;
}

.img {
	width: 80px;
	height: 80px;
	margin-left: 110px;
	margin-bottom: 20px;
}

img {
	width: 80px;
	height: 80px;
	margin-top: 10px;
}

.hp{
	color: white;
	font-size: 20px;
	text-align: center;
	font-weight: bold;
}

</style>

<script type="text/javascript">
	function login() {
		location.href="<%=basePath%>admin.jsp";
	}

</script>

</head>

<body>
	<div class="center">
		<p class="hp">管理员系统</p>
		
		<form action="registeredlogin.action" method="post">
			<span class="error"><s:property value="#error"/></span>
			<div class="img"><img src="img/purple.png" /></div>
			
			<table class="t" border="0" cellpadding="4" cellspacing="1" align="center">
				<tr>
					<td>注册昵称：<input type="text" name="AdminName"></td>
				</tr>
				
				<tr>
					<td>注册密码：<input type="password" name="AdminPassword"></td>
				</tr>
				
				<tr>
					<td>确认密码：<input type="password" name="SurePassword"></td>
				</tr>
				
				<tr>
					<td>注册邮箱：<input type="text" name="email"></td>
				</tr>
				
			</table>
			<input type="button" value="登  陆" class="sub" onclick="login()">
			<input type="submit" value="注  册" class="sub">
		</form>
	</div>
</body>
</html>
