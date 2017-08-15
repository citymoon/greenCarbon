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
		              <div class="form-group">
                         <label class="col-sm-2 control-label"><span class="c-red">*</span>内外模块标志：</label>
                         <div class="col-sm-10">
				             <input type="text" id="sysName" name="sysName" placeholder="控制在50个字、100个字节以内" value="${sysCompName }" class="form-control">
                         </div>
                      </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							模块层次标志：</label>
						<div class="col-sm-10">
							<input type="text" id="sysWebPath" name="sysWebPath" value="${oaConfigTab.sysWebPath }" placeholder="5个左右,8汉字以内,用英文,隔开" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							所属一级模块：</label>
						<div class="col-sm-10">
							<input type="text" id="sysUploadPath" name="sysUploadPath" value="${oaConfigTab.sysUploadPath }" placeholder="空制在80个汉字，160个字符以内" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							模块名称：</label>
						<div class="col-sm-10">
							<input type="text" id="webMasterMail" name="webMasterMail" value="${oaConfigTab.webMasterMail }" placeholder="默认为空，为相对路径" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							模块编码：</label>
						<div class="col-sm-10">
							<input type="text" id="mailServerIp" name="mailServerIp" value="${oaConfigTab.mailServerIp }" placeholder="默认为uploadfile" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							链接地址：</label>
						<div class="col-sm-10">
							<input type="text" id="sysUrl" name="sysUrl" value="${oaConfigTab.sysUrl }" placeholder="&copy; 2016 H-ui.net" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<p>
							说明： <br>
							链接地址是指所要增加的内部模块或外部模块指向的初始文件路径。  <br>
                                                                                    链接地址是相对于系统URL的文件路径。  <br>
                                                                                     如果一级模块没有子模块，请输入链接地址。 <br>
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

<!--引入页面插件相关的脚本-->
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${ctx}/resources/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/demo/layer-demo.js"></script>

<!--开始页面业务相关的脚本-->
<script type="text/javascript">
$(document).ready(function () {
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