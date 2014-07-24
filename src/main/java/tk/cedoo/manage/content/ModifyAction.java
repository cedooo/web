package tk.cedoo.manage.content;

import org.apache.ibatis.session.SqlSession;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.db.DBManager;
import tk.cedoo.vo.RecordContent;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改分类节点： 1.修改时只传递修改的数据 2.修改成功返回Json 修改节点样式，修改节点名称、描述。修改连接开始节点、连接样式。
 * 
 * @author Administrator
 * 
 */
public class ModifyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 980487756491218947L;
	private DoActionResult doResult = new DoActionResult();
	private RecordContent recordContent = null;

	@Override
	public String execute() throws Exception {
		if (recordContent != null) {
			doResult.reset();
			SqlSession session = DBManager.getSqlSessionFactory().openSession();
			tk.cedoo.po.RecordContent poRecordContent = ModifyAction.parsePORecordContent(recordContent);
System.out.println("修改内容:" + poRecordContent);
			int updatedColumns = session.update("tk.cedoo.manage.content.updateContent", poRecordContent);
			boolean updateSuccess = updatedColumns==1;
			if(updateSuccess){
				doResult.setInfo("修改成功!");
				doResult.setState(DoActionResult.STAT_SUCCESS);
			}else{
				doResult.setInfo("修改失败!");
				doResult.setState(DoActionResult.STAT_FAIL);
			}
			session.commit();
			session.close();
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	private static tk.cedoo.po.RecordContent parsePORecordContent(RecordContent recordContent){
		tk.cedoo.po.RecordContent rc = new tk.cedoo.po.RecordContent();
		rc.setContent(recordContent.getContent());
		rc.setDownloadUrl(recordContent.getDownloadUrl());
		rc.setIntro(recordContent.getIntro());
		rc.setLinkUrl(recordContent.getLinkUrl());
		rc.setPreview(recordContent.getPreview());
		rc.setSubhead(recordContent.getSubhead());
		rc.setTitle(recordContent.getTitle());
		rc.setRecordID(recordContent.getRecordID());
		return rc;
	}
	public DoActionResult getDoResult() {
		return doResult;
	}

	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}
	public RecordContent getRecordContent() {
		return recordContent;
	}
	public void setRecordContent(RecordContent recordContent) {
		this.recordContent = recordContent;
	}
	
}
