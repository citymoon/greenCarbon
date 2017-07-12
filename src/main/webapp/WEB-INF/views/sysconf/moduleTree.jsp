<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/commonhead.jsp"%>
<link href="${ctx}/resources/css/plugins/jsTree/style.min.css" rel="stylesheet">
    <style>
        .jstree-open > .jstree-anchor > .fa-folder:before {
            content: "\f07c";
        }

        .jstree-default .jstree-icon.none {
            width: 0;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
	   <div class="col-sm-4">
	    <div class="ibox float-e-margins">
	       <div class="ibox-content">
	        <div id="jstree1">
	            <ul>
	                <li class="jstree-open">H+主题
	                    <ul>
	                        <li>css
	                            <ul>
	                                <li data-jstree='{"type":"css"}'>animate.css</li>
	                                <li data-jstree='{"type":"css"}'>bootstrap.css</li>
	                                <li data-jstree='{"type":"css"}'>style.css</li>
	                            </ul>
	                        </li>
	                        <li>email-templates
	                            <ul>
	                                <li data-jstree='{"type":"html"}'>action.html</li>
	                                <li data-jstree='{"type":"html"}'>alert.html</li>
	                                <li data-jstree='{"type":"html"}'>billing.html</li>
	                            </ul>
	                        </li>
	                        <li>fonts
	                            <ul>
	                                <li data-jstree='{"type":"svg"}'>glyphicons-halflings-regular.eot</li>
	                                <li data-jstree='{"type":"svg"}'>glyphicons-halflings-regular.svg</li>
	                                <li data-jstree='{"type":"svg"}'>glyphicons-halflings-regular.ttf</li>
	                                <li data-jstree='{"type":"svg"}'>glyphicons-halflings-regular.woff</li>
	                            </ul>
	                        </li>
	                        <li class="jstree-open">img
	                            <ul>
	                                <li data-jstree='{"type":"img"}'>profile_small.jpg</li>
	                                <li data-jstree='{"type":"img"}'>angular_logo.png</li>
	                                <li class="text-navy" data-jstree='{"type":"img"}'>html_logo.png</li>
	                                <li class="text-navy" data-jstree='{"type":"img"}'>mvc_logo.png</li>
	                            </ul>
	                        </li>
	                        <li class="jstree-open">js
	                            <ul>
	                                <li data-jstree='{"type":"js"}'>hplus.js</li>
	                                <li data-jstree='{"type":"js"}'>bootstrap.js</li>
	                                <li data-jstree='{"type":"js"}'>jquery-2.1.1.js</li>
	                                <li data-jstree='{"type":"js"}'>jquery-ui.custom.min.js</li>
	                                <li class="text-navy" data-jstree='{"type":"js"}'>jquery-ui-1.10.4.min.js</li>
	                            </ul>
	                        </li>
	                        <li data-jstree='{"type":"js"}'>affix.html</li>
	                        <li data-jstree='{"type":"html"}'>dashboard.html</li>
	                        <li data-jstree='{"type":"html"}'>buttons.html</li>
	                        <li data-jstree='{"type":"html"}'>calendar.html</li>
	                        <li data-jstree='{"type":"html"}'>contacts.html</li>
	                        <li data-jstree='{"type":"html"}'>css_animation.html</li>
	                        <li class="text-navy" data-jstree='{"type":"html"}'>flot_chart.html</li>
	                        <li class="text-navy" data-jstree='{"type":"html"}'>google_maps.html</li>
	                        <li data-jstree='{"type":"html"}'>icons.html</li>
	                        <li data-jstree='{"type":"html"}'>inboice.html</li>
	                        <li data-jstree='{"type":"html"}'>login.html</li>
	                        <li data-jstree='{"type":"html"}'>mailbox.html</li>
	                        <li data-jstree='{"type":"html"}'>profile.html</li>
	                        <li class="text-navy" data-jstree='{"type":"html"}'>register.html</li>
	                        <li data-jstree='{"type":"html"}'>timeline.html</li>
	                        <li data-jstree='{"type":"html"}'>video.html</li>
	                        <li data-jstree='{"type":"html"}'>widgets.html</li>
	                    </ul>
	                </li>
	            </ul>
	        </div>
	       </div>
	    </div>
	   </div>
	    
		<div class="col-sm-8">
	        <div class="ibox float-e-margins">
	           <div class="ibox-content">
                   <form class="form-horizontal m-t" id="commentForm">
                     <div class="form-group">
                       <label class="col-sm-2 control-label">内外模块标志</label>
                       <div class="col-sm-8">
	                       <div class="radio i-checks">
	                           <label>
	                               <input type="radio" value="option1" name="a" checked="checke " >内部模块</label>
	                           <label>
	                               <input type="radio" value="option2" name="a">外部模块</label>
	                       </div>
                       </div>
                     </div>
                     <div class="form-group">
                       <label class="col-sm-2 control-label">模块层次标志</label>
                       <div class="col-sm-8">
	                       <div class="radio i-checks">
	                           <label>
	                               <input type="radio" value="option1" name="a" checked="checked " >一级模块</label>
	                           <label>
	                               <input type="radio" value="option2" name="a">二级模块</label>
	                           <label>
	                               <input type="radio" value="option2" name="a">三级模块</label>
	                       </div>
                       </div>
                     </div>
                     <div class="form-group">
                       <label class="col-sm-2 control-label">所属父级模块</label>
                       <div class="col-sm-8">
                                    <select class="form-control m-b" name="account">
                                        <option>选项 1</option>
                                        <option>选项 2</option>
                                        <option>选项 3</option>
                                        <option>选项 4</option>
                                    </select>
                                    <select class="form-control m-b" name="account">
                                        <option>选项 1</option>
                                        <option>选项 2</option>
                                        <option>选项 3</option>
                                        <option>选项 4</option>
                                    </select>
                                    <select class="form-control m-b" name="account">
                                        <option>选项 1</option>
                                        <option>选项 2</option>
                                        <option>选项 3</option>
                                        <option>选项 4</option>
                                    </select>
                       </div>
                     </div>
                     <div class="form-group">
                           <label class="col-sm-2 control-label">模块名称：</label>
                           <div class="col-sm-8">
                               <input id="cname" name="name" minlength="2" type="text" class="form-control" required="" aria-required="true">
                           </div>
                     </div>
                     <div class="form-group">
                           <label class="col-sm-2 control-label">模块地址：</label>
                           <div class="col-sm-8">
                               <input id="cemail" type="email" class="form-control" name="email" required="" aria-required="true">
                           </div>
                     </div>
                     <div class="form-group">
                           <label class="col-sm-2 control-label">模块编码：</label>
                           <div class="col-sm-8">
                               <input id="curl" type="url" class="form-control" name="url">
                           </div>
                     </div>
                     <div class="form-group">
                           <label class="col-sm-2 control-label"></label>
                           <div class="col-sm-8">
                              <p>说明：<br>链接地址是指所要增加的内部模块或外部模块指向的初始文件路径。<br> 
						                                        链接地址是相对于系统URL的文件路径。<br>
						                                        如果一级模块没有子模块，请输入链接地址。</p>
                           </div>
                     </div>
                     <div class="form-group">
                           <div class="col-sm-4 col-sm-offset-3">
                               <button class="btn btn-primary" type="submit">提交</button>
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
<script src="${ctx}/resources/js/plugins/jsTree/jstree.min.js"></script>

<!--开始页面业务相关的脚本-->
<script type="text/javascript">
$(document).ready(function () {
    $('#jstree1').jstree({
        'core': {
            'check_callback': true,
            'contextmenu': true
        },
        'plugins': ['types', 'dnd'],
        'types': {
            'default': {
                'icon': 'fa fa-folder'
            },
            'html': {
                'icon': 'fa fa-file-code-o'
            },
            'svg': {
                'icon': 'fa fa-file-picture-o'
            },
            'css': {
                'icon': 'fa fa-file-code-o'
            },
            'img': {
                'icon': 'fa fa-file-image-o'
            },
            'js': {
                'icon': 'fa fa-file-text-o'
            }

        }
    });
    $('#jstree1').on("changed.jstree", function (e, data) {
    	
        console.log("The selected nodes are:");
        console.log(data.selected);
        console.log(data.instance.get_selected(true));
        console.log(data.instance.get_node(data.selected[0]).text);
      });
});
</script>
</body>
</html>