<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">

body{
	background: url("img/helloworld.jpg");
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
	width: 500px;
	height: 450px;
	background: #202340;
	background-color:rgb(0,0,0,0.1);
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.center_pro {
	width: 200px;
	height: 50px;
	font-size: 20px;
	text-align: center;
	margin-left: 150px;
	margin-top: 50px;
	background: #999;
	background-color:rgb(0,0,0,0.3);
}

.center_spas {
	width: 200px;
	height: 50px;
	font-size: 20px;
	text-align: center;
	margin-left: 150px;
	margin-top: 10px;
	background: #333;
	background-color:rgb(0,0,0,0.3);
}

.center_user {
	width: 200px;
	height: 50px;
	font-size: 20px;
	text-align: center;
	margin-left: 150px;
	margin-top: 10px;
	background: #666;
	background-color:rgb(0,0,0,0.3);
}

.center_msg {
	width: 200px;
	height: 50px;
	font-size: 20px;
	text-align: center;
	margin-left: 150px;
	margin-top: 10px;
	background: green;
	background-color:rgb(0,0,0,0.3);
}

.center_out {
	width: 200px;
	height: 50px;
	font-size: 20px;
	text-align: center;
	margin-left: 150px;
	margin-top: 10px;
	background: red;
	background-color:rgb(0,0,0,0.3);
}

a {
	color: white;
	text-decoration: none;
	font-weight: bold;
	display: block;
	float: right;
	margin-top: 10px;
	margin-right: 40px;
	text-align: center;
}

a:HOVER {
	margin-top: 5px;
}

.hp{
	color: white;
	font-size: 24px;
	text-align: center;
	font-weight: bold;
	margin-top: 20px;
	margin-bottom: 10px;
}

</style>

</head>
<body>

	<div class="center">
		<p style="color: white;margin-left: 10px;">
			<s:if test="#AdminName != null">
				您好,<s:property value="#AdminName"/>！ 
			</s:if>
		</p>
		<p class="hp">管理权限</p>
		
		<div class="center_pro">
			<a href="product/product.jsp">商品信息管理</a>
		</div>

		<div class="center_spas">
			<a href="listspas.action">收货地址管理</a>
		</div>
		
		<div class="center_user">
			<a href="listcard.action">用户信息管理</a>
		</div>
		
		<div class="center_msg">
			<a href="recommendedproduct.action">推送信息管理</a>
		</div>
		
		<div class="center_out">
			<a href="outlogin.action" >退出管理系统</a>
		</div>
		
	</div>

</body>
</html>