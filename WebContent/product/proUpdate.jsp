<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String context = request.getContextPath();
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>My JSP 'proUpdate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">

body{
	background: url("img/商品管理背景.jpg");
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
	height: 450px;
	background: #202340;
	background-color:rgb(0,0,0,0.2);
	position: absolute;
	top: 40%;
	left: 30%;
	transform: translate(-50%, -50%);
}

.t {
	color: white;
	font-weight:bold;
	border-style: none;
	margin-top: 50px;
	margin-bottom: 30px;
	margin-left: 60px;
}

.btn {
	width:100px;
	height:40px;
	font-weight: bold;
	color: white;
	border-style: none;
	margin-left: 60px;
	background: #202340;
	background-color:rgb(0,0,0,0.2);
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
	margin-top: 50px;
}
</style>

</head>

<body>

	<div class="center">
		<a href="<%=context%>/listproduct.action">返回上一页</a>
		<p class="hp">商品修改</p>
		<form action="updateproduct.action" method="post" enctype="multipart/form-data">
			<table align="center" border="0" cellpadding="3" cellspacing="10" class="t">
				<tr>
					<td>商品名称:</td>
					<td><input type="text" value="<s:property value="#updateProduct.name"/>" name="name"></td>
				</tr>
				<tr>
					<td>商品价格:</td>
					<td><input type="text" value="<s:property value="#updateProduct.price"/>" name="price"></td>
				</tr>
				<tr>
					<td>商品描述:</td>
					<td><input type="text" value="<s:property value="#updateProduct.description"/>" name="description"></td>
				</tr>
				<tr>
					<td>商品图片:</td>
					<td><input type="file" name="headImg"></td>
				</tr>
			</table>
			<input type="submit" value="提交" class="btn"> 
			<input type="reset" value="重置" class="btn" onclick="proUpdate.jsp">
		</form>
	</div>
</body>
</html>
