<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/commonhead.jsp"%>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span>
    系统管理
    <span class="c-gray en">&gt;</span>
    模块配置
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<div class="row cl mt-10">
	    <label class="form-label col-xs-1 col-sm-1"></label>
	    <div class="col-xs-8 col-sm-9 text-l c-black">
	        <p>
	                         以下是本系统的模块配置情况，您可以点击“重新配置”按钮重新配置系统模块。
	        </p>
	    </div>
	</div>
	<table class="table table-border table-bordered table-bg">
	    <thead class="text-c">
	        <tr>
	            <th width="10%">顺序号</th>
	            <th width="20%">模块名称</th>
	            <th width="20%">模块原名</th>
	            <th width="20%">模块编码</th>
	        </tr>
	    </thead>
	    <tbody class="text-c">
	    <c:forEach var="map" items="${model.modules}" varStatus="status">
		    <tr>
		        <td><label>${status.index + 1}</label></td>
		        <td>${map.key.mdNewName }</td>
		        <td>${map.key.mdName }</td>
		        <td>${map.key.mdCode }</td>
		    </tr>
		    <c:forEach var="module" items="${map.value}" varStatus="status2">
		    <tr>
		        <td>&nbsp;&nbsp;<label>${status.index + 1}.${status2.index + 1}</label></td>
		        <td>${module.mdNewName }</td>
		        <td>${module.mdName }</td>
		        <td>${module.mdCode }</td>
		    </tr>
		    </c:forEach>
		</c:forEach>
	    </tbody>
	</table>
	<div class="row cl mt-10">
	    <div class="col-xs-8 col-sm-9 col-xs-offset-5 col-sm-offset-5">
	        <button class="btn btn-primary radius" type="submit" id="conSub"><i class="Hui-iconfont">&#xe632;</i>保存</button>
	        <button class="btn btn-default radius" type="reset">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
	    </div>
	</div>
</div>

<!--_footer 页面公共js脚本引入-->
<%@ include file="/_footer.html" %>

<!--开始页面业务相关的脚本-->
<script type="text/javascript">
$(function(){
    $('#conSub').click(function(){
        $.ajax({
            type:'POST',
            datatype:'text',
            url:"<%=ctxpath%>/sysconf/update",
            data : $("#conForm").serialize(),
            //contentType:"application/x-www-form-urlencoded",
            success : function() {
                alert('ok');
            }
        })
    });
    
});
</script>
</body>
</html>