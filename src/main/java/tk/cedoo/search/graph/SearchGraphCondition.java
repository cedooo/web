package tk.cedoo.search.graph;

import tk.cedoo.search.pojo.SearchCondition;
import tk.cedoo.search.pojo.SearchScope;

/**
 * 搜索节点条件类
 * @author Administrator
 *
 */
public class SearchGraphCondition extends SearchCondition{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6126887826223998926L;
	private int startNodeID=-1;    //节点ID
	private int numPerPage = 10;    //每页显示数量
	private int page = 1;    //第几页
	private String nodeType = "";    //节点类型
	private String key = "";    //关键字
	private int dept = -1;    //链路深度

	private SearchScope searchScope = null;    //搜索范围
	public int getStartNodeID() {
		return startNodeID;
	}

	public void setStartNodeID(int startNodeID) {
		this.startNodeID = startNodeID;
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

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
	public SearchScope getSearchScope() {
		return searchScope;
	}

	public void setSearchScope(SearchScope searchScope) {
		this.searchScope = searchScope;
	}
	public boolean isSearchWithParentID(){
		return searchScope==null?true:false;
	}
	@Override
	public String toString() {
		return "[startNodeID=" + startNodeID
				+ ", numPerPage=" + numPerPage + ", page=" + page
				+ ", nodeType=" + nodeType + ", key=" + key + ", dept=" + dept
				+ ", searchScope=" + searchScope + "]";
	}

}
