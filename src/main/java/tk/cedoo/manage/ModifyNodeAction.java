package tk.cedoo.manage;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;
import tk.cedoo.vo.Node;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改分类节点： 1.修改时只传递修改的数据 2.修改成功返回Json 修改节点样式，修改节点名称、描述。修改连接开始节点、连接样式。
 * 
 * @author Administrator
 * 
 */
public class ModifyNodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 980487756491218947L;
	private int id = -1;
	private DoActionResult doResult = new DoActionResult();
	private Node node = null;

	@Override
	public String execute() throws Exception {
		// TODO 修改分类
		doResult.reset();
		if (node != null) {
			SqlSession session = DBManager.getSqlSessionFactory().openSession();
			tk.cedoo.po.Node pNode = parseVoToPoNode(node);
			int updateColumns = 0;
			updateColumns += session
					.update("tk.cedoo.manage.updateNode", pNode);
			tk.cedoo.po.NodeStyle pNodeStyle = parseVoToPoNodeStyle(node);
			int nodeStyleID = session.selectOne(
					"tk.cedoo.common.selectNodeStyleIDByNodeID",
					node.getNodeID()); // 查找节点样式ID
			if (nodeStyleID > 0 && pNodeStyle != null) {
				pNodeStyle.setNodeStyleID(nodeStyleID);
				updateColumns += session.update(
						"tk.cedoo.manage.updateNodeStyle", pNodeStyle);
			} else {
				throw new Exception("节点样式不存在或者参数错误");
			}
			/*
			 * tk.cedoo.po.Link pLink = parseVoToPoLink(node); int linkID =
			 * session.selectOne("tk.cedoo.common.selectLinkIDByNodeID",
			 * node.getNodeID()); //查找连接ID if(linkID>0 && pLink!=null){
			 * pLink.setLinkID(linkID); updateColumns +=
			 * session.update("tk.cedoo.manage.updateLinkSNode", pLink); }else{
			 * throw new Exception("连接不存在或者参数错误"); }
			 */
			if (updateColumns == 2) {
				doResult.setInfo("更新成功");
				doResult.setState(DoActionResult.STAT_SUCCESS);
			} else if (updateColumns == 0) {
				doResult.setInfo("节点不存在，或则数据错误。");
				doResult.setState(DoActionResult.STAT_NOT_EXE);
			} else if (updateColumns > 0 && updateColumns < 3) {
				doResult.setInfo("修改部分成功。");
				doResult.setState(DoActionResult.STAT_HALF_SUCCESS);
			} else {
				doResult.setInfo("更新失败。");
				doResult.setState(DoActionResult.STAT_FAIL);
				session.rollback();
				session.commit();
				session.close();
				return ERROR;
			}
			session.commit();
			session.close();
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public static tk.cedoo.po.Node parseVoToPoNode(Node node) {
		tk.cedoo.po.Node pNode = null;
		if (node != null) {
			pNode = new tk.cedoo.po.Node();
			pNode.setNodeID(node.getNodeID());
			pNode.setNodeName(node.getName());
			pNode.setNodeDescription(node.getDescription());
		} else {
			// do nothing
		}
		return pNode;
	}

	public static tk.cedoo.po.NodeStyle parseVoToPoNodeStyle(Node node) {
		tk.cedoo.po.NodeStyle pNodeStyle = null;
		if (node != null) {
			pNodeStyle = new tk.cedoo.po.NodeStyle();
			pNodeStyle.setFillColor(node.getColor());
			pNodeStyle.setFontColor(node.getFont_color());
			pNodeStyle.setFontSize(node.getFont_size());
			pNodeStyle.setImg(node.getImg());
			pNodeStyle.setImgHeight(node.getImg_height());
			pNodeStyle.setImgWidth(node.getImg_width());
			pNodeStyle.setR(node.getR());
			pNodeStyle.setStrokeColor(node.getStroke());
			pNodeStyle.setStrokeWeight(node.getStrokewidth());
		} else {
			// do nothing
		}
		return pNodeStyle;
	}

	public static tk.cedoo.po.Link parseVoToPoLink(Node node) {
		tk.cedoo.po.Link pLink = null;
		if (node != null) {
			pLink = new tk.cedoo.po.Link();
			pLink.setSNodeID(node.getParentID());
		} else {
			// do nothing
		}
		return pLink;
	}

	public DoActionResult getDoResult() {
		return doResult;
	}

	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}

}
