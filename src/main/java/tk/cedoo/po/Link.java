package tk.cedoo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * 连接表
 * 对应 t_link
 * t_link.N_LINK_ID,
t_link.N_S_NODE_ID,
t_link.N_E_NODE_ID,
t_link.N_LINK_STYLE_ID,
t_link.N_LINK_TYPE_ID,
t_link.N_DEPT,
t_link.DT_DEL_LINK_TIME,
t_link.DT_ADD_LINK_TIME
 * @author Administrator
 *
 */
public class Link implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -168912326315130863L;
	
	private int linkID = -1;   //连接ID
	private int sNodeID = -1;     //开始节点ID
	private int eNodeID = -1;    //结束节点ID
	private int linkStyleID = -1;    //连接样式ID
	private int linkTypeID = -1;    //连接类型ID
	private int dept = -1;    //深度
	private Date delLinkTime = null;    //删除连接时间
	private Date addLinkTime = null;    //添加连接时间
	public int getLinkID() {
		return linkID;
	}
	public void setLinkID(int linkID) {
		this.linkID = linkID;
	}
	
	public int getSNodeID() {
		return sNodeID;
	}
	public void setSNodeID(int sNodeID) {
		this.sNodeID = sNodeID;
	}
	public int geteNodeID() {
		return eNodeID;
	}
	public void seteNodeID(int eNodeID) {
		this.eNodeID = eNodeID;
	}
	public int getLinkStyleID() {
		return linkStyleID;
	}
	public void setLinkStyleID(int linkStyleID) {
		this.linkStyleID = linkStyleID;
	}
	public int getLinkTypeID() {
		return linkTypeID;
	}
	public void setLinkTypeID(int linkTypeID) {
		this.linkTypeID = linkTypeID;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public Date getDelLinkTime() {
		return delLinkTime;
	}
	public void setDelLinkTime(Date delLinkTime) {
		this.delLinkTime = delLinkTime;
	}
	public Date getAddLinkTime() {
		return addLinkTime;
	}
	public void setAddLinkTime(Date addLinkTime) {
		this.addLinkTime = addLinkTime;
	}
	@Override
	public String toString() {
		return "Link [linkID=" + linkID + ", sNodeID=" + sNodeID + ", eNodeID="
				+ eNodeID + ", linkStyleID=" + linkStyleID + ", linkTypeID="
				+ linkTypeID + ", dept=" + dept + ", delLinkTime="
				+ delLinkTime + ", addLinkTime=" + addLinkTime + "]";
	}
	
}
