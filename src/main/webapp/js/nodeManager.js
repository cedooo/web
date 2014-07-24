/**
 * 删除节点
 * @param node
 */
function delNode(node){
	if(node.type=='clazz'||node.type=='leaf'){
		var actionURL = basePath;
		if(node.type=='clazz'){
			actionURL += 'manage/clazz/delete.action';
		}else if(node.type=='leaf'){
			actionURL += 'manage/content/delete.action';
		}else{
			alert('内容出错了');
			return ;
		}
		$.ajax({
			url: actionURL,
			type: "POST",
			context: document.body,
			data:{
				id: node.nodeID
			},
			dataType : "json",
	        error:function(){
	        	alert('删除出错了');
	        },
			success: function(response){
				alert(response.doResult.info);	
				/*var identify_pre = {
						node : "node_",
						Info : "node_info_",
						edge : "edge_identify_"
					};*/
				var options = {
						type: "node_",
						ids:[node.nodeID]
					};
				$("body").graph_manager("delEle", options);
			}
		});
	}else{
		alert("删除节点(id='" + node.nodeID + "')传入的参数错误");
	}
}