package tk.cedoo.search.content;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.db.DBManager;
import tk.cedoo.search.pojo.RecordContent;

import com.opensymphony.xwork2.ActionSupport;

public class SearchContentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -125956332272207419L;
	private SearchContentCondition condition;//= new SearchContentCondition();    //搜索条件
	private SearchContentResult result;    //搜索结果
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	public String searchWithID(){
		result = new SearchContentResult();
		SqlSession session = DBManager.getSqlSessionFactory().openSession(true);
		try{
			RecordContent recordContent = session.selectOne("tk.cedoo.search.content.selectRecordContentWithID", condition);
			result.setRecordContent(recordContent);
		}finally{
			session.close();
		}
		return SUCCESS;
	}
	public SearchContentCondition getCondition() {
		return condition;
	}
	public void setCondition(SearchContentCondition condition) {
		this.condition = condition;
	}
	public SearchContentResult getResult() {
		return result;
	}
	public void setResult(SearchContentResult result) {
		this.result = result;
	}
	
	
}
