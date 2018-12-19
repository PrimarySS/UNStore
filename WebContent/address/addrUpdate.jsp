<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增收货地址</title>

<style type="text/css">

body{
	background: url("img/物流界面.jpg");
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
	margin-left:150px;
	margin-top:50px;
	font-weight: bold;
}

</style>
</head>
<body>

<div class="center">
  	<a href="<%=basePath%>/listspas.action">返回列表</a>
  	<p class="hp">编辑地址</p>
	<form action="updatespas.action" method="post">
		<table class="t">
			<tr>
				<td>收货人</td><td><input type="text"  value="<s:property value="#updateAddress.recipient" />" name="recipient"></td>
			</tr>
			<tr>
				<td>手机号</td><td><input type="text"  value="<s:property value="#updateAddress.mobilePhone" />" name="mobilePhone"></td>
			</tr>
			<tr>
				<td>收货地址</td><td><input type="text"  value="<s:property value="#updateAddress.address" />" name="address"></td>
			</tr>
			<tr>
				<td>详细地址</td><td><input type="text"  value="<s:property value="#updateAddress.detailedAddress" />" name="detailedAddress"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="提交" class="btn">
        <input type="reset" value="重置" class="btn" onclick="addrUpdate.jsp">
	</form>
</div>
</body>
</html>