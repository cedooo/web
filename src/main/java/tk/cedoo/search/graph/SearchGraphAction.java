package tk.cedoo.search.graph;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import tk.cedoo.db.DBManager;
import tk.cedoo.search.pojo.Link;
import tk.cedoo.vo.Node;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 搜索节点信息
 * @author Administrator
 *
 */
public class SearchGraphAction extends ActionSupport{
	static private final Logger log = Logger.getLogger(SearchGraphAction.class.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -3185072581101331646L;
	private SearchGraphCondition condition ;//= new SearchGraphCondition();    //搜索条件
	private SearchGraphResult result;    //搜索结果
	private static int rootID; 
	static {
		rootID = (Integer)(ActionContext.getContext().getApplication().get("rootNodeID"));
	}
	@Override
	public String execute() throws Exception {
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String authType = request.getAuthType();         // http or https
		String user = request.getRemoteUser();           // the user principal (in string)
		Principal principal = request.getUserPrincipal(); // get a Principal object
		boolean isAuth = request.isUserInRole("patrick");*/
		return super.execute();
	}
	/**
	 * ajax 返回JSON数据
	 * @return
	 */
	public String json() {
		boolean searchWithParentID = condition.isSearchWithParentID();
		if(-1 == condition.getStartNodeID()){
			condition.setStartNodeID(rootID);
		}
		log.info("搜索条件：" + condition);
		SqlSession ss = DBManager.getSqlSessionFactory().openSession(true);
		List<Link> listLink=null;// = ss.selectList("tk.cedoo.search.graph.selectLinkWithPagging", condition);
		try{
			if(searchWithParentID){
				log.info("按父节点搜索");
				listLink = ss.selectList("tk.cedoo.search.graph.selectLinkWithStartNodeID", condition);			
			}else{
				log.info("按关键字搜索");
				listLink = ss.selectList("tk.cedoo.search.graph.selectLinkWithCondition", condition);			
			}
			
			if(listLink!=null&& listLink.size()>0){
				result = new SearchGraphResult();
				//result.setEdges(listLink);
				List<Node> nodes = new ArrayList<Node>();
				for(Link link:listLink){
					Node node = ss.selectOne("tk.cedoo.search.graph.selectNodeWithID", link.getTarget());
					nodes.add(node);
				}
				result.setNodes(nodes);
			}
		}finally{
			ss.close();
		}
		return SUCCESS;
	}
	/**
	 * 搜索"图"
	 * @param condition  搜索条件
	 * @return 符合条件的结果---节点 + 边
	 */
	public String search(SearchGraphCondition condition){
		System.out.println("搜索");
		return null;
	}
	public SearchGraphCondition getCondition() {
		return condition;
	}
	public void setCondition(SearchGraphCondition condition) {
		this.condition = condition;
	}
	public SearchGraphResult getResult() {
		return result;
	}
	public void setResult(SearchGraphResult result) {
		this.result = result;
	}

	
}
