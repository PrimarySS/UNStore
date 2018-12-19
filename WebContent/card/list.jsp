<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
		// 返回首页
		function backIndex() {
			location.href="<%=basePath%>menu.jsp";
		}
		
		// 插入页面
		function insertCard() {
			location.href="<%=basePath%>card/insert.jsp";
		}
			  
		// 删除数据
		function deleteconfirm(id){
			if (confirm("确实要删除该记录吗？")){
				location.href="<%=basePath%>deletecard.action?id=" + id;
			}
		}
		
		// 导入名片	  
		function upload() {
			location.href="<%=basePath%>card/upload.jsp";
		}
		
		// 导出名片
		function download() {
			location.href="<%=basePath%>down.action";
		}
			  
		// 全选
		function selectall() {
			var a = f2.BoxList.length;
			if (a != undefined){
				for (i = 0; i < a; i++)
					f2.BoxList[i].checked = true;
				} 
			else
				f2.BoxList.checked = true;
		}

		// 取消全选
		function unselectall() {
			var a = f2.BoxList.length;
			if (a != undefined){
				for (i = 0; i < a; i++)
					f2.BoxList[i].checked = false;
			} 
			else
				f2.BoxList.checked = false;
		}
	
		// 删除所选
		function delchoose() {
			if (confirm("确实要删除所选吗？")) {
				document.f2.action="<%=basePath%>delListcard.action";
			}
		}
		
		// 进入回收站
		function retrieve() {
			document.f2.action="<%=basePath%>findretrieve.action";
		}
		
		// 所选移到回收站
		function moveToRetrieve(){
			if (confirm("确实要将选择的记录移到回收站吗？")) {
				document.f2.action="<%=basePath%>revertretrieve.action";
		}
		
	}
</script>

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
	color: white;
}

.end{
	width:945px;
	margin-left:203px;
	text-align: center;
	background: #202340;
}

a{
	text-decoration: none;
	color: white;
}

.content{
	background: #202340;
	background-color: rgb(0,0,0,0.5);
}

span{
	margin-left: 10px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名片浏览与查询</title>
</head>
<body>
	<h3 align="center">名片浏览与查询</h3>
	<form action="<%=basePath%>searchcard.action" method="post">
		<div align="center">
			名片搜索: <input name="name" type="text" /> 
			<input type="submit" value="查询" />
		</div>
	</form>
	<br>
	<br>
	<s:form method="post" name="f2">
		<table align="center">
			<tr>
				<td><input type="button" value="返回首页" onclick="backIndex()" /></td>
				<td><input type="button" value="添加" onclick="insertCard()" /></td>
				<td><input type="button" value="全选" onclick="selectall()" /></td>
				<td><input type="button" value="取消全选" onclick="unselectall()" /></td>
				<td><input type="submit" value="彻底删除所选" onclick="delchoose()" /></td>
				<td><input type="submit" value="将所选移到回收站 " onclick="moveToRetrieve()" /></td>
				<td><input type="button" value="导入名片" onclick="upload()" /></td>
				<td><input type="button" value="导出查询结果" onclick="download()" /></td>
				<td><input type="submit" value="进入回收站" onclick="retrieve()" /></td>
			</tr>
		</table>
		<br>
		<table class="content" width="70%" border="0" cellpadding="3" cellspacing="1" align="center" style="text-align: center;">
			<tr bgcolor="#202340">
				<td></td>
				<td>姓名</td>
				<td>性别</td>
				<td>单位</td>
				<td>手机</td>
				<td>电话</td>
				<td>Email</td>
				<td>通讯地址</td>
				<td>操作</td>
			</tr>
			<s:iterator var="card" value="cardList">
				<tr>
					<td>
						<input type="checkbox" name="BoxList" value="<s:property value="#card.id" />">
					</td>
					<td><s:property value="#card.name" /></td>
					<td><s:property value="#card.sex" /></td>
					<td><s:property value="#card.department" /></td>
					<td><s:property value="#card.mobile" /></td>
					<td><s:property value="#card.phone" /></td>
					<td><s:property value="#card.email" /></td>
					<td><s:property value="#card.address" /></td>
					<td>
						<a href="<%=basePath%>findcard.action?id=<s:property value="#card.id" />">修改</a>
						<a href="javascript:deleteconfirm('<s:property value="#card.id" />')">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<!--分页功能 -->
	<div class="end">
	<s:set name="page" value="#request['page']"></s:set>
	
	<s:set name="maxPage" value="#request['maxPage']"></s:set>
					
	<span><s:if test="#page == 1">首页</s:if></span>
	
	<span><s:if test="#page > 1 "><a href="<%=path %>/listcard.action?page=1"> 首页</a></s:if></span>
					
	<span><s:if test="#page == 1 ">上一页</s:if></span></span>
					
	<span><s:if test="#page > 1 "><a href="<%=path %>/listcard.action?page=<s:property value="#page-1"/>"> 上一页</a></s:if></span>
					
	<span><s:if test="#page == #maxPage">下一页</s:if></span>
					
	<span><s:if test="#page < #maxPage "><a href="<%=path %>/listcard.action?page=<s:property value="#page+1"/>"> 下一页</a></s:if></span>
					
	<span><s:if test="#page == #maxPage">末页</s:if></span>
					
	<span><s:if test="#page < #maxPage  "><a href="<%=path %>/listcard.action?page=<s:property value="#maxPage"/>">末页</a></s:if></span>
				
	</div>
		
	</s:form>
</body>
</html>