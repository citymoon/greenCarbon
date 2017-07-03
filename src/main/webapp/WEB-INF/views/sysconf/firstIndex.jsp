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
	基本设置
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<form class="form form-horizontal" id="sysform">
		<input type="hidden" id="rowId" name="rowId" value="${oaConfigTab.rowId }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				系统名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="sysName" name="sysName" placeholder="控制在50个字、100个字节以内" value="${sysCompName }" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				系统WEB绝对路径：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="sysWebPath" name="sysWebPath" value="${oaConfigTab.sysWebPath }" placeholder="5个左右,8汉字以内,用英文,隔开" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				系统上传相对路径：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="sysUploadPath" name="sysUploadPath" value="${oaConfigTab.sysUploadPath }" placeholder="空制在80个汉字，160个字符以内" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				管理员邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="webMasterMail" name="webMasterMail" value="${oaConfigTab.webMasterMail }" placeholder="默认为空，为相对路径" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				邮件服务器：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="mailServerIp" name="mailServerIp" value="${oaConfigTab.mailServerIp }" placeholder="默认为uploadfile" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				系统访问URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="sysUrl" name="sysUrl" value="${oaConfigTab.sysUrl }" placeholder="&copy; 2016 H-ui.net" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"></label>
			<div class="col-xs-8 col-sm-9">
				<p>
				说明： <br> OA系统WEB物理目录为本系统所在的实际路径。 <br>
				文件上传的相对目录是指本系统中的上传文件所存放的目录，必须是从OA系统WEB物理路径开始的目录，且文件上传的相对目录必须以“/”开头。<br>
				系统访问的URL为本系统的访问路径。
				</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit" id="conSub"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button class="btn btn-default radius" type="reset">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<!--普通弹出层-->
<div id="callBackDialog" class="modal fade middle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius">
			<div class="modal-header">
				<h3 class="modal-title">提交结果</h3>
				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
			</div>
			<div class="modal-body">
				<p>提交成功！</p>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button>
			</div>
		</div>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<%@ include file="/_footer.html" %>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('#conSub').click(function(){
        $.ajax({
            type:'POST',
            datatype:'text',
            url:"<%=ctxpath%>/sysconf/update",
            data : $("#sysform").serialize(),
            //contentType:"application/x-www-form-urlencoded",
            success : function() {
            	$("#callBackDialog").modal("show");
            }
        })
    });
	//表单验证
	$("#sysform").validate({
		rules:{
			sysName:{
				required:true,
				maxlength:100
			},
			sysWebPath:{
				required:true,
				minlength:4,
				maxlength:200
			},
			sysUploadPath:{
				required:true,
				minlength:4,
				maxlength:200
			},
			webMasterMail:{
				required:true,	
				email:true
			},
			mailServerIp:{
				required:true
			},
			sysUrl:{
				required:true
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$("#modal-shenqing-success").modal("show");
			$(form).ajaxSubmit();
		}
	});
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>