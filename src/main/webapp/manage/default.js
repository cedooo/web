var clazzDialog;
$(function(){
	var cliHeight =  $(document).height();
	var cliWidth =  $(document).width();
	$("#addContentPartForm").hide();
	
	 $("#tabstrip").kendoTabStrip({
         animation:  {
             open: {
                 effects: "fadeIn"
             }
         }
     });
	
	/*$("#manageWindow")
	.css({
		"height":cliHeight+"px",
		"width":"35%"
	});*/
	$("#manageWindow .manaTag span")
		.css({
			"margin-top": cliHeight*0.06 + "px",
			"margin-left":"-" + 0.005*cliWidth+"px"
		});
   kendo.init($("#manageWindow"));
   $("input[id$='-picker'], .color-picker").each(function(){$(this).data("kendoColorPicker");});
   $("#menu-manage").kendoMenu({
       dataSource: [
           {
               text: "添加" 
           },
           {
               text: "删除"
           },
           {
               text: "修改"
           },
           {
               text: "查询"
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
    	   case "注销":
    		   window.location.href=webInfo.basePath;
    		   break;
    		default :
    			//alert(selected);
    	   }
       }
   });
   $(".eqSlider#font-size").kendoSlider({
       increaseButtonTitle: "Right",
       decreaseButtonTitle: "Left",
       min: 8,
       max: 16,
       smallStep: 1,
       largeStep: 2,
       showButtons: false
   }).data("kendoSlider");
   $(".eqSlider#r").kendoSlider({
       increaseButtonTitle: "Right",
       decreaseButtonTitle: "Left",
       min: 30,
       max: 90,
       smallStep: 5,
       largeStep: 10,
       showButtons: false
   }).data("kendoSlider");
   $(".eqSlider#stroke-width").kendoSlider({
       increaseButtonTitle: "Right",
       decreaseButtonTitle: "Left",
       min: 0,
       max: 4,
       smallStep: 1,
       largeStep: 2,
       showButtons: false
   }).data("kendoSlider");
   $(".eqSlider#img-width").kendoSlider({
       increaseButtonTitle: "Right",
       decreaseButtonTitle: "Left",
       min: 16,
       max: 64,
       smallStep: 8,
       largeStep: 16,
       showButtons: false
   }).data("kendoSlider");
   $(".eqSlider#img-height").kendoSlider({
       increaseButtonTitle: "Right",
       decreaseButtonTitle: "Left",
       min: 16,
       max: 64,
       smallStep: 8,
       largeStep: 16,
       showButtons: false
   }).data("kendoSlider");
   $("input.eqSlider").parents("div.eqSlider.k-slider").css({
	  "margin-bottom" : "6%",
	  "font-size" : "50%"
   })
   .next()
   .css({
	   "float" : "left",
	   "margin-right" : "3%",
	   "margin-top" : "2%",
	   "vertical-align" : "sub"
   });
   /*类型选择--树*/
   var homogeneous = new kendo.data.HierarchicalDataSource({
       transport: {
           read: {
               url:  webInfo.basePath + "search/childsNode.action",
               dataType: "json"
           }
       },
       schema: {
    	    data: function(response) {
    	    	var childs = response.listChilds;
	        	var dataSoc = [];
	        	for(var c in childs){
	        		var node = {
	        				text : childs[c].name,
	        				imageUrl:  childs[c].img,
	        				id:childs[c].nodeID
	        		};
	        		dataSoc.push(node);
	        	}
	        	return dataSoc;
    	    }
       }
   });
   homogeneous.add({
	   text:webInfo.name, 
	   imageUrl: webInfo.basePath + "images/website-2.png", 
	   id: $("#sNodeID").val()
   });
   $("#treeSelect").kendoTreeView({
	   select: function(e){
		   var dataItem = this.dataItem(e.node);
		   //console.log("Selected node with id=" + dataItem.id);
		   $("#treeSelect").next("div")
		   .html(dataItem.text)
		   .data("nodeId", dataItem.id)
		   .attr("class","k-block");
	    },
        dataSource: homogeneous
   });
   $("#sureClazzSelected").click(function(){
	   var name = $("#treeSelect").next("div").html();
	   var id = $("#treeSelect").next("div").data("nodeId");
	   //alert(name + ",id = " + id);
	   if(id==-1){
		   $(".showSelectTree").prev("input").val(0);
	   }else{
		   $(".showSelectTree").prev("input").val(id);
	   }
	   //$("#sNodeID").val(id);
	   $(".showSelectTree").next("span").html(name).attr("class","k-block");
	   clazzDialog.close();
   });
   var $clazzSelectWindow = $("#clazzSelectWindow");
   $clazzSelectWindow.kendoWindow({
	    width: "30%",
	    minHeight: "10%",
	    maxHeight: "40%",
	    position:{top: 0, left:parseInt(cliWidth*0.4)},
	    resizable: false,
	    actions: [
	        "Close"
	    ],
	    pinned: true,
	    visible: false,
	    draggable: true,
	    modal: false
	});
   clazzDialog = $clazzSelectWindow.data("kendoWindow");
});
function showSelectTree(){
	clazzDialog
	.title("目录")
    .center()
    .open();
}