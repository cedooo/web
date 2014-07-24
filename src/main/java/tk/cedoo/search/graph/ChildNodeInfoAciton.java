package tk.cedoo.search.graph;

import tk.cedoo.search.pojo.ChildNodeInfo;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 查询出‘孩子节点’的信息
 * @author Administrator
 *
 */
public class ChildNodeInfoAciton extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6296539841861938351L;
	private int id = -1;    //节点ID
	private ChildNodeInfo childInfo= null;    //‘孩子节点’的信息
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ChildNodeInfo getChildInfo() {
		return childInfo;
	}
	public void setChildInfo(ChildNodeInfo childInfo) {
		this.childInfo = childInfo;
	}
}
