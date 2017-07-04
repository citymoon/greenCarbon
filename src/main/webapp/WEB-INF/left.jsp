<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<c:forEach var="map" items="${model.modules}">
		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe681;</i> ${map.key.mdNewName }
				<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
				<c:forEach var="module" items="${map.value}">
					<li>
					   <a data-href="${ctx}/${module.mdUrl}" data-title="${module.mdName }"
						href="javascript:void(0)"><i class="Hui-iconfont">&#xe6a1;</i>${module.mdName }</a></li>
				</c:forEach>
				</ul>
			</dd>
		</dl>
		</c:forEach>
	</div>
	<div class="menu_dropdown bk_2" style="display:none">
		<dl id="menu-aaaaa">
			<dt><i class="Hui-iconfont">&#xe616;</i> 二级导航1<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${ctx}/getAllModuleForKey/conf" data-title="模块配置" href="javascript:void(0)">模块配置</a></li>
				</ul>
			</dd>
		</dl>
	</div>

	<div class="menu_dropdown bk_2" style="display:none">
		<dl id="menu-bbbbb">
			<dt><i class="Hui-iconfont">&#xe616;</i> 二级导航2<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">三级导航</a></li>
				</ul>
			</dd>
		</dl>
	</div>

	<div class="menu_dropdown bk_2" style="display:none">
		<dl id="menu-ccccc">
			<dt><i class="Hui-iconfont">&#xe616;</i> 二级导航3<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">三级导航</a></li>
				</ul>
			</dd>
		</dl>
	</div>

</aside>