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
	                         以下列出可以配置的所有模块，后面方框内打“√”的为已经配置的模块。选好需要的模块后，点击“配置完成”按钮即完成配置。 想改变模块的显示顺序，请点击“上移”和“下移”按钮。 若要增加系统内或系统外的模块，请点击“增加模块”按钮。
	        </p>
	    </div>
	</div>
	<table class="table table-border table-bordered table-bg" id="mainTable">
	    <thead class="text-c">
	        <tr>
	            <th width="10%">选择</th>
	            <th width="20%">模块名称</th>
	            <th width="20%">模块原名</th>
	            <th width="20%">模块编码</th>
	            <th width="20%">内/外部模块</th>
	            <th width="20%">是否配置</th>
	        </tr>
	    </thead>
	    <tbody class="text-c">
	    <c:forEach var="map" items="${model.modules}" varStatus="status">
		    <tr>
		        <td><input type="radio" value="${map.key.rowId }" name="rowId" id="rowId"><label>${status.index + 1}</label></td>
		        <td>${map.key.mdNewName }</td>
		        <td>${map.key.mdName }</td>
		        <td>${map.key.mdCode }</td>
		        <td>
		          <c:choose>
				    <c:when test="${map.key.intranetFlag == '1'}">
				      <c:out value="内部模块"></c:out>
				    </c:when>
				    <c:otherwise>  
				      <c:out value="外部模块"></c:out>
				    </c:otherwise>
				  </c:choose>
		        </td>
		        <td>
		        <input type="checkbox" name="selectedFlag" value="${map.key.selectedFlag }" 
                  <c:choose>
                    <c:when test="${map.key.selectedFlag == '1'}">
                      <c:out value="checked='checked'"></c:out>
                    </c:when>
                    <c:otherwise>  
                      <c:out value=""></c:out>
                    </c:otherwise>
                  </c:choose>
                  >
                </td>
		    </tr>
		    <c:forEach var="module" items="${map.value}" varStatus="status2">
		    <tr>
		        <td>&nbsp;&nbsp;<input type="radio" value="${module.rowId }" name="rowId" id="rowId"><label>${status.index + 1}.${status2.index + 1}</label></td>
		        <td>${module.mdNewName }</td>
		        <td>${module.mdName }</td>
		        <td>${module.mdCode }</td>
                <td>
                  <c:choose>
                    <c:when test="${module.intranetFlag == '1'}">
                      <c:out value="内部模块"></c:out>
                    </c:when>
                    <c:otherwise>  
                      <c:out value="外部模块"></c:out>
                    </c:otherwise>
                  </c:choose>
                </td>
                <td>
                  <input type="checkbox" name="selectedFlag" value="${module.selectedFlag }" 
                  <c:choose>
                    <c:when test="${module.selectedFlag == '1'}">
                      <c:out value="checked='checked'"></c:out>
                    </c:when>
                    <c:otherwise>  
                      <c:out value=""></c:out>
                    </c:otherwise>
                  </c:choose>
                  >
                </td>
		    </tr>
		    </c:forEach>
		</c:forEach>
	    </tbody>
	</table>
    <div class="row cl mt-10">
        <div class="col-xs-8 col-sm-9 col-xs-offset-5 col-sm-offset-5">
            <a href="#"><button class="btn btn-primary radius" id="up"><i class="fa fa-arrow-circle-up"></i>上移</button></a>
            <a href="#"><button class="btn btn-primary radius" id="down"><i class="fa fa-arrow-circle-down"></i>下移</button></a>
            <a href="${ctx}/module/getAllModuleForKey/reConfig"><button class="btn btn-primary radius"><i class="fa fa-plus-circle"></i>增加</button></a>
            <a href="${ctx}/module/getAllModuleForKey/reConfig"><button class="btn btn-primary radius"><i class="fa fa-pencil-square"></i>修改</button></a>
            <a href="${ctx}/module/getAllModuleForKey/reConfig"><button class="btn btn-primary radius"><i class="fa fa-minus-circle"></i>删除</button></a>
            <a href="${ctx}/module/getAllModuleForKey/reConfig"><button class="btn btn-primary radius"><i class="fa fa-wrench"></i>完成</button></a>
            <a href="${ctx}/module/getAllModuleForKey/reConfig"><button class="btn btn-primary radius"><i class="fa fa-reply"></i>返回</button></a>
        </div>
    </div>
</div>
 
<!--_footer 页面公共js脚本引入-->
<%@ include file="/footer.jsp" %>

<!--开始页面业务相关的脚本-->
<script type="text/javascript">
$(document).ready(function () {
	
	$("#up").click(function(){
		var selected = $('input:radio[name="rowId"]:checked').val();
		if(selected == null) {
            alert("没有选中项");
            return false;
        } else {
        	$.ajax({
                type:'POST',
                datatype:'json',
                //url:"<%=ctxpath%>/module/moveup",
                url:"<%=ctxpath%>/module/moveupjson",
                //data : $("#sysform").serialize(),
                data : "rowId="+selected,
                //contentType:"application/x-www-form-urlencoded",
                success : function(data) {
                    //alert('保存成功！',{icon: 6});
                    $('#mainTable').find('tbody').remove();
                    if(data != null){
                    	var i=0;
                    	var trs="";
                    	var rowid="",result="";
                    	$.each(data,function(name,value) {
                    		if(name == "rowid" && value != null)
                    			rowid = value;
                    		if(name == "result" && value != null)
                    			result = value;
                    	});
                        $.each(result,function(name,value) {
                        	i++;
                        	var keyString = name.split(',');
                        	var moveselectflag = '';
                        	if(keyString[0] == rowid)
                        		moveselectflag = 'checked="checked"';
                        	var checkedflag = 'checked="checked"';
                        	if(keyString[4] == 0)
                        		checkedflag = '';
                        	var intranetflag = '内部模块';
                        	if(keyString[4] == '0')
                        		intranetflag = '外部模块';
                        	trs += '<tr>';
                            trs += '<td><input type="radio" value="'+keyString[0]+'" name="rowId" id="rowId" '+moveselectflag+'><label>'+i+'</label></td>';
                            trs += '<td>'+keyString[1]+'</td>'
                            trs += '<td>'+keyString[2]+'</td>'
                            trs += '<td>'+keyString[3]+'</td>'
                            trs += '<td>'+intranetflag+'</td>'
                            trs += '<td><input type="checkbox" name="selectedFlag" value="'+keyString[5]+'" '+checkedflag+'></td>'
                            trs += '</tr>'
                            if(value.length>0){
                            	var j=0;
                            	$.each(value,function(key,valueson) {
                            		j++;
                            		moveselectflag = '';
                            		if(valueson.rowId == rowid)
                                        moveselectflag = 'checked="checked"';
                                    if(valueson.selectedFlag == 0)
                                        checkedflag = '';
                                    if(valueson.intranetFlag == '0')
                                        intranetflag = '外部模块';
                                    trs += '<tr>';
                                    trs += '<td><input type="radio" value="'+valueson.rowId+'" name="rowId" id="rowId" '+moveselectflag+'><label>'+i+'.'+j+'</label></td>';
                                    trs += '<td>'+valueson.mdNewName+'</td>'
                                    trs += '<td>'+valueson.mdName+'</td>'
                                    trs += '<td>'+valueson.mdCode+'</td>'
                                    trs += '<td>'+intranetflag+'</td>'
                                    trs += '<td><input type="checkbox" name="selectedFlag" value="'+valueson.selectedFlag+'" '+checkedflag+'></td>'
                                    trs += '</tr>'
                            	});
                            }
                        });
                        $("#mainTable").append(trs);
                    }
                },
                error : function(){
                	alert('操作失败！',error);
                }
            });
        }
	});
	$("#down").click(function(){
		
	});
});
</script>
</body>
</html>