<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String context = request.getContextPath();
%>

<%@taglib uri="/struts-tags"  prefix="s" %>

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
	color: white;
}

.center {
	width: 900px;
	height: 600px;
	/* background: #999;
	background-color:rgb(0,0,0,0.1); */
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}	

a {
	color: white;
	font-weight: bold;
	text-decoration: none;
}

.head {
	margin-left: 10px;
	margin-top: 20px;
	margin-bottom: 100px;
}

.t{ 
	text-align: center;
	margin-top: 30px;
	border-style: none;
	text-align: center;
	margin-left: 150px;
}

.add {
	margin-top: 20px;
	margin-left: 150px;
}

.page {
	margin-top: 20px;
	margin-left: 350px;
}

.t1{

background-color: rgb(0,0,0,0.3);

}

</style>

</head>
<body>
	<div class="center">
		<p class="head"><a href="menu.jsp">返回首页</a></p>
		<p class="add"><a href="<%=context %>/address/addrSave.jsp">新增收货地址</a></p>
		<table class="t" border="0" cellpadding="10" cellspacing="5">
			<tr bgcolor="#CDCDCD" class="t1">
				<td>收货人</td>
				<td>手机号</td>
				<td>收货地址</td>
				<td>详细地址</td>
				<td>操作</td>
			</tr>
			<s:iterator value="list" var="p">
				<tr>
					<td><s:property value="#p.recipient" /></td>
					<td><s:property value="#p.mobilePhone" /></td>
					<td><s:property value="#p.address" /></td>
					<td><s:property value="#p.detailedAddress" /></td>
	
					<td>
						<a href="<%=context %>/FindAddressByIdspas.action?id=<s:property value="#p.id"/>">修改</a> 
						<a href="<%=context %>/deletespas.action?id=<s:property value="#p.id"/>">删除</a>
					</td>
	
				</tr>
			</s:iterator>
			
		</table>
		
		<!--分页功能 -->
		<div class="page">
			<s:set name="page" value="#request['page']"></s:set>
			
			<s:set name="maxPage" value="#request['maxPage']"></s:set>
							
			<s:if test="#page == 1">首页</s:if>
			
			<s:if test="#page > 1 "><a href="<%=context %>/listspas.action?page=1"> 首页</a></s:if>
							
			<s:if test="#page == 1 ">上一页</s:if>
							
			<s:if test="#page > 1 "><a href="<%=context %>/listspas.action?page=<s:property value="#page-1"/>"> 上一页</a></s:if>
							
			<s:if test="#page == #maxPage">下一页</s:if>
							
			<s:if test="#page < #maxPage "><a href="<%=context %>/listspas.action?page=<s:property value="#page+1"/>"> 下一页</a></s:if>
							
			<s:if test="#page == #maxPage">末页</s:if>
							
			<s:if test="#page < #maxPage  "><a href="<%=context %>/listspas.action?page=<s:property value="#maxPage"/>">末页</a></s:if>
		</div>		
	</div>

</body>
</html>