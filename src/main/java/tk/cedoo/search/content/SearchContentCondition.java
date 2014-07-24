package tk.cedoo.search.content;

import tk.cedoo.search.pojo.SearchCondition;

/**
 * 搜索节点条件类
 * @author Administrator
 *
 */
public class SearchContentCondition extends SearchCondition{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6126887826223998926L;
	private int nodeID=0;    //节点ID
	private int numPerPage = 10;    //每页显示数量
	private int page = 1;    //第几页
	private String key = "";    //关键字
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "SearchContentCondition [nodeID=" + nodeID + ", numPerPage="
				+ numPerPage + ", page=" + page + ", key=" + key + "]";
	}
}
