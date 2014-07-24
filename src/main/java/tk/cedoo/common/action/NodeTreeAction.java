package tk.cedoo.common.action;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import tk.cedoo.db.DBManager;
import tk.cedoo.vo.Node;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 查询节点 “树”
 * @author Administrator
 *
 */
public class NodeTreeAction extends ActionSupport {
	static final private Logger log = Logger.getLogger(NodeTreeAction.class.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 62604754650938191L;
	private int id = -1;
	private List<Node> listChilds = null;
	private static int rootID; 
	static {
		rootID = (Integer)(ActionContext.getContext().getApplication().get("rootNodeID"));
	}
	
	public String searchChildsWithNodeID(){
		if(-1 == id){
			id = rootID;
		}
		log.info("搜寻id="+ id + "的节点的子节点");
		SqlSession ss = DBManager.getSqlSessionFactory().openSession(true);
		try{
		listChilds = ss.selectList("tk.cedoo.common.action.selectChildsNodeWithID", id);
		}finally{
			ss.close();
		}
		return SUCCESS;
	}
	
	public List<Node> getListChilds() {
		return listChilds;
	}
	public void setListChilds(List<Node> listChilds) {
		this.listChilds = listChilds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
