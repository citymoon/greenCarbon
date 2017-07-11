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
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
           	        <form method="get" class="form-horizontal" id="sysform">
		              <input type="hidden" id="rowId" name="rowId" value="${oaConfigTab.rowId }">
		              <div class="form-group">
                         <label class="col-sm-2 control-label"><span class="c-red">*</span>系统名称：</label>
                         <div class="col-sm-10">
				             <input type="text" id="sysName" name="sysName" placeholder="控制在50个字、100个字节以内" value="${sysCompName }" class="form-control">
                         </div>
                      </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							系统WEB绝对路径：</label>
						<div class="col-sm-10">
							<input type="text" id="sysWebPath" name="sysWebPath" value="${oaConfigTab.sysWebPath }" placeholder="5个左右,8汉字以内,用英文,隔开" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							系统上传相对路径：</label>
						<div class="col-sm-10">
							<input type="text" id="sysUploadPath" name="sysUploadPath" value="${oaConfigTab.sysUploadPath }" placeholder="空制在80个汉字，160个字符以内" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							管理员邮箱：</label>
						<div class="col-sm-10">
							<input type="text" id="webMasterMail" name="webMasterMail" value="${oaConfigTab.webMasterMail }" placeholder="默认为空，为相对路径" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							邮件服务器：</label>
						<div class="col-sm-10">
							<input type="text" id="mailServerIp" name="mailServerIp" value="${oaConfigTab.mailServerIp }" placeholder="默认为uploadfile" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							系统访问URL：</label>
						<div class="col-sm-10">
							<input type="text" id="sysUrl" name="sysUrl" value="${oaConfigTab.sysUrl }" placeholder="&copy; 2016 H-ui.net" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<p>
							说明： <br> OA系统WEB物理目录为本系统所在的实际路径。 <br>
							文件上传的相对目录是指本系统中的上传文件所存放的目录，必须是从OA系统WEB物理路径开始的目录，且文件上传的相对目录必须以“/”开头。<br>
							系统访问的URL为本系统的访问路径。
							</p>
						</div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-4 col-sm-offset-2">
			              <button class="btn btn-primary" type="submit" id="conSub">保存</button>
			              <button class="btn btn-white" type="reset">取消</button>
			            </div>
					  </div>
				  </form>
	           </div>
	       </div>
        </div>
    </div>
</div>
<!--_footer 页面公共js脚本引入-->
<%@ include file="/footer.jsp" %>

<!--开始页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/demo/layer-demo.js"></script>
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
            	parent.layer.alert('保存成功！',{icon: 6});
            }
        })
    });
	/*表单验证*/
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
<!--/结束页面业务相关的脚本-->
</body>
</html>