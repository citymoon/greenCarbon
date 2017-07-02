<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function upd(){
        document.updform.action="${ctx}/user/update";
        document.updform.submit();
    }
    function retu(){
        document.updform.action="${ctx}/user/getall";
        document.updform.submit();
    }
</script>
</head>
<body>
    <form name="updform" method="post">
    <input type="hidden" name="id" value="${user.userId}">
        <table>
            <tr><td>姓名</td><td><input type="text" name="name" value="${user.userName}"></td></tr>
            <tr><td>账号</td><td><input type="text" name="account" value="${user.account}"></td></tr>
            <tr><td>密码</td><td><input type="text" name="passwd" value="${user.password}"></td></tr>
            <tr>
	            <td><input type="button" value="ok" onclick="upd()"></td>
	            <td><input type="button" value="cancel" onclick="retu()"></td>
            </tr>
        </table>
    </form>
</body>
</html>