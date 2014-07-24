package tk.cedoo.manage.clazz;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 删除分类节点:
 * 		<li>1.假删除</li>
 * 		<li>2.含有子节点时一起删除：<br />子节点不影响，只是将‘父子’关系断开（注意按关键字搜索是查询语句的条件设定）。</li>
 * @author Administrator
 *
 */
public class DeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7916112021897555672L;
	private int id = -1;
	private DoActionResult doResult = new DoActionResult();
	@Override
	public String execute() throws Exception {
		SqlSession session = DBManager.getSqlSessionFactory().openSession();
		int updateColumns = session.update("tk.cedoo.manage.clazz.updateDelTimeWithID", id);
		if(updateColumns==1){
			doResult.setInfo("删除分类成功");
			doResult.setState(DoActionResult.STAT_SUCCESS);
		}else if(updateColumns==0){
			doResult.setInfo("分类不存在");
			doResult.setState(DoActionResult.STAT_NOT_EXE);
		}else{
			doResult.setInfo("删除分类失败，数据异常，存在多个节点。");	
			doResult.setState(DoActionResult.STAT_FAIL);
			session.rollback();
			return ERROR;
		}
		session.commit();
		session.close();
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DoActionResult getDoResult() {
		return doResult;
	}
	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}

	
}
