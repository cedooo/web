//cd
//cedoo.com

var emptyResultInfo = "0";    //结果为空 提示信息
(function($){
	/*'静态'变量*/
	var identify_pre = {
		node : "node_",
		Info : "node_info_",
		edge : "edge_identify_"
	};
	
	function loadGraph(data, container){	
		var $that = $(container); 
		var settings = $that.data("graph_manager");
		var svgCons = d3.select(container).select("svg");
		var force=d3.layout.force()
			.nodes(data.nodes)//加载节点数据
			.links(data.edges)//加载边数据
			.size([settings.width, settings.height])//设置有效空间的大小
			.linkDistance(settings.linkDistance)//连线的长度
			.charge(settings.charge);//负电荷量，相互排斥设置的负值越大越排斥
		//(3)连线
		var edges=svgCons.selectAll("line")
			.data(data.edges)
			.enter()
			.append("line")
			.style("stroke",function(d){//	设置线的颜色
				return d.color;
			})
			.style("stroke-width",function(d,i){//设置线的宽度
				return d.weight;
			});
		//(4) 创建节点‘容器’
		var nodesContainer = svgCons.selectAll(".node")
			.data(data.nodes)
			.enter()
			.append("g")
			//.filter(function(d){return d.type!='manage';})   // 隐藏'登陆'节点
			.attr("class", "nodeContainer" )
			.attr("index", function(d){
				return  identify_pre.node +  d.nodeID;					
			})
			.on("mouseout", function (){
				var d3Obj = d3.select(this);
				d3Obj.select("circle")
				.transition().duration(750)
				.attr("r", function(d){
					return d.r;
				});
				d3Obj.selectAll("image.nodeOper").style("display","none");
				d3Obj.select("text")
				.text(function(d){return d.name;});
			})
			.on("mouseover", function (){
				d3.select(this).select("circle")
				.transition()
				.duration(350)
				.attr("r", function(d){
					return d.r*settings.bigCoef;
				});		
				d3.select(this).select("text")
				.text(function(d){return d.description;});
				if(userInfo.logon=="true"){
					d3.select(this).selectAll("image.nodeOper").style("display","inline");
				}
			})
			.style("cursor","move");
		//(5) 加入节点圆
		var nodes = nodesContainer
			.append("circle")
			.attr("r",function(d){
				return d.r;
			})
			.style("fill",function(d){
				return d.color;
			})
			.style("stroke", function(d){
				return d.stroke;				
			})
			.style("stroke-width", function(d){
				return d.strokewidth;				
			})			
			.call(force.drag);//可以拖动
		nodes.append("svg:title")  
			.text(function(d) { return d.name; });
		//(6) 加入节点图片
		var nodeImg = nodesContainer.append("svg:image")  
			.attr("xlink:href",function(d){return d.img;})  
			.attr("width",function(d){return d.img_width;})  
			.attr("height", function(d){return d.img_height;})
			.on("click", function(d){
				changeAfterClick(d);				
			})			
			//.call(force.drag)
			.attr("class", "nodeImg")
			.style("cursor","pointer");
		//节点编辑按钮
		var nodeEditBtn = nodesContainer
		//.filter(function(d){return d.type=='clazz'||d.type=='leaf';})
		.append("svg:image")  
		.attr("xlink:href",function(d){return "images/common/edit.ico";})  
		.attr("width",function(d){return "16";})  
		.attr("height", function(d){return "16";})
		.on("click", function(d){
			if(d.type =='clazz'|| d.type == 'leaf' || d.type == 'manage'){
				settings.showEditNodeDialog(d);
			}else{
				alert("节点数据错误");
				//do nothing
			}
		})			
		//.call(force.drag)
		.attr("class", "nodeOper")
		.style("cursor","pointer")
		.style("display","none");
		nodeEditBtn.append("svg:title").text("编辑");
		//节点删除按钮
		var nodeDelBtn = nodesContainer
		.filter(function(d){return d.type=='clazz'||d.type=='leaf';})
		.append("svg:image")  
		.attr("xlink:href",function(d){return "images/common/delete_cir.ico";})  
		.attr("width",function(d){return "16";})  
		.attr("height", function(d){return "16";})
		.on("click", function(d){
			var cofirmed = confirm("确认删除该节点?");		
			if(cofirmed){
				settings.delNodeFn(d);		
			}
		})			
		//.call(force.drag)
		.attr("class", "nodeOper")
		.style("cursor","pointer")
		.style("display","none");
		nodeDelBtn.append("svg:title").text("删除");
		//(7) 加入节点内容
		var texts = nodesContainer.append("text")  
			.text(function(d) { return d.name; })
			.attr("class", "nodeText")
			.attr({
				"font-size": function(d){
					return d.font_size + "px";
				},
				"fill": function(d){ 
					return d.font_color;
				},
				"text-anchor": "middle"
			})
			.call(force.drag); 
		
		//(8)打点更新，没有的话就显示不出来了
		force.on("tick",function(){
			//边的位置
			edges.attr("x1",function(d){
				return  d.source.x;
			})
			.attr("y1",function(d){
				return  d.source.y;
			})
			.attr("x2",function(d){
				return  d.target.x;
			})
			.attr("y2",function(d){
				return  d.target.y;
			});
			//节点文字位置
			texts.attr("x",function(d){
				return  d.x;
			})
			.attr("y",function(d){
				return  d.y+d.img_height/2+d.img_height/5;
			});
			
			//设置节点坐标
			nodes.attr("cx",function(d){
				return d.x;
			})
			.attr("cy",function(d){
				return d.y;
			});
				
			//节点图片坐标
			nodeImg.attr("x",function(d){
				return d.x-d.img_width/2;
			})
			.attr("y",function(d){
				return d.y-(d.img_height+d.font_size)/2;
			});
			nodeEditBtn.attr("x",function(d){
				return d.x+Math.sqrt(2)*d.r/2-10;
			})
			.attr("y",function(d){
				return d.y-Math.sqrt(2)*d.r/4;
			});
			nodeDelBtn.attr("x",function(d){
				return d.x+Math.sqrt(2)*d.r/2-10;
			})
			.attr("y",function(d){
				return d.y-Math.sqrt(2)*d.r/2;
			});
		});
		function changeAfterClick(d){
			settings.callback(d);
		}
		force.start();
	}
	//供外部使用的函数
	var methods = {	
		init:function(options){
			return this.each(function(){
				var $this = $(this);
				var settings = $this.data("graph_manager");
				if(typeof(settings) == 'undefined'){
					var defaults = {    
						width:1376,   //宽度
						height:500,    //高度
						scaleScope: [0,150],    //比例尺范围
						bigCoef: 1.5,    //缩放比例 
						callback: callback,    //回调函数
						charge: -900,
						linkDistance: 200
					};
					settings = $.extend({}, defaults, options);
					$this.data("graph_manager", settings);
				}else{
					settings = $.extend({}, settings, options);
					$this.data("graph_manager", settings);
				}
				//code here
				d3.select(this)
				.append("svg")
				.attr("width",options.width)
				.attr("height",options.height)
				.style("background-color", function(){
					return "transparent";    //改为透明
				});							
			});
		},
		destory:function(options){
			return this.each(function(){
				var $this = $(this);
				//some code here			
				$this.removeData("graph_manager");
			});
		},
		//------------自定义函数-------------------
		/*
			参数：
			{
				type: 1.node 2.info 3.edges
				data: {}
			}
		*/
		addEle:function(options){
			//添加元素
			//1.节点 2.提示信息 3.连线
			alert("called addEle( " + options + " )");
		},
		delEle:function(options){
			return this.each(function(){
				//删除元素
				var svgCons = d3.select(this)
					.select("svg");
				for(var id in options.ids){
					svgCons.select("g[index=" + options.type + options.ids[id] + "]")
						.transition().duration(150)
						.remove();
				}
				//alert("del success!");
			});
		},
		modifyEle:function(options){
			//修改元素
			alert("called modifyEle()" + options);
		},
		load:function(param){    //加载数据‘图’
			return this.each(function(){
				d3.select(this).select("svg").selectAll("g").remove();
				var nodesValid = param.data!=null && param.data.nodes!=null && param.data.nodes.length>0;
				if(nodesValid) {
					loadGraph(param.data, this);
				}else{
					//alert("数据错误");
				}
			});
		}
	};
	
	$.fn.graph_manager=function(){
		var method = arguments[0];
		if(methods[method]){
			method = methods[method];
			arguments = Array.prototype.slice.call(arguments,1);
		}else if(typeof(method) == 'object' || !methods){
			method = methods.init;
		}else{
			$.error('方法[' + method + ']不存在!');
			return this;
		}
		return method.apply(this, arguments);    //类似JAVA反射机制
	};
})(jQuery);