<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/t59ssm3/css/index.css">
	
  </head>
  
  <body>
    <form name="searchForm" action="/t59ssm3/getUserListByPage" method="post" style="margin-top:50px;">
            <div class="search">
                <span>用户名：</span><input type="text"  name="username" value="${condition.username}" />&nbsp;&nbsp;
                <span>密码：</span><input type="text"  name="password" value="${condition.password}"/>&nbsp;&nbsp;
                <span>状态：</span><input type="text"  name="status" value="${condition.status}"/>&nbsp;&nbsp;
                <input type="submit" value="查询" style="width:50px;"/>
                <input type="hidden" name="pageIndex"/>
                <input type="hidden" name="pageSize"/>
            </div>
    </form>
  
  
    <table style="width:70%;" border="1px" class="data_table">
   		<tr class="head_tr">
   			<td>序号</td>
   			<td>用户名</td>
   			<td>密码</td>
   			<td>状态</td>
   			<td>创建时间</td>
   			<td>角色ID</td>
   			<td>操作/<a href="/t59ssm3/getAllRoleName">增加</a></td>  		
   		</tr>
   		<c:forEach var="user" items="${users }" varStatus="s">
   		<tr <c:if test="${s.index%2==1 }"> style="background-color:#eee;"</c:if>>
   			<td>${s.index+1}</td>
   			<td>${user.username }</td>
   			<td>${user.password }</td>
   			<td>${user.status==1?"正常":"<span style='color:#f00;'>禁用</span>"}</td>
   			<td><fmt:formatDate value="${user.createtime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
   			<%-- <td>${user.roleId==1?"管理员":"普通用户" }</td> --%>
   			<td>${user.rolename}</td>
   			<td>
   				<a href="/t59ssm3/getUserInfoById?id=${user.id }">修改</a>
   				<a href="javascript:if(confirm('你确定要删除吗?')){location.href='/t59ssm3/deleteUser?id=${user.id }'}">删除</a>
   			</td>  		
   		</tr>
   		</c:forEach>
   	</table>
   	 <%@include file="/common/page.jsp" %>
  </body>
</html>
