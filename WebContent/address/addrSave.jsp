<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增收货地址</title>

<style type="text/css">

body{
	background: url("../img/物流界面.jpg");
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
	left: 70%;
	transform: translate(-50%, -50%);
}

.t {
	color: white;
	font-weight:bold;
	border-style: none;
	margin-top: 50px;
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
	margin-left: 10px;
	display: block;
	float: left;
}

.hp {
	color: white;
	font-size: 24px;
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="center">
		<a href="<%=basePath %>listspas.action">返回列表</a><br><br>
		<p class="hp">新增地址</p>
		<form action="<%=path %>/savespas.action" method="post">
			<table class="t" border="0" cellpadding="5" cellspacing="1">
				<tr>
					<td>收货人</td>
					<td><input type="text" value="收货人姓名" name="recipient"></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="text" value="请填写收货手机号" name="mobilePhone"></td>
				</tr>
				<tr>
					<td>收货地址</td>
					<td><input type="text" value="请选择省/市/县（区）" name="address"></td>
				</tr>
				<tr>
					<td>详细地址</td>
					<td><input type="text" value="请输入详细的地址信息（街道、楼牌号等）" name="detailedAddress"></td>
				</tr>

			</table>
			<input type="submit" value="提交" class="btn"> 
			<input type="reset" value="重置" class="btn" onclick="addrSave.jsp">
		</form>
	</div>
</body>
</html>