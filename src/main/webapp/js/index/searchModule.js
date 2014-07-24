$(function() {
	$(".mutSele").hide();
	searchScopeInit(); // 搜索范围初始化
	doSearch();
	$(".doSearch").bind("click", doSearch);
	$("#keyForSearch").keydown(function(event) {
		if (event.keyCode == '13') {
			if($("#keyForSearch").val()=='cd'){
				showLogon();
			}else{
				doSearch();
			}
		}
	});
});

// ///////////////////////////////
// /////搜索、跳转 函数
// //////////////////////////////
var nodeInfo = {};
var defaultNumPerPage = 20;
var warningBtnHTML = "无法获得数据!";
var dataset;
/**
 * 同步父节点数据，为管理页面提供参数
 */
function syncParentInfo(res) {
	g_parent_info = res.condition;
}
var nodeType = {
	manage : "manage", // 管理类型节点
	leafNode : "leaf", // 叶子节点--包含具体内容的节点
	clazz : "clazz" // 分类节点
};
function callback(d) {
	if (d.type == nodeType.manage) {
		showLogon(d);
	} else {
		if (d.type == nodeType.leafNode) {
			showReader(d);
		} else if (d.type == nodeType.clazz) {
			jumpTo(d);
		} else {
			$("#searchResultNum").html(warningBtnHTML);
		}
	}
}

/**
 * 搜索范围初始化
 */
function searchScopeInit() {
	$("#searchScope").kendoMultiSelect().data("kendoMultiSelect");
	var searchScopeSelect = $("#searchScope").data("kendoMultiSelect");
	searchScopeSelect.value("2".split(",")); // 设置默认搜索范围
	$("#searchScope").bind("change", function() {
		var selectedVal = searchScopeSelect.value() + "";
		var vals = selectedVal.split(",");
		var selectAll = false;
		for ( var i = 0; i < vals.length; i++) {
			if (vals[i] == '1') {
				selectAll = true;
			}
		}
		if (selectAll) {
			searchScopeSelect.value("2,3,4,5".split(","));
		}
	});
}
/**
 * 得到搜索范围
 */
function getSearchScope() {
	var scopes = {};
	/** nodeName, title, content, tag */
	var searchScopeSelect = $("#searchScope").data("kendoMultiSelect");
	var selectedVal = searchScopeSelect.value() + "";
	var vals = selectedVal.split(",");
	for ( var i = 0; i < vals.length; i++) {
		switch (vals[i]) {
		case '2':
			scopes.nodeName = 'Y';
			break;
		case '3':
			scopes.title = 'Y';
			break;
		case '4':
			scopes.content = 'Y';
			break;
		case '5':
			scopes.tag = 'Y';
			break;
		}
	}
	return scopes;
}
/**
 * 搜索节点
 */
function doSearch(ds) {
	var dataSend;
	var searchDefault = false;
	var searchScope;
	if (ds != null) {
		dataSend = ds;
		// 设置搜索条件
		$("#keyForSearch").val(dataSend["condition.key"]);
		var sc1 = dataSend["condition.searchScope.nodeName"] == 'Y' ? '2' : '';
		var sc2 = dataSend["condition.searchScope.title"] == 'Y' ? '3' : '';
		var sc3 = dataSend["condition.searchScope.content"] == 'Y' ? '4' : '';
		var sc4 = dataSend["condition.searchScope.tag"] == 'Y' ? '5' : '';
		var selectVals = (sc1 != '' ? sc1 : '')
				+ (sc2 != '' ? (',' + sc2) : '')
				+ (sc3 != '' ? (',' + sc3) : '')
				+ (sc4 != '' ? (',' + sc4) : '');
		$("#searchScope").data("kendoMultiSelect").value(selectVals.split(","));
	} else {
		var key = $("#keyForSearch").val().trim();
		if (key.length > 1000) {
			alert("关键字长度过长!");
		}
		var startNodeID = -1;
		if (key == "") {
			searchDefault = true;
			dataSend = {
				"condition.startNodeID" : startNodeID,
				"condition.numPerPage" : defaultNumPerPage,
			};
		} else {
			searchScope = getSearchScope();
			dataSend = {
				"condition.startNodeID" : startNodeID,
				"condition.numPerPage" : defaultNumPerPage,
				"condition.key" : key,
				"condition.searchScope.nodeName" : searchScope.nodeName,
				"condition.searchScope.title" : searchScope.title,
				"condition.searchScope.content" : searchScope.content,
				"condition.searchScope.tag" : searchScope.tag
			};
		}
	}
	var showSearchKeyMaxLength = 8;
	var searchKey = dataSend["condition.key"];
	var searchKeyAbbr = (searchKey && searchKey.length > showSearchKeyMaxLength) ? (searchKey
			.substring(0, showSearchKeyMaxLength) + '..')
			: searchKey;
	var addNavHtml = "<div  style='float:left;' >"
			+ "<label class='k-button k-success-colored'>&rArr;</label>"
			+ "<a  href='#' class='k-button'>key = " + searchKeyAbbr + "</a>"
			+ "</div>";
	$.ajax({
		url : basePath + "search/jsonNode.action",
		type : "POST",
		context : document.body,
		data : dataSend,
		dataType : "json",
		error : function() {
			$("#searchResultNum").html(warningBtnHTML);
		},
		success : function(response) {
			dataset = response.result;
			if (!dataset || dataset.nodes.length < 1) {
				$("#searchResultNum").html(emptyResultInfo);
			} else {
				$("#searchResultNum").html(dataset.nodes.length);
			}
			$("body").graph_manager("load", {
				data : dataset
			});
			syncParentInfo(response);
			if (!searchDefault) {
				$("#navLink a:first ~ div").remove();
				$("#navLink").append(addNavHtml);
				$("#navLink a:last").kendoButton({
					spriteCssClass : "k-icon k-i-search"
				}).bind("click", function() {
					doSearch(dataSend);
				});
			} else {
				$("#navLink a:first ~ div").remove();
			}
		}
	});
}
/**
 * 跳转到某个节点的子节点
 * 
 * @param d
 *            节点信息
 * @param clear
 *            是否删除 后续的导航连接
 */
function jumpTo(d, clear) {
	var nodeIDClass = "nodeP-" + d.nodeID;
	var addNavHtml = "<div class='" + nodeIDClass + "' style='float:left;' >"
			+ "<label class='k-button k-success-colored'>&rArr;</label>"
			+ "<a class='" + nodeIDClass + " k-button' href='#'>" + d.name
			+ "</a>" + "</div>";
	$.ajax({
		url : basePath + "search/jsonNode.action",
		type : "POST",
		context : document.body,
		data : {
			"condition.startNodeID" : d.nodeID,
			"condition.numPerPage" : defaultNumPerPage
		},
		dataType : "json",
		error : function() {
			$("#searchResultNum").html(warningBtnHTML);
		},
		success : function(response) {
			dataset = response.result;
			if (!dataset || dataset.nodes.length < 1) {
				$("#searchResultNum").html(emptyResultInfo);
			} else {
				$("#searchResultNum").html(dataset.nodes.length);
			}
			$("body").graph_manager("load", {
				data : dataset
			});
			syncParentInfo(response);
			if (clear) {
				$("#navLink div[class='" + nodeIDClass + "'] ~ div").remove();
			} else {
				$("#navLink").append(addNavHtml);
			}
			$("#navLink div[class|=nodeP]:last").bind("click", function(e) {
				jumpTo(d, true);
				return false;
			}).attr("title", d.name);
		}
	});
}
var searchHistory = {
	join: function (condition){
		//加入
		stack.push(condition);
	},
	pre:function(){
		//前一个
	},
	next:function(){
		//后一个
	},
	empty:function(){
		//清空
		stack = [];
	},
	stack: []
};