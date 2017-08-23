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
           	        <form method="post" class="form-horizontal" id="moduleform">
		              <div class="form-group">
                         <label class="col-sm-2 control-label"><span class="c-red">*</span>内外模块标志：</label>
                         <div class="col-sm-10">
                            <label><input type="radio" value="1" id="intranetFlag1" name="intranetFlag" checked="checked">内部模块</label>
                            <label><input type="radio" value="0" id="intranetFlag2" name="intranetFlag">外部模块</label>
                         </div>
                      </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							模块层次标志：</label>
						<div class="col-sm-10">
                            <label><input type="radio" value="1" id="moduleLevel1" name="moduleLevel">一级模块</label>
                            <label><input type="radio" value="2" id="moduleLevel2" name="moduleLevel" checked="checked">二级模块</label>
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							所属一级模块：</label>
						<div class="col-sm-10">
							<select class="form-control m-b" name="firstModule" id="firstModule">
                                <option value="0">请选择所属一级模块</option>
                                <c:forEach var="map" items="${model.firstModules}">
	                                <c:forEach var="module" items="${map.value}">
	                                   <option value="${module.rowId }">${module.mdNewName }</option>
	                                </c:forEach>
                                </c:forEach>
                            </select>
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							模块名称：</label>
						<div class="col-sm-10">
							<input type="text" id="mdNewName" name="mdNewName" value="" placeholder="输入模块的中文名字" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							模块编码：</label>
						<div class="col-sm-10">
							<input type="text" id="mdCode" name="mdCode" value="" placeholder="输入模块编码" class="form-control">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="c-red">*</span>
							链接地址：</label>
						<div class="col-sm-10">
							<input type="text" id="mdUrl" name="mdUrl" value="" placeholder="输入模块的链接地址" class="form-control">
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
<script src="${ctx}/resources/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/resources/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/resources/js/demo/form-validate-demo.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/demo/layer-demo.js"></script>

<!--开始页面业务相关的脚本-->
<script type="text/javascript">
$(document).ready(function () {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$('#conSub').click(function(){
		//alert($("#moduleform").validate().errorList.length);
		//非空和长度判断
		if($.trim($('#mdNewName').val()).length<=0 || $.trim($('#domain_name').val()).length>100){
			return false;
		}
		if($.trim($('#mdCode').val()).length<=0 || $.trim($('#mdCode').val()).length>50){
		   return false;
		}
        if($.trim($('#mdUrl').val()).length<=0){
            return false;
        }
        //内部模块，二级模块，但未选择所属一级模块
		if($("input[name='moduleLevel']:checked").val()==2 && $("input[name='intranetFlag']:checked").val()==1 && $('#firstModule').val()==0){
			parent.layer.alert('选择了二级模块，但未选择"所属一级模块"！',{icon: 0});
			return false;
		};
		//***submit()提交
		//$('#moduleform').attr("action","<%=ctxpath%>/module/addmoduleok");
		//$('#moduleform').submit();
		
		//***ajax提交
		$.ajax({
               type:'POST',
               datatype:'text',
               async:false,
               cache:false,
               url:"<%=ctxpath%>/module/addmoduleok",
               data : $("#moduleform").serialize(),
               success : function(data) {
               	if(data.status == "repeat"){
               		if(data.params.intranetFlag == 1){
               			$("#intranetFlag1").attr("checked","checked");
               		}else{
               			$("#intranetFlag2").attr("checked","checked");
               		}
               		if(data.params.parentRowid == 1){
               			$('#moduleLevel1').attr("checked","checked");
               			$('#firstModule').attr("disabled","disabled");
               		}else{
               			//$('#moduleLevel1').removeAttr("checked");
               			$('#moduleLevel2').attr("checked","checked");
               			$("#firstModule option[value='"+data.params.parentRowid+"']").attr("selected","selected");
               		}
               		$('#mdNewName').attr('value',data.params.mdNewName);
               		$('#mdCode').attr('value',data.params.mdCode);
               		$('#mdNewName').attr('value',data.params.mdUrl);
               		parent.layer.alert('模块信息重复！',{icon: 0});
               	}else if(data.status == "success"){
               	    parent.layer.alert('保存成功！',{icon: 1});
               	}
               },
               error : function(){
                   parent.layer.alert('保存失败！',{icon: 2});
               }
           });
    });
    $("input[name='intranetFlag']").bind("click",function(){
    	var selectedvalue = $(this).val();  
        if (selectedvalue == 1) {   
            //内部模块，可以激活模块级别和所属一级模块
        	$("input[name='moduleLevel']").removeAttr("disabled");
            $('#moduleLevel1').attr("checked","checked");
        	$('#moduleLevel2').removeAttr("checked");
            $('#firstModule').attr("disabled","disabled");
        }  
        else if (selectedvalue == 0) {  
            //外部模块，不需要选择模块级别和所属一级模块，需要屏蔽
            $("input[name='moduleLevel']").attr("disabled","disabled");
            $('#firstModule').attr("disabled","disabled");
        }else{
        	parent.layer.alert('您还没有选择内/外部模块！',{icon: 1});
        }
    });
    $("input[name='moduleLevel']").bind("click",function(){
    	var selectedvalue = $(this).val();  
        if (selectedvalue == 1) {   
            //一级模块被选中，屏蔽掉所属二级模块
            $('#firstModule').attr("disabled","disabled");
        }  
        else if (selectedvalue == 2) {  
            //二级模块被选中，激活所属一级模块
            $('#firstModule').removeAttr("disabled");
        }else{
            parent.layer.alert('您还没有配置任何模块！',{icon: 1});
        }
    });
	/*表单验证*/
	$("#moduleform").validate({
		rules:{
			mdNewName:{
				required:true,
				maxlength:100
			},
			mdCode:{
				required:true,
				maxlength:50
			},
			mdUrl:{
				required:true,
			}
		},
		messages: {
			mdNewName: {
                required: icon + "请输入模块名称",
                maxlength: icon + "模块名称不能大于20个字"
            },
            mdCode: {
                required: icon + "请输入模块编码",
                maxlength: icon + "模块编码不能大于20位"
            },
            mdUrl: {
                required: icon + "请输入模块的URL地址",
            }
        }
	});
});
</script>
<!--/结束页面业务相关的脚本-->
</body>
</html>