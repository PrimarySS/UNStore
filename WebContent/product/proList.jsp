<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String context = request.getContextPath();
	
%>
<html>
<head>

<title>My JSP 'proList.jsp' starting page</title>

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
	width: 900px;
	height: 600px;
	background: #999;
	background-color:rgb(0,0,0,0.2);
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
}

.t1 { 
	background-color:rgb(0,0,0,0.2);
	border-style: none;
	color: white;
}

.t2 {
	margin-top: 20px;
	border-style: none;
	text-align: center;
	color: white;
}

</style>

<script type="text/javascript">
	function queryPageProduct() {
		document.f1.action="queryPageproduct.action";
		document.f1.submit();
	}

</script>

</head>

<body style="overflow: hidden;">

<div class="center">
	<a href="<%=context %>/menu.jsp">返回首页</a><br><br>
	<h3 align="center">商品浏览与查询</h3>
	<s:form name="f1" method="post">
		<div align="center">
			商品搜索: <input name="name" type="text" /> 
			<input type="button" value="查询" onclick="queryPageProduct()" />
		</div>
	</s:form>
	<form name="productForm" action="queryPageProduct.action" method="post">
		<table width=900 class="t2" border="0" cellpadding="3" cellspacing="1">
				<tr bgcolor="#CDCDCD" class="t1">
					<td>产品图片</td>
					<td>产品名称</td>
					<td>产品价格</td>
					<td>产品描述</td>
					<td>操作</td>
				</tr>
	
				<s:iterator value="list" var="p">
					<tr>
						<!-- 使用相对地址 --> 
						<td>
							<s:if test="#p.imageSrc != null">
								<img src="<%=context %>/UploadImages/<s:property value="#p.imageSrc"/>" style="height:60px; width:80px" />
							</s:if>
						</td>
						<td>
							<s:property value="#p.name" />
						</td>
						<td>
							<s:property value="#p.price" />
						</td>
						<td>
							<s:property value="#p.description" />
						</td>
						
						<td>
							<a href="<%=context%>/FindProductByIdproduct.action?id=<s:property value="#p.id"/>">修改</a> 
							<a href="<%=context%>/deleteproduct.action?id=<s:property value="#p.id"/>">删除</a>
						</td>
					</tr>
				</s:iterator>
		</table>
	
	<!--分页功能 -->
	<br>
	
	<s:set name="page" value="#request['page']"></s:set>
	
	<s:set name="maxPage" value="#request['maxPage']"></s:set>
					
	<s:if test="#page == 1">首页</s:if>
	
	<s:if test="#page > 1 "><a href="<%=context %>/listproduct.action?page=1"> 首页</a></s:if>
					
	<s:if test="#page == 1 ">上一页</s:if>
					
	<s:if test="#page > 1 "><a href="<%=context %>/listproduct.action?page=<s:property value="#page-1"/>"> 上一页</a></s:if>
					
	<s:if test="#page == #maxPage">下一页</s:if>
					
	<s:if test="#page < #maxPage "><a href="<%=context %>/listproduct.action?page=<s:property value="#page+1"/>"> 下一页</a></s:if>
					
	<s:if test="#page == #maxPage">末页</s:if>
					
	<s:if test="#page < #maxPage  "><a href="<%=context %>/listproduct.action?page=<s:property value="#maxPage"/>">末页</a></s:if>
				
	<br>
	
</form>
</div>

</body>
</html>
