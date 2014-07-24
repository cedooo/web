var validationRules = {
	 "nodeRules" : {
        	"node.nodeName" :  {
    	    	required: true,
    	    	rangelength:[2,10]
    	    },
    	    "node.name" :  {
    	    	required: true,
    	    	rangelength:[2,10]
    	    },
    	    "node.nodeDescription": {
    	    	required: true,
    	    	rangelength:[2,30]
    	    },
    	    "node.description": {
    	    	required: true,
    	    	rangelength:[2,30]
    	    },
    	    "node.nodeTypeID":{
    	    	required: true,
    	    	number:true,
    	    	min:1	        	    	
    	    },
    	    "nodeStyle.img" :{
    	    	required: true,
    	    	rangelength:[5,300]
    	    },
    	    "recordContent.downloadUrl":{
    	    	url:true
    	    }
	},
	"contentRules" :{
		"recordContent.title":{
	    	required: true,
	    	rangelength:[1,10]
		},
		"recordContent.subhead":{
	    	required: true,
	    	rangelength:[1,20]
		},
		"recordContent.intro":{
	    	required: true,
	    	rangelength:[1,50]
		},
		"recordContent.content":{
	    	required: true,
	    	rangelength:[1,3000]
		},
	    "recordContent.downloadUrl":{
	    	url:true
	    },
		"recordContent.linkUrl":{
	    	url:true
	    }
	}
};