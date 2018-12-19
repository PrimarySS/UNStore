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
	background: url("img/名片管理主页.jpg");
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
		<h3 class="hp">修改名片</h3>
		<s:form action="updatecard.action" method="post">
			<table class="t">
				<tr>
					<td>姓名</td>
					<td><input type="text" value="<s:property value="#card.name"/>" name="name"/></td>
				</tr>
				<tr>
					<td><s:radio label="性别" list="#{'男':'男','女':'女'}" value="#card.sex" name="sex"></s:radio></td>
				</tr>
				<tr>
					<td>单位</td>
					<td><input type="text" value="<s:property value="#card.department"/>" name="department"/></td>
				</tr>
				<tr>
					<td>手机</td>
					<td><input type="text" value="<s:property value="#card.mobile"/>" name="mobile"/></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" value="<s:property value="#card.phone"/>" name="phone"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" value="<s:property value="#card.email"/>" name="email"/></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" value="<s:property value="#card.address"/>" name="address"/></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><s:submit value="提交" theme="simple" class="btn" /></td>
					<td><s:reset value="重置" theme="simple" class="btn" /></td>
				</tr>
			</table>
		</s:form>
	</div>

</body>
</html>