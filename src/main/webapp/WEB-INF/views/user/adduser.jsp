<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function add(){
        document.addform.action="${ctx}/user/adduser";
        document.addform.submit();
    }
    function retu(){
        document.addform.action="${ctx}/user/getall";
        document.addform.submit();
    }
</script>
</head>
<body>
    <form name="addform" method="post">
        <table>
            <tr><td>姓名</td><td><input type="text" name="name" value=""></td></tr>
            <tr><td>账号</td><td><input type="text" name="account" value=""></td></tr>
            <tr><td>密码</td><td><input type="text" name="passwd" value=""></td></tr>
            <tr><td>住址</td><td><input type="text" name="address" value=""></td></tr>
            <tr><td>备注</td><td><input type="text" name="mem" value=""></td></tr>
            <tr>
	            <td><input type="button" value="ok" onclick="add()"></td>
	            <td><input type="button" value="cancel" onclick="retu()"></td>
            </tr>
        </table>
    </form>
</body>
</html>