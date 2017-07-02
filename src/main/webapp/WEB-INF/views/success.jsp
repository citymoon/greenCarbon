<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<%response.sendRedirect(ctxpath+"/module/moduleIndex");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>hello</title>
<script type="text/javascript">
    function addUser(){
        document.thisform.action="${ctx}/user/toadd";
        document.thisform.submit();
    }
    
    function searchUser(){
    	document.thisform.action="${ctx}/user/tosearch";
    	document.thisform.submit();
    }
</script>
</head>
<body>
    <form name="thisform">
    <table>
        <tr>
            <td><input type="button" value="add" onclick="addUser()"></td>
            <td><input type="button" value="del" onclick="batchDelUser()"></td>
            <td><input type="button" value="search" onclick="searchUser()"></td>
            <td></td>
        </tr>
        <tr>
        	<td>姓名</td>
        	<td><input type="text" name="uname" value=""></td>
        	<td>账号</td>
        	<td><input type="text" name="uaccount" value=""></td>
        </tr>
    </table>
    ${message}<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>账号</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
        <c:forEach var="user" items="${users}">
			<tr>
		        <td>${user.userId}</td>
		        <td>${user.userName}</td>
		        <td>${user.account}</td>
				<td>${user.password} </td>
		        <td><a href="${ctx}/user/toupdate?id=${user.userId}">edit</a>  <a href="${ctx}/user/delete?id=${user.userId}">delete</a></td>
			</tr>
        </c:forEach>
	</table>
	</form>
</body>
</html>