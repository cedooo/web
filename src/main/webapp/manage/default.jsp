<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/";
	String[] styles = {"black","blueopal", "default", "flat","metro", 
			"metroblack", "silver", "uniform", "black", "bootstrap",
			"moonlight"};
	int styleNum = 2;//(int)(Math.random()*styles.length);
	String styleName = styles[styleNum];
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html"  xmlns:wb="http://open.weibo.com/wb">
<head>
    <base href="<%=basePath%>">
    <meta name="description" content="个人webapp">
    <meta name="author" content="cd">
    <meta name="keywords" content="blog, webapp, resume, HTML5, CSS3, d3js, kendoui,  style, modern, css, framework">
	<link rel="shortcut icon" href="<%=basePath %>images/website-2.png" >

    <script type="text/javascript" src="<%=basePath %>js/jquery-1.10.2.min.js"></script>
    
    <script type="text/javascript" src="<%=basePath %>js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/localization/messages_zh.js"></script>
    
    
    <link href="<%=basePath %>kendoui-web/styles/kendo.common.min.css" rel="stylesheet">
    <link href="<%=basePath %>kendoui-web/styles/kendo.rtl.min.css" rel="stylesheet">
    <link href="<%=basePath %>kendoui-web/styles/kendo.<%=styleName %>.min.css" rel="stylesheet">
    
	<script type="text/javascript" src="<%=basePath %>kendoui-web/js/kendo.window.min.js"></script>
	<script src="<%=basePath %>kendoui-web/js/kendo.web.min.js"></script>
	<script src="<%=basePath %>kendoui-web/console.js"></script>
	
	<link href="<%=basePath %>manage/default.css" rel="stylesheet"> 
	<script type="text/javascript">
		var webInfo={
				name:"JustSoSo",
				basePath: "<%=basePath %>"
		};
		$("html").ready(function(){
			$("html>head>title").html(webInfo.name);
		});
	</script>
	<script type="text/javascript">
		
	</script>
	
	<script type="text/javascript" src="<%=basePath %>manage/default.js"></script>	
    <title></title>
</head>
<body>
	<!-- 目录选择-->
	<div id="clazzSelectWindow">
		<div id="treeSelect" class="clazztree"></div>
		<div></div>
		<div>
		    <input type="button" id="sureClazzSelected" class="k-button" value="确定" ><br />
		    <input type="button" class="k-button" onclick="clazzDialog.close();" value="取消">
	    </div>
	</div>
		<div id="forecast">
                <div id="tabstrip">
                    <ul>
                        <li class="k-state-active">分类</li>
                        <li>文章</li>
                        <li>关键字</li>
                        <li>
                            Moscow
                        </li>
                        <li>
                            Sydney
                        </li>
                    </ul>
                    <div>
                       <div id="manageWindow">
							<div >
								<ul id="menu-manage"></ul>
							</div>
							<br />
							<div class="k-blcok">
						        <form id="addForm" action="<%=basePath %>manage/clazz/add.action" method="post">
						            <fieldset>
										<legend>分类</legend>
										<%-- <input id="nodeTypeID" name="node.nodeTypeID" type="text" readonly value="<%=application.getAttribute("clazzNodeTypeID") %>"  /> --%>
										<table>
											<tr>
												<td>
													<input id="sNodeID" name="parentID" type="hidden" readonly value="-1"  />
													<a class="k-button showSelectTree" onclick="showSelectTree()">位&nbsp;&nbsp;置*</a>	
													<span></span>
												</td>
											</tr>
											<tr>
												<td>
													<label for="clazzName">分类名称*</label>  
													<input id="clazzName" name="node.nodeName" type="text"  placeholder="2-10字">
												</td>
											</tr>
											<tr>
												<td>
													<label for="clazzDescription">分类描述*</label>  
													<input id="clazzDescription" name="node.nodeDescription" type="text" placeholder="30字以内">
												</td>
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
												<td>
													<label for="img">图片位置*</label>  
													<input id="img" name="nodeStyle.img" type="text"  placeholder="http://..">
												</td>
											</tr>
											<tr>
												<td>
													<label for="fill-picker">填充</label>  
											        <input type="color" id="fill-picker" class="color-picker" name="nodeStyle.fillColor" value="#ff0000" data-role="colorpicker">
													<label for="stroke-picker">边框</label>  
											      	<input type="color" id="stroke-picker" class="color-picker" name="nodeStyle.strokeColor" value="#00ff22" data-role="colorpicker">
													<label for="font-picker">文字</label>  
											        <input type="color" id="font-picker" class="color-picker" name="nodeStyle.fontColor" value="#fff700" data-role="colorpicker">
												</td>
											</tr>
								        
											<tr>
												<td>
											            <input id="font-size" class="eqSlider" value="10" name="nodeStyle.fontSize" />
												        <label for="font-size">字体大小</label> 
												</td>
											</tr>
											<tr>
												<td>
										            <input id="r" class="eqSlider" value="50" name="nodeStyle.r" />
											        <label for="r">半径长度</label> 
												</td>
											</tr>
											<tr>
												<td>
										            <input id="stroke-width" class="eqSlider" value="1" name="nodeStyle.strokeWeight"/>
										            <label for="stroke-width">边框宽度</label>
												</td>
											</tr>
											<tr>
												<td>
										            <input id="img-width" class="eqSlider" value="48" name="nodeStyle.imgWidth"/>
										            <label for="img-width">图片宽度</label>
												</td>
											</tr>
											<tr>
												<td>
										            <input id="img-height" class="eqSlider" value="48" name="nodeStyle.imgHeight"/>
										            <label for="img-height">图片高度</label> 
												</td>
											</tr>
					                    </table>
					                	<input type="submit" class="k-button" value="保存">
					                	<input type="reset" class="k-button" value="重置">
						            </fieldset>
						        </form>
						        
					        </div>
						</div>
                    </div>
                    <div>
                        <div class="weather">
                            <h2>29<span>&ordm;C</span></h2>
                            <p>Sunny weather in New York.</p>
                        </div>
                        <span class="sunny">&nbsp;</span>
                    </div>
                    <div>
                        <div class="weather">
                            <h2>21<span>&ordm;C</span></h2>
                            <p>Sunny weather in London.</p>
                        </div>
                        <span class="sunny">&nbsp;</span>
                    </div>
                    <div>
                        <div class="weather">
                            <h2>16<span>&ordm;C</span></h2>
                            <p>Cloudy weather in Moscow.</p>
                        </div>
                        <span class="cloudy">&nbsp;</span>
                    </div>
                    <div>
                        <div class="weather">
                            <h2>17<span>&ordm;C</span></h2>
                            <p>Rainy weather in Sydney.</p>
                        </div>
                        <span class="rainy">&nbsp;</span>
                    </div>
                </div>
            </div>
	

</html>