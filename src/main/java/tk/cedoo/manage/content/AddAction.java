package tk.cedoo.manage.content;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;
import tk.cedoo.vo.RecordContent;

import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2168932732227318058L;
	private DoActionResult doResult = new DoActionResult();
	private RecordContent recordContent = null;    //内容
	@Override
	public String execute() throws Exception {
System.out.println("添加内容");
		boolean recordContentValid = (recordContent!=null);
		if(recordContentValid){
			tk.cedoo.po.RecordContent poRecordContent = AddAction.parsePORecord(recordContent);
			SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
			sqlSession.insert("tk.cedoo.manage.content.insertContent", poRecordContent);    //插入内容
			boolean insertContentSuccess = poRecordContent.getRecordID()>0;
			boolean updateSuccess = false;
			if(insertContentSuccess){
				recordContent.setRecordID(poRecordContent.getRecordID());
				int updatedColumns = sqlSession.update("tk.cedoo.manage.content.updateNodeLinkedContent", recordContent);//更新节点
				updateSuccess = updatedColumns == 1;
			}else{
				//do nothing
			}
			boolean addSuccess =  insertContentSuccess && updateSuccess;
			if(addSuccess){
				sqlSession.commit();
				sqlSession.close();
				doResult.reset();
				doResult.setInfo("添加内容成功！");
				doResult.setState(DoActionResult.STAT_SUCCESS);
			}else{
				sqlSession.rollback();
				sqlSession.close();
				doResult.reset();
				doResult.setInfo("添加内容失败！");
				doResult.setState(DoActionResult.STAT_FAIL);
			}
System.out.println("执行结果:" + doResult);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public RecordContent getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(RecordContent recordContent) {
		this.recordContent = recordContent;
	}

	public DoActionResult getDoResult() {
		return doResult;
	}
	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}
	
	private static tk.cedoo.po.RecordContent parsePORecord(RecordContent recordContent){
		tk.cedoo.po.RecordContent rc = new tk.cedoo.po.RecordContent();
		rc.setContent(recordContent.getContent());
		rc.setDownloadUrl(recordContent.getDownloadUrl());
		rc.setIntro(recordContent.getIntro());
		rc.setLinkUrl(recordContent.getLinkUrl());
		rc.setPreview(recordContent.getPreview());
		rc.setSubhead(recordContent.getSubhead());
		rc.setTitle(recordContent.getTitle());
		return rc;
	}
}
