<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户</title>
</head>
<body>
<form action="/t59ssm3/updateUser" method="post">
<input type="hidden" name="id" value="${user.id}"/>
姓名:<input type="text" name="username" value="${user.username}"/><br/>
密码:<input type="password" name="password" value="${user.password}"/><br/>
状态:<select name="status">
         <option selected="selected" value="0">--请选择--</option>
         <option value="1" <c:if test="${user.status==1}">selected="selected"</c:if>>正常</option>
         <option value="2" <c:if test="${user.status==2}">selected="selected"</c:if>>禁用</option>
    </select><br/>
角色:<select name="roleId">
         <option selected="selected" value="0">--请选择--</option>
	     <c:forEach var="role" items="${roles}">
	         <option <c:if test="${role.id==user.roleId}">selected="selected"</c:if> value="${role.id}">${role.rolename}</option>
	     </c:forEach>
     </select><br/>
     <input type="submit" value="更新用户"/>
</form>
</body>
</html>