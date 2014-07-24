package tk.cedoo.manage;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;
import tk.cedoo.vo.Node;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 查找(vo)节点信息
 * @author Administrator
 *
 */
public class QueryNodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734855717102224452L;
	private DoActionResult doResult = new DoActionResult();    //查询结果
	private int id = -1;    //节点ID
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String json(){
		if(id>0){
			doResult.reset();
			SqlSession ss = DBManager.getSqlSessionFactory().openSession();
			Node node = ss.selectOne("tk.cedoo.search.graph.selectNodeWithID", id);
			doResult.setInfo("查找成功");
			doResult.setState(DoActionResult.STAT_SUCCESS);
			doResult.setObj(node);
System.out.println("查询结果：" + node);
			ss.commit();
			ss.close();
			return SUCCESS;
		}else{
System.out.println("节点ID错误，无法查找!");
			return ERROR;
		}
	}
	public DoActionResult getDoResult() {
		return doResult;
	}
	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
