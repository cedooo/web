var clazzDialog;
$(function() {
	var cliWidth = $(document).width();
	/* 类型选择--对话框 */
	var $clazzSelectWindow = $("#clazzSelectWindow");
	$clazzSelectWindow.kendoWindow({
		width : "30%",
		minHeight : "10%",
		maxHeight : "40%",
		position : {
			top : 0,
			left : parseInt(cliWidth * 0.4)
		},
		resizable : false,
		actions : ["Close"],
		pinned : true,
		visible : false,
		draggable : true,
		modal : false
	});
	clazzDialog = $clazzSelectWindow.data("kendoWindow");

	/* 类型选择--树 */
	var homogeneous = new kendo.data.HierarchicalDataSource({
		transport : {
			read : {
				url : basePath + "search/childsNode.action",
				dataType : "json"
			}
		},
		schema : {
			data : function(response) {
				var childs = response.listChilds;
				var dataSoc = [];
				for ( var c in childs) {
					var node = {
						text : childs[c].name,
						imageUrl : childs[c].img,
						id : childs[c].nodeID
					};
					dataSoc.push(node);
				}
				return dataSoc;
			}
		}
	});
	homogeneous.add({
		text : webInfo.name,
		imageUrl : basePath + "images/website-2.png",
		id : $("#sNodeID").val()
	});
	$("#treeSelect").kendoTreeView(
			{
				select : function(e) {
					var dataItem = this.dataItem(e.node);
					// console.log("Selected node with id=" + dataItem.id);
					$("#treeSelect").next("div").html(dataItem.text).data(
							"nodeId", dataItem.id).attr("class", "k-block");
				},
				dataSource : homogeneous
			});
	$("#sureClazzSelected").click(function() {
		var name = $("#treeSelect").next("div").html();
		var id = $("#treeSelect").next("div").data("nodeId");
		if (id == -1) {
			$(".showSelectTree").prev("input").val(0);
		} else {
			$(".showSelectTree").prev("input").val(id);
		}
		$(".showSelectTree").next("span").html(name).attr("class", "k-block");
		clazzDialog.close();
	});

	$(".showSelectTree").kendoButton({
		icon : "arrow-s"
	});
	// 关键字选择
	$("#keyWordsSelect").kendoMultiSelect().data("keyWordsSelect");
});

function showSelectTree() {
	clazzDialog.title("目录").center().open();
}