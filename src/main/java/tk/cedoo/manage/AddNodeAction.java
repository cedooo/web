package tk.cedoo.manage;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;
import tk.cedoo.po.Link;
import tk.cedoo.po.LinkStyle;
import tk.cedoo.po.Node;
import tk.cedoo.po.NodeStyle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddNodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2168932732227318058L;
	private static final int P_C_TYPE_ID = (Integer) ActionContext.getContext().getApplication().get("parentAndChildTypeID");   //父子关系 类型ID
	private static final int NODE_TYPE_ID = (Integer) ActionContext.getContext().getApplication().get("clazzNodeTypeID");    //'类型'节点 ID
	private static final int CONTENT_TYPE_ID = (Integer) ActionContext.getContext().getApplication().get("leafNodeTypeID");    //'叶子'节点 ID
	private static final int ROOT_NODE_ID = (Integer) ActionContext.getContext().getApplication().get("rootNodeID");    //节点类型 ID
	private static final String QUESTION_ICON = "/images/common/question.ico";
	
	private NodeStyle nodeStyle = null;
	private Node node = null;
	private LinkStyle linkStyle = null;
	private Link link = null;
	
	private String addType = null;
	private DoActionResult doResult = new DoActionResult();    //执行结果
	@Override
	public String execute() throws Exception {
System.out.println("添加分类action");
		try{
			if(link==null){
				link = new Link();
			}
			if(link.getSNodeID()<1){
				link.setSNodeID(ROOT_NODE_ID);
			}
			if(linkStyle == null){
				link.setLinkStyleID(4);    //TODO 写死了！！
				link.setLinkTypeID(P_C_TYPE_ID);
			}

			if(node!=null){
				if("clazz".equals(addType)){
					node.setNodeTypeID(NODE_TYPE_ID);
				}else if("leaf".equals(addType)){
					node.setNodeTypeID(CONTENT_TYPE_ID);
				}else{
					throw new Exception("添加类型错误，不能添加。");
				}
				if(null == nodeStyle.getImg() || "".equals(nodeStyle.getImg())){
					nodeStyle.setImg(QUESTION_ICON);
				}
			}else{
				throw new Exception("struts 注入node失败");
			}
		}catch(Exception e){
			System.err.println("参数错误，添加失败");
			e.printStackTrace();
			return ERROR;
		}
		doResult.reset();
		SqlSession ss = DBManager.getSqlSessionFactory().openSession();
		
System.out.println("===添加-参数=====");
System.out.println(nodeStyle);
System.out.println(node);
System.out.println(linkStyle);
System.out.println(link);
System.out.println("============");
		boolean debug = false;
		if(debug){
			return SUCCESS;
		}
System.out.println("=====开始执行添加动作=====");
		try{
			//添加节点样式
			ss.insert("tk.cedoo.manage.insertNodeStyle", nodeStyle);
			doResult.setInfo("成功添加节点样式:id=" + nodeStyle.getNodeStyleID());
			//添加节点
			node.setNodeStyleID(nodeStyle.getNodeStyleID());
			ss.insert("tk.cedoo.manage.insertClazzNode", node);
			doResult.setInfo("成功添加节点:id=" + node.getNodeID());
			//添加连接样式
			if(linkStyle != null){
				ss.insert("tk.cedoo.manage.insertLinkStyle", linkStyle);
				doResult.setInfo("成功添加连接样式:id=" + linkStyle.getLinkStyleID());
				link.setLinkStyleID(linkStyle.getLinkStyleID());
			}
			//添加连接
			link.seteNodeID(node.getNodeID());
			ss.insert("tk.cedoo.manage.insertLink", link);
			doResult.setState(DoActionResult.STAT_SUCCESS);
			doResult.setInfo("成功完成添加动作");
		}catch(Exception e){
			e.printStackTrace();
			doResult.setState(DoActionResult.STAT_FAIL);
			doResult.setInfo("添加失败");
			ss.rollback();
			ss.close();
			return ERROR;
		}
		ss.commit();
		ss.close();
System.out.println("=====结束执行添加动作=====");
System.out.println("执行结果:" + doResult);
		return SUCCESS;
	}
	
	public String getAddType() {
		return addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}

	public NodeStyle getNodeStyle() {
		return nodeStyle;
	}
	public void setNodeStyle(NodeStyle nodeStyle) {
		this.nodeStyle = nodeStyle;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public LinkStyle getLinkStyle() {
		return linkStyle;
	}
	public void setLinkStyle(LinkStyle linkStyle) {
		this.linkStyle = linkStyle;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public DoActionResult getDoResult() {
		return doResult;
	}
	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}
	
}
