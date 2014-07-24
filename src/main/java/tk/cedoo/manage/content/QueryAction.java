package tk.cedoo.manage.content;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;
import tk.cedoo.vo.RecordContent;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 查找
 * @author Administrator
 *
 */
public class QueryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734855717102224452L;
	private DoActionResult doResult = new DoActionResult();    //搜索结果
	private int id = -1;   //内容ID
	public String json() {
		doResult.reset();
		SqlSession session = DBManager.getSqlSessionFactory().openSession();
		RecordContent recordContent = session.selectOne("tk.cedoo.manage.content.selectRecordContentWithNodeID", id);
		doResult.setInfo("查询成功");
		doResult.setState(DoActionResult.STAT_SUCCESS);
		doResult.setObj(recordContent);
		session.close();
		return SUCCESS;
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
