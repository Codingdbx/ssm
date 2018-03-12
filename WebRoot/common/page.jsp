<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
function jump(i,s) {
 	    var reg=/^[1-9]\d*$/;
		if(!reg.test(i)){
			alert("请输入正确的数字");
			document.getElementById("goPage").select();
			return;
		}
		
		var totalPage=document.getElementById("totalPage");
		if(parseInt(i)>parseInt(totalPage.value)){
			alert("已超过最大页面总数"+totalPage.value);
			document.getElementById("goPage").select();
			return;
		}  
	    /* location.href="/smbms/GetUsersServlet?pageIndex="+i+"&pageSize="+s;  */
	    document.searchForm.pageIndex.value=i;
	    document.searchForm.pageSize.value=s;
	    document.searchForm.submit();
	    
	 /*  var oForm = document.searchForm || document.forms[0];
		 with(oForm){
		     pageIndex.value=i;
		     pageSize.value=s;
		     submit();
		 } */
	    
}
</script>

            <input type="hidden" id="totalPage" value="${page.totalPage}"/>
            <table style="width:75%;margin:0 auto;font-size:13px;" class="page_table">
	            <tr> 
	            	<td>第<span style="color:#f00;">${page.pageIndex}</span>/${page.totalPage}页&nbsp;&nbsp;共${page.totalCount}条记录</td>
			        <td>
			        <c:choose>
			   					<c:when test="${page.pageIndex==1 }">&nbsp;&nbsp;&nbsp;&nbsp;
			                                                 首页&nbsp;&nbsp;
			   						上一页&nbsp;&nbsp;
			   					</c:when>
			   					<c:otherwise>
			   						<a href="javascript:jump(1,${page.pageSize });">首页</a>
			   						<a href="javascript:jump(${page.pageIndex-1},${page.pageSize });">上一页</a>
			   					</c:otherwise>
			   	    </c:choose>
			        <c:choose>
			   					<c:when test="${page.pageIndex==page.totalPage}">
			   						下一页&nbsp;&nbsp;
			   						末页&nbsp;&nbsp;
			   					</c:when>
			   					<c:otherwise>
			   						<a href="javascript:jump(${page.pageIndex+1},${page.pageSize});">下一页</a>&nbsp;&nbsp;
			   						<a href="javascript:jump(${page.totalPage},${page.pageSize});">末页</a>&nbsp;&nbsp;
			   					</c:otherwise>
			   	    </c:choose>
					</td>
					<td>跳转至<input type="text" style="width:30px" name="inputPage" id="goPage" value="${page.pageIndex}" />页
				             <button type="button" class="page-btn" onClick="jump(document.getElementById('goPage').value,${page.pageSize});">GO</button>
				    </td>
				    <td>每页显示<select onchange="jump(1,this.value);">
			   						<option value="5" <c:if test="${page.pageSize==5 }">selected</c:if>>5</option>
			   						<option value="6" <c:if test="${page.pageSize==6 }">selected</c:if>>6</option>
			   						<option value="7" <c:if test="${page.pageSize==7 }">selected</c:if>>7</option>
			   						<option value="8" <c:if test="${page.pageSize==8 }">selected</c:if>>8</option>
			   			       </select>
			        </td>
			    </tr>
            </table>


  <body>
  
  </body>
</html>
