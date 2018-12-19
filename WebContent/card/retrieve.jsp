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
	  // 删除该记录
	  function deleteconfirm(id){
	      if (confirm("确实要删除该记录吗？")){
	          location.href="<%=basePath%>deleteretrieve.action?id=" + id;
			}
	  }
	  
	  // 进入名片管理
	  function card() {
	  		location.href="<%=basePath%>listcard.action";
	  	}
	  
	  // 全选
	  function selectall() {
			var a = f2.BoxList.length;
			if (a != undefined){
				for (i = 0; i < a; i++)
					f2.BoxList[i].checked = true;
			} else
				f2.BoxList.checked = true;
	  }
	
	  // 取消全选
	  function unselectall() {
			var a = f2.BoxList.length;
			if (a != undefined){
				for (i = 0; i < a; i++)
					f2.BoxList[i].checked = false;
			} else
				f2.BoxList.checked = false;
		}
		
		// 删除所选
		function delchoose() {
			if (confirm("确实要删除所选吗？")) {
				document.f2.action="<%=basePath%>delListretrieve.action";
			}
		}
		
		// 记录还原
		function revert(){
			if (confirm("确实要将选择的记录还原吗？")) {
				document.f2.action="<%=basePath%>reductionretrieve.action";
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
	width:950px;
	margin-left:200px;
	text-align: center;
	background: #202340;
}

a{
	text-decoration: none;
	color: white;
}

.content{
	background: #202340;
	background-color: rgb(0,0,0,0.4);
}

span{
	margin-left: 10px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回收站信息管理</title>
</head>
<body>
	<h3 align="center">回收站信息管理</h3>
	<form action="searchretrieve.action" method="post">
		<div align="center">
			名片搜索: <input name="name" type="text" />
			 <input type="submit" value="查询" />
		</div>
	</form>
	<br>
	<br>
	<s:form  method="post" name="f2">
		<table align="center">
			<tr>
			    <td><input type="button" value="全选" onclick="selectall()" /></td>
				<td><input type="button" value="取消全选" onclick="unselectall()" /></td>
				<td><input type="submit" value="彻底删除所选" onclick="delchoose()" /></td>
				<td><input type="submit" value="还原所选" onclick="revert()" /></td>				
				<td><input type="button" value="进入名片管理" onclick="card()" /></td>
			</tr>
		</table>
		<br>
		<table class="content" width="70%" border="0" cellpadding="3" cellspacing="1"
			align="center">
			<tr style="background:#202340;">
				<td></td>
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>单位</td>
				<td>手机</td>
				<td>电话</td>
				<td>Email</td>
				<td>通讯地址</td>
				<td>操作</td>
			</tr>
			<s:iterator var="card" value="cards" status="list">
				<tr>
					<td><input type="checkbox" name="BoxList" value="<s:property value="#card.id" />"></td>
					<td><s:property value="#card.id" /></td>
					<td><s:property value="#card.name" /></td>
					<td><s:property value="#card.sex" /></td>
					<td><s:property value="#card.department" /></td>
					<td><s:property value="#card.mobile" /></td>
					<td><s:property value="#card.phone" /></td>
					<td><s:property value="#card.email" /></td>
					<td><s:property value="#card.address" /></td>
					<td><a href="javascript:deleteconfirm('<s:property value="#card.id" />')">删除</a></td>
				</tr>

			</s:iterator>
		</table>
		
			<!--分页功能 -->
	<div class="end">
	<s:set name="page" value="#request['page']"></s:set>
	
	<s:set name="maxPage" value="#request['maxPage']"></s:set>
					
	<span><s:if test="#page == 1">首页</s:if></span>
	
	<span><s:if test="#page > 1 "><a href="<%=path %>/findretrieve.action?page=1"> 首页</a></s:if></span>
					
	<span><s:if test="#page == 1 ">上一页</s:if></span>
					
	<span><s:if test="#page > 1 "><a href="<%=path %>/findretrieve.action?page=<s:property value="#page-1"/>"> 上一页</a></s:if></span>
					
	<span><s:if test="#page == #maxPage">下一页</s:if></span>
					
	<span><s:if test="#page < #maxPage "><a href="<%=path %>/findretrieve.action?page=<s:property value="#page+1"/>"> 下一页</a></s:if></span>
					
	<span><s:if test="#page == #maxPage">末页</s:if></span>
					
	<span><s:if test="#page < #maxPage  "><a href="<%=path %>/findretrieve.action?page=<s:property value="#maxPage"/>">末页</a></s:if></span>
				
	</div>
		
	</s:form>
</body>
</html>