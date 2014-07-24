<%@ page pageEncoding="UTF-8" import="tk.cedoo.search.pojo.RecordContent,tk.cedoo.search.content.SearchContentResult"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <base href="<%=basePath%>">
    <meta name="description" content="个人">
    <meta name="author" content="陈东">
    <meta name="keywords" content="windows 8, modern style, Metro UI, style, modern, css, framework">
	<link rel="shortcut icon" href="<%=basePath %>images/website-2.png" >

    <script type="text/javascript" src="<%=basePath %>js/jquery-1.10.2.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$(".downloadUrl").bind("click", function(event){
				event.preventDefault();
				top.window.location.href='<s:property value="result.recordContent.downloadUrl" />';
			});
			$(".linkUrl").bind("click", function(event){
				event.preventDefault();
				top.window.location.href='<s:property value="result.recordContent.linkUrl" />';
			});
		});
	</script>
	<style type="text/css">
		body{
			font-size:0.9em;
			background: white;
			height:400px;
		}
		.imgLink{
			cursor:pointer;
			margin-top:10px;
		}
		img{
			vertical-align:bottom;
		}
		.titles{
			font-size:1.3em;
			font-weight:bold;
		}
		.subhead{
			font-size:1.0em;
			color: gray;
		}
		.generateTime{
			font-size:0.7em;
			color: gray;
			float:right;
			right:5%;
			padding-right:5%;
			bottom:1%;
		}
		#sepBottom{
			width:100%;
			float:right;
			padding-bottom:2%;
			position:fixed;
			bottom:0%;
			background:#ffffff;
		}
	</style>
    <title>内容浏览</title>
</head>
	<body>
		<div class="titles">${result.recordContent.title}</div>
		<div class="subhead">&emsp;&rArr;&nbsp;${result.recordContent.subhead}</div>
		<br />
		${result.recordContent.content}
<%-- 		<s:property value="result.recordContent.content" escapeHtml="false" /> 
 --%>		<br />
		&emsp;
		<div id="sepBottom">
			<c:if test="${! empty result.recordContent.linkUrl}">
				<img class="imgLink" alt="链接" title="更多" src="<%=basePath %>images/navImgWithD3/link-2.ico" width="16" height="16"/>
				<a class="linka linkUrl" href="#">${result.recordContent.linkUrl}</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${! empty result.recordContent.downloadUrl}">
				<img class="imgLink" alt="链接" title="下载" src="<%=basePath %>images/navImgWithD3/download.ico" width="16" height="16"/>
				<a class="linka downloadUrl" href="#">${result.recordContent.downloadUrl}</a>
			</c:if>
			<hr />
			<div class="generateTime" >
				<img  alt="时间" title="生成时间" src="<%=basePath %>images/common/time_simple.png" width="16" height="16"/>
				<%-- <s:property value="result.recordContent.addTime" /> --%>
				<%-- ${result.recordContent.addTime} --%>
				<fmt:formatDate value="${result.recordContent.addTime}"  pattern="yyyy-MM-dd HH:mm:ss"/>
			</div>
		</div>
			
	</body>
</html>