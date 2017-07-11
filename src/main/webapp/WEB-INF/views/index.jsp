<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/commonhead.jsp"%>
<script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h6 class="logo-name">EMP平台</h6>
        </div>
        <h3>欢迎使用 emp平台</h3>
        <form class="m-t" role="form" action="loginto" method="POST">
            <div class="form-group">
                <input id="" name="userId" value="${model.userId }" type="text" placeholder="账户" class="form-control">
            </div>
            <div class="form-group">
                <input id="" name="password" value="${model.password }" type="password" placeholder="密码" class="form-control">
            </div>
            <p class="text-muted text-center">${error }</p>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <!-- p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
            </p -->

        </form>
    </div>
</div>
</body>
</html>