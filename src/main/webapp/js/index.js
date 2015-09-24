var logonPaddingLeftPercent = 80;    //登陆框离左边框距离
var contentPaddingLeftPercent = 30;    //内容离左边框距离
var logonOperPaddingLeftPercent = 95;    //登陆成功后操作离左边框距离
/**
 * 初始化
 */
$("html").ready(function(){
	$("html>head>title").html(webInfo.name);
});
var contentDialog,editerDialog;
$(function(){
	//SVG初始化
	var cliHeight =  $(document).height();
	var cliWidth =  $(document).width();
	$("body").graph_manager({
		width:screen.width,   //宽度
		height:cliHeight-5,    //高度
		scaleScope: [0,150],    //比例尺范围
		bigCoef: 1.3,    //缩放比例 
		callback: callback,    //点击节点时的回调函数
		delNodeFn: delNode,    //删除节点函数
		showEditNodeDialog: showEditNodeDialog,    //显示节点编辑对话框
		charge: -1300,
		linkDistance: 200
	});
	var $window = $("#contentWindow");
	$window.kendoWindow({
	    width: "66%",
	    height: "80%",
	    //maxHeight: "100%",
	    resizable: false,
	    actions: [
	        "Refresh",
	        "Maximize",
	        "Close"
	    ],
	    pinned: true,
	    visible: false,
	    draggable: false,
	    modal: true,
	});

	contentDialog = $window.data("kendoWindow");

	var $editer = $("#contentEditerWindow");
	$editer.kendoWindow({
	    width: "66%",
	    height: "85%",
	    //minHeight: "80%",
	    maxHeight: "100%",
	    resizable: false,
	    actions: [
	        "Maximize",
	        "Close"
	    ],
	    pinned: true,
	    visible: false,
	    draggable: false,
	    modal: true,
	});
	$(".contentEditor").hide();
	editerDialog = $editer.data("kendoWindow");

	$("#conditionContain #conTag").bind('click', function(){
		$(".mutSele").slideToggle();
		if($(this).hasClass("dis")){
			$(this).removeClass("dis");
			$("#conditionContain #conTag > span").toggleClass("k-i-arrow-s",true);
			$("#conditionContain #conTag > span").toggleClass("k-i-arrow-n",false);
		}else{
			$(this).addClass("dis");
			$("#conditionContain #conTag  > span").toggleClass("k-i-arrow-n",true);
			$("#conditionContain #conTag > span").toggleClass("k-i-arrow-s",false);
		}
	});
	
	//管理弹框
	$("#manageWindow")
		.css({
			"height":cliHeight+"px",
			"width":"25%"
		});
	$("#manageWindow .manaTag span")
		.css({
			"margin-top": cliHeight*0.06 + "px",
			"margin-left":"-" + 0.005*cliWidth+"px"
		});
	$("#manageWindow .manaTag").bind('click', function(){
		if($(this).hasClass("dis")){
			$(this).removeClass("dis");
			hideManage();
		}else{
			$(this).addClass("dis");
			showManage();
		}
	});
	$("#manageWindow").hide();
   //颜色选择
   kendo.init($("#manageWindow"));
   kendo.init($("#nodeEditWindow"));
   $("input[id$='-picker'], .color-picker").each(function(){$(this).data("kendoColorPicker");});
   $("#menu-manage").kendoMenu({
       dataSource: [
           /*{
               text: "添加" ,
               items: [
                   { text: "分类" },
                   { text: "文章"  },
                   { text: "关键词"  }
               ]
           },
           {
               text: "弹出"
           },*/
           {
               text: "注销"
           }
       ],
       select: function(e){
    	   console.log(e);
    	   var selected = e.item.textContent;
    	   switch(selected){
    	   case "分类":
    		   $("#addContentPartForm").hide();
    	   		break;
    	   case "文章":
    		   $("#addContentPartForm").show();
    		   break;
    	   case "关键词": 
    		   break;
    	   case "弹出":
    		   gotoManagePage();
    		   break;
    	   case "注销":
    		   logout();
    		   break;
    		default :
    			//alert(selected);
    	   }
       }
   });

   var sliderOption = {   //控件 数值范围设置
	  "font_size" : {
	       increaseButtonTitle: "Right",
	       decreaseButtonTitle: "Left",
	       min: 8,
	       max: 20,
	       smallStep: 1,
	       largeStep: 2,
	       showButtons: false
	   },
	   "r":{
	       increaseButtonTitle: "Right",
	       decreaseButtonTitle: "Left",
	       min: 30,
	       max: 90,
	       smallStep: 5,
	       largeStep: 10,
	       showButtons: false
	   },
	   "stroke-width":{
	       increaseButtonTitle: "Right",
	       decreaseButtonTitle: "Left",
	       min: 0,
	       max: 8,
	       smallStep: 1,
	       largeStep: 2,
	       showButtons: false
	   },
	   "img-width":{
	       increaseButtonTitle: "Right",
	       decreaseButtonTitle: "Left",
	       min: 16,
	       max: 80,
	       smallStep: 8,
	       largeStep: 16,
	       showButtons: false
	   },
	   "img-height":{
	       increaseButtonTitle: "Right",
	       decreaseButtonTitle: "Left",
	       min: 16,
	       max: 80,
	       smallStep: 8,
	       largeStep: 16,
	       showButtons: false
	   }
   };
   
   
   $(".eqSlider#font-size, .eqSlider#e_font-size").kendoSlider(sliderOption["font_size"]).data("kendoSlider");
   $(".eqSlider#r,.eqSlider#e_r").kendoSlider(sliderOption["r"]).data("kendoSlider");
   $(".eqSlider#stroke-width, .eqSlider#e_stroke-width").kendoSlider(sliderOption["stroke-width"]).data("kendoSlider");
   $(".eqSlider#img-width,.eqSlider#e_img-width").kendoSlider(sliderOption["img-width"]).data("kendoSlider");
   $(".eqSlider#img-height,.eqSlider#e_img-height").kendoSlider(sliderOption["img-height"]).data("kendoSlider");
   
   
   $("input.eqSlider").parents("div.eqSlider.k-slider").css({
	  "margin-bottom" : "6%",
	  "font-size" : "90%",
	  "float" : "right"
   })
   .next()
   .css({
	   "float" : "left",
	   "margin-right" : "3%",
	   "margin-top" : "2%",
	   "vertical-align" : "sub"
   });
   $("#editForm label,#nodeEditForm label").attr("class", "k-block k-info-colored");
   
   $(".contentEditor").kendoEditor({encoded: false}).data("kendoEditor");
   
   if(userInfo.logon == "true"){
	   	$("#manageWindow").show();
		//$("#manageWindow .manaTag").addClass("dis");;
		//showManage();
   }
   $(".k-button").kendoButton();
});


$(function(){    //表单可用性检验
	$("#editForm").validate({    //添加-表单
        rules: validationRules.nodeRules,
        submitHandler: function(form) {      
        	if($("#sNodeID").val()<0){
        		alert("请选择父节点");
        		showSelectTree();
        		return;
        	}
    		$.ajax({
    			url: $(form).attr("action"),
    			type: "POST",
    			context: document.body,
    			data:$(form).serialize(),
    			dataType : "json",
    	        error:function(){
    	        	alert('服务器错误');
    	        },
    			success: function(response){
    				if(response!='null'&&response.doResult.state=='1'){
    					var con = confirm(response.doResult.info);
    					if(con){
    						window.location.reload();
    					}
    				}else{
    					if(response.doResult.info){
							alert("操作失败:" + response.doResult.info);
    					}else{
							alert("操作失败!");
    					}
    					return false;
    				}
    			}
    		});		  
        } 
    });
	$("#nodeEditForm").validate({    //节点编辑-表单
        rules: validationRules.nodeRules,
        submitHandler: function(form) {     
    		$.ajax({
    			url: $(form).attr("action"),
    			type: "POST",
    			context: document.body,
    			data:$(form).serialize(),
    			dataType : "json",
    	        error:function(){
    	        	alert('服务器错误');
    	        },
    			success: function(response){
    				if(response!='null'&&response.doResult.state=='1'){
    					var con = confirm(response.doResult.info);
    					if(con){
    						window.location.reload();
    					}
    				}else{
    					if(response.doResult.info){
							alert("操作失败:" + response.doResult.info);
    					}else{
							alert("操作失败!");
    					}
    					return false;
    				}
    			}
    		});		  
        } 
    });  //表单可用性检验
	$("#contentEditerForm").validate({    //内容编辑-表单
        rules: validationRules.contentRules,
        submitHandler: function(form) {  
    		$.ajax({
    			url: $(form).attr("action"),
    			type: "POST",
    			context: document.body,
    			data:$(form).serialize(),
    			dataType : "json",
    	        error:function(){
    	        	alert('服务器错误');
    	        },
    			success: function(response){
    				if(response!='null'&&response.doResult.state=='1'){
    					alert(response.doResult.info);
    					window.location.reload();
    				}else{
    					if(response.doResult.info){
							alert("操作失败:" + response.doResult.info);
    					}else{
							alert("操作失败!");
    					}
    					return false;
    				}
    			}
    		});		  
        } 
    });
});
///////////////////////////
// 窗口 隐藏 显示 函数 
///////////////////////////

function reset(){
	hideReader();
	hideLogon();
	hideManage();
}
function hideReader(){
	$(".contentContainer").animate({left: "100%"});
}
function showReader(d){
	var nodeID = d.nodeID;
	reset();
	contentDialog.wrapper.find(".k-i-refresh").click(function(e){
		contentDialog.refresh({
			url: basePath+  "search/contentWithID.action?condition.nodeID=" + nodeID
		});
        e.preventDefault();
    });
	contentDialog
	.title(d.name)
	.refresh({
		url: basePath+  "search/contentWithID.action?condition.nodeID=" + nodeID,
		type: "POST"
	})
    .center()
    .open();
}

function showManage(){
	reset();
	$("#manageWindow").animate({left: "75%"});
	$("#manageWindow .manaTag > span").toggleClass("k-i-arrow-e",true);
	$("#manageWindow .manaTag > span").toggleClass("k-i-arrow-w",false);
}
function hideManage(){
	$("#manageWindow").animate({left: "99.9%"});
	$("#manageWindow .manaTag > span").toggleClass("k-i-arrow-e",false);
	$("#manageWindow .manaTag > span").toggleClass("k-i-arrow-w",true);

}
function showContextEditer(nodeID){
	if(nodeID>0){
		//根据节点ID，查询出内容信息.
		$.ajax({
			url: basePath + "manage/content/queryWithNodeID.action",
			type: "POST",
			context: document.body,
			data: {
				"id": nodeID
			},
			dataType : "json",
	        error:function(){
				alert('节点内容错误');
	        },
			success: function(response){
				if(response!=null&&response.doResult.state=='1'){
					var content = response.doResult.obj;
					var contentValid = !(content==null);
					$("#contentEditerForm input[name='recordContent.nodeID']").val(nodeID);   //设置节点的ID
					if(contentValid){
						$("#contentEditerForm").attr("action", basePath + "manage/content/modify.action");
						$("#contentEditerWindow input[name*='recordContent'],#contentEditerWindow textarea[name*='recordContent']")
						.each(function(){
							var nameAttr = $(this).attr("name");
							if(nameAttr){
								var name = nameAttr.split(".")[1];
								//alert(name);
								if(name=='content'){
				                    $("#contentEditor").data("kendoEditor").value(content[name]);
								}else {
									$(this).val(content[name]);
								}
							}else{
								//do nothing
							}
						});
						 $("#contentEditerWindow").data("kendoWindow")
							.title("修改内容").center().open();
					}else{
						$("#contentEditerForm").attr("action", basePath + "manage/content/add.action");
						//如果不存在，则提示新建。
						var confmNew= confirm('尚未添加内容，是否新建?');
						if(confmNew){
							$("#contentEditerForm")[0].reset();
							$("#contentEditor").data("kendoEditor").value('');
							 $("#contentEditerWindow").data("kendoWindow")
							.title("添加内容")
						    .center()
						    .open();
						}else{
							//do nothing
						}
					}
				}else{
					alert('返回值错误');
				}
			}
		});
	}else {
		alert('参数错误');
	}
}
function hideContextEditer(){
	editerDialog.close();
}
//返回根目录 
function r(){
	$('#keyForSearch').val('');
	doSearch();
}
/*
 * 显示编辑几点样式对话框
 * */
function showEditNodeDialog(node){
	if(node.nodeID>0){//得到节点信息
		$.ajax({
			url: basePath + "manage/queryNodeWithID.action",
			type: "POST",
			context: document.body,
			data: {
				"id": node.nodeID
			},
			dataType : "json",
	        error:function(){
				alert('节点内容错误');
	        },
			success: function(response){
				if(response!=null&&response.doResult.state=='1'){
					var node = response.doResult.obj;
					$("#nodeEditWindow input[name*='node']").each(function(){
						var name = $(this).attr("name").split(".")[1];
						if($(this).hasClass('color-picker')){
							var color = node[name];
				            try {
				                color = kendo.parseColor(color);
				                var colorpicker = $(this).data("kendoColorPicker");
				                colorpicker.value(color);
				            } catch(ex) {
				                alert('Cannot parse color: "' + color + '"');
				            }
						}else if($(this).hasClass('eqSlider')){
							var value = node[name];
		                    var slider = $(this).data("kendoSlider");
                            slider.value(value);
						}else{
							$(this).val(node[name]);
						}
					});
					if(node.type=='leaf'){
						$("#editerBtn").show();
					}else{
						$("#editerBtn").hide();
					}
					var window = $("#nodeEditWindow");
					if (!window.data("kendoWindow")) {
				         window.kendoWindow({
				            width: "40%",
				            height: "70%",
				            title: "编辑节点",
				     	    resizable: false,
				    	    actions: [
				    	        "Maximize",
				    	        "Close"
				    	    ],
				    	    pinned: true,
				    	    draggable: false,
				    	    modal: true,
				             close: function(){}
				         });
				     }
					$("#editerBtn").unbind().bind("click", function(){
						//编辑内容
						showContextEditer(node.nodeID);
					});
					window.data("kendoWindow").center().open();
				}else{
					alert("操作出错了！");
				}
			}
		});
	}
	//修改节点信息
	//保存节点信息
}
function hideNodeEditDialog(){
	 $("#nodeEditWindow").data("kendoWindow").close();
}
/**
 * 进入管理界面
 */
function gotoManagePage(){
	if(g_parent_info.key==""){
		window.location.href= basePath + 'manage/default?npnd=' + g_parent_info.startNodeID;
	}else{
		window.location.href= basePath + 'toAddPage.action?npnd=1';
	}
}