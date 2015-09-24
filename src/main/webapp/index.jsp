<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String[] styles = {"black", "blueopal", "default", "flat", "metro",
			"metroblack", "silver", "uniform", "black", "bootstrap",
			"moonlight"};
	int styleNum = 9;//(int)(Math.random()*styles.length);
	String styleName = styles[styleNum];
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html"
	xmlns:wb="http://open.weibo.com/wb">
<head>
<base href="<%=basePath%>">
<meta name="description" content="个人webapp">
<meta name="author" content="cd">
<meta name="keywords"
	content="blog, webapp, resume, HTML5, CSS3, d3js, kendoui">
<link rel="shortcut icon" href="<%=basePath%>images/eye.png">

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/localization/messages_zh.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/common/cedooValidationRules.js"></script>


<link href="<%=basePath%>kendoui-web/styles/kendo.common.min.css"
	rel="stylesheet">
<link href="<%=basePath%>kendoui-web/styles/kendo.rtl.min.css"
	rel="stylesheet">
<link
	href="<%=basePath%>kendoui-web/styles/kendo.<%=styleName%>.min.css"
	rel="stylesheet">

<script type="text/javascript"
	src="<%=basePath%>kendoui-web/js/kendo.window.min.js"></script>
<script src="<%=basePath%>kendoui-web/js/kendo.web.min.js"></script>
<script src="<%=basePath%>kendoui-web/console.js"></script>

<!-- SVG元素生产相关 -->
<script type="text/javascript" src="<%=basePath%>js/d3.v3.js"></script>
<link href="<%=basePath%>css/nodeWithD3.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/graph_manager.js"></script>
<script type="text/javascript" src="<%=basePath%>js/nodeManager.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/index/loginModule.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/index/clazzSelectModule.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/index/searchModule.js"></script>

<link href="<%=basePath%>css/index.css" rel="stylesheet">
<script type="text/javascript">
		var webInfo={
				name:"JustWrapper",
				basePath: "<%=basePath%>"
		};
		var userInfo = {
			logon: "<%=null == session.getAttribute("loginTime") ? false : true%>",
			loginTime:  '<s:property value="%{#session.loginTime}" />'
		};
		var basePath = "<%=basePath%>";
	var g_parent_info = {}; /* 例子 ："dept":-1,"key":"","nodeType":"","numPerPage":20,"page":1,"startNodeID":1*/
</script>

<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<title></title>
</head>
<body>
	<div class="searchBar k-content">
		<!-- 左侧搜索条 -->
		<div class="k-textbox k-space-right">
			<input id="keyForSearch" type="text" placeholder="key"> <a
				href="javascript:doSearch()" class="k-icon k-i-search"></a>
		</div>
		<div id="conditionContain" class="k-block" title="搜索范围设置">
			<div class="mutSele" style="display:none;">
				<select id="searchScope" multiple="multiple" data-placeholder="范围">
					<option value="1">全部</option>
					<option value="2">节点名称</option>
					<option value="3">标题</option>
					<option value="4">内容</option>
					<option value="5" disabled>标签</option>
				</select>
			</div>
			<div id="conTag">
				<span class="k-icon k-i-arrow-s"></span>
			</div>
		</div>

		<br />
		<div id="navLink">
			<a class="k-button" onclick="javascript:r();"> <img
				style="cursor:pointer;float:left;" alt="前一个搜索结果" width="20px"
				height="20px" src="images/common/root.png">
			</a>
		</div>
		<br> <br>
		<div id="resultNum">
			<%-- <span>&exist;</span> --%>
			<span title="结果个数" class="k-block k-success-colored k-space-left"
				id="searchResultNum"> &nbsp; </span>
		</div>
	</div>
	<div class="leftNav">
	<%--
		左侧菜单 
		<button class="k-button">
				<img  alt="前一个结果" src="images/navImgWithD3/prepage.ico">
		</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="k-button">
				<img  alt="后一个结果" src="images/navImgWithD3/nextpage.ico">
		</button>
		<button class="k-button">
				<img  title="后退" src="images/navImgWithD3/backup.ico">
		</button>-->
		<button class="k-button" disabled="disabled">传统版</button>
		<button class="k-button">装*版</button>
		 --%>
		<small>2014</small> 
		<img width="10" height="10" src="images/copyright.png" />
		<small>CeDo </small>
		<!-- 百度网站统计 -->
		<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F5eff0efe23047a1e9929ad9de6036e09' type='text/javascript'%3E%3C/script%3E"));
		</script>
	</div>
	<!-- ****************************以下为一些隐藏的"弹出框"**************************** -->
	<!-- 内容浏览 -->
	<div id="contentWindow"></div>
	<!-- 目录选择-->
	<div id="clazzSelectWindow">
		<div id="treeSelect" class="clazztree"></div>
		<div></div>
		<div>
			<input type="button" id="sureClazzSelected" class="k-button" value="确定"><br /> 
			<input type="button" class="k-button" onclick="clazzDialog.close();" value="取消">
		</div>
	</div>
	<!-- 管理 -->
	<div id="manageWindow" class="k-block">
		<div class="k-blcok">
			<ul id="menu-manage"></ul>
		</div>
		<br />
		<div class="k-blcok">
			<form id="editForm" action="<%=basePath%>manage/add.action"
				method="post">
				<label>添加</label> <input type="radio" checked id="typeClazz"
					name="addType" value="clazz" /><label for="typeClazz">分类</label> <input
					type="radio" id="typeContent" name="addType" value="leaf" /><label
					for="typeContent">内容</label>
				<hr>
				<fieldset>
					<legend>表单</legend>
					<table>
						<tr>
							<td><input id="sNodeID" name="link.sNodeID" type="hidden"
								value="-1"></input> <a class="k-button showSelectTree"
								onclick="showSelectTree()">所在位置*</a> <span></span></td>
						</tr>
						<tr>
							<td><label for="clazzName">分类名称*</label> <input
								id="clazzName" name="node.nodeName" type="text"
								placeholder="2-10字"></td>
						</tr>
						<tr>
							<td><label for="clazzDescription">分类描述*</label> <input
								id="clazzDescription" name="node.nodeDescription" type="text"
								placeholder="30字以内"></td>
						</tr>
						<%--
						<tr>
							<td>                                                   
				                <select id="keyWordsSelect" multiple="multiple" data-placeholder="选择关键字">
						            <option value="2" >java</option>
						            <option value="3" >servlet</option>
						            <option value="4" >jsp</option>
						            <option value="5" >tomcat</option>
						        </select>
							</td>
						</tr> 
						--%>
						<tr>
							<td><label for="img">图片位置*</label> <input id="img"
								name="nodeStyle.img" type="text" placeholder="http://..">
							</td>
						</tr>
						<tr>
							<td><label for="fill-picker">填充</label> <input type="color"
								id="fill-picker" class="color-picker" name="nodeStyle.fillColor"
								value="#ff0000" data-role="colorpicker"> <label
								for="stroke-picker">边框</label> <input type="color"
								id="stroke-picker" class="color-picker"
								name="nodeStyle.strokeColor" value="#00ff22"
								data-role="colorpicker"> <label for="font-picker">文字</label>
								<input type="color" id="font-picker" class="color-picker"
								name="nodeStyle.fontColor" value="#fff700"
								data-role="colorpicker"></td>
						</tr>

						<tr>
							<td><input id="font-size" class="eqSlider" value="10"
								name="nodeStyle.fontSize" /> <label for="font-size">字体大小</label>
							</td>
						</tr>
						<tr>
							<td><input id="r" class="eqSlider" value="55"
								name="nodeStyle.r" /> <label for="r">半径长度</label></td>
						</tr>
						<tr>
							<td><input id="stroke-width" class="eqSlider" value="2"
								name="nodeStyle.strokeWeight" /> <label for="stroke-width">边框宽度</label>
							</td>
						</tr>
						<tr>
							<td><input id="img-width" class="eqSlider" value="48"
								name="nodeStyle.imgWidth" /> <label for="img-width">图片宽度</label>
							</td>
						</tr>
						<tr>
							<td><input id="img-height" class="eqSlider" value="48"
								name="nodeStyle.imgHeight" /> <label for="img-height">图片高度</label>
							</td>
						</tr>
					</table>
					<input type="submit" class="k-button" value="添加"> <input
						type="reset" class="k-button" value="重置表单">
				</fieldset>
			</form>

		</div>
		<br />
		<div class="k-blcok" id="nodePreview"></div>
		<div class="k-block manaTag">
			<span class="k-icon k-i-arrow-w k-content"></span>
		</div>
	</div>
	<!-- 登陆框 -->
	<div class="k-block logonContainer k-content">
		<div class="k-header k-inset" style="text-align: center;">登&nbsp;&nbsp;陆</div>
		<form id="loginForm" action="<%=basePath%>manage/add.jsp"
			onsubmit="return logon();">
			<span class="k-textbox k-space-left"> <input type="text"
				id="user" placeholder="user" /> <img class="k-icon"
				src="<%=basePath%>images/common/user_88x93.ico" />
			</span> <br /> <span class="k-textbox k-space-left"> <input
				type="password" id="password" placeholder="key" /> <img
				class="k-icon" src="<%=basePath%>images/common/key_red.ico" />
			</span>
		</form>
		<img style="margin-left:10px;cursor:pointer;padding:0;" title="隐藏"
			width="24" height="24" onclick="hideLogon()"
			src="<%=basePath%>images/common/hide_48.ico" />
	</div>
	<!-- 节点编辑-->
	<div id="nodeEditWindow">
		<form id="nodeEditForm" action="<%=basePath%>manage/modifyNode.action"
			method="post">
			<table>
				<tr>
					<td><input name="node.nodeID" type="hidden" value='-1'
						readonly> <label for="e_clazzName">分类名称*</label> <input
						id="e_clazzName" name="node.name" type="text" placeholder="2-10字">
					</td>
				</tr>
				<tr>
					<td><label for="e_clazzDescription">分类描述*</label> <input
						id="e_clazzDescription" name="node.description" type="text"
						placeholder="30字以内"></td>
				</tr>
				<%--
						<tr>
							<td>                                                   
				                <select id="keyWordsSelect" multiple="multiple" data-placeholder="选择关键字">
						            <option value="2" >java</option>
						            <option value="3" >servlet</option>
						            <option value="4" >jsp</option>
						            <option value="5" >tomcat</option>
						        </select>
							</td>
						</tr> 
						--%>
				<tr>
					<td><label for="e_img">图片位置*</label> <input id="e_img"
						name="node.img" type="text" placeholder="http://.."></td>
				</tr>
				<tr>
					<td><label for="e_fill-picker">填充</label> <input type="color"
						id="e_fill-picker" class="color-picker" name="node.color"
						value="#ff0000" data-role="colorpicker"> <label
						for="e_stroke-picker">边框</label> <input type="color"
						id="e_stroke-picker" class="color-picker" name="node.stroke"
						value="#00ff22" data-role="colorpicker"> <label
						for="e_font-picker">文字</label> <input type="color"
						id="e_font-picker" class="color-picker" name="node.font_color"
						value="#fff700" data-role="colorpicker"></td>
				</tr>

				<tr>
					<td><input id="e_font-size" class="eqSlider" value="10"
						name="node.font_size" /> <label for="e_font-size">字体大小</label></td>
				</tr>
				<tr>
					<td><input id="e_r" class="eqSlider" value="55" name="node.r" />
						<label for="e_r">半径长度</label></td>
				</tr>
				<tr>
					<td><input id="e_stroke-width" class="eqSlider" value="1"
						name="node.strokewidth" /> <label for="e_stroke-width">边框宽度</label>
					</td>
				</tr>
				<tr>
					<td><input id="e_img-width" class="eqSlider" value="48"
						name="node.img_width" /> <label for="e_img-width">图片宽度</label></td>
				</tr>
				<tr>
					<td><input id="e_img-height" class="eqSlider" value="48"
						name="node.img_height" /> <label for="e_img-height">图片高度</label></td>
				</tr>
			</table>
			<a class="k-button" id="editerBtn">编辑内容</a> <input type="submit"
				class="k-button" value="保存" /> <input type="reset" class="k-button"
				value="清空表单" /> <input type="button" class="k-button"
				onclick="hideNodeEditDialog()" value="关闭" />
		</form>
	</div>
	<!-- 内容编辑-->
	<div id="contentEditerWindow">
		<form id="contentEditerForm"
			action="<%=basePath%>manage/content/add.action">
			<input type="hidden" name="recordContent.nodeID" value="-1" /> <input
				type="hidden" name="recordContent.recordID" value="-1" /> <input
				id="title" name="recordContent.title" type="text" placeholder="标题*">
			<input id="subhead" name="recordContent.subhead" type="text"
				placeholder="副标题*" /> <input type="text" name="recordContent.intro"
				placeholder="一句话说明*" />
			<textarea class="contentEditor" id="contentEditor"
				name="recordContent.content"></textarea>
			<input id="downloadUrl" class="eqSlider" value="" placeholder="下载URL"
				name="recordContent.downloadUrl" /> <input id="linkUrl"
				class="eqSlider" value="" placeholder="外联URL"
				name="recordContent.linkUrl" />
			<div style="float:right;margin-top:2%;">
				<input class="k-button" value="保存" type="submit" /> <a
					class="k-button" onclick="hideContextEditer()">取消</a>
			</div>
		</form>
	</div>
	<!-- ****************************以上为一些隐藏的"弹出框"**************************** -->
</body>
</html>