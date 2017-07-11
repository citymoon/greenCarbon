<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/commonhead.jsp"%>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
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
	        <a href="${ctx}/module/getAllModuleForKey/reConfig"><button class="btn btn-primary radius"><i class="Hui-iconfont">&#xe632;</i>重新配置</button></a>
	    </div>
	</div>
</div>
<!--_footer 页面公共js脚本引入-->
<%@ include file="/footer.jsp" %>

<!--开始页面业务相关的脚本-->
<script type="text/javascript">

</script>
</body>
</html>