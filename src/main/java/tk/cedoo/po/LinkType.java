package tk.cedoo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * 连接类型
 * 对应 t_link_type
 * t_link_type.N_LINK_TYPE_ID,
t_link_type.VC_LINK_NAME,
t_link_type.VC_LINK_CODE,
t_link_type.DT_DEL_LT_TIME
t_link_type.DT_ADD_LT_TIME
 * @author Administrator
 *
 */
public class LinkType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8498702339551059280L;
	
	private int linkTypeID = -1;    //连接类型ID
	private String linkName = "";    //连接名称
	private String linkCode = "";    //连接编码
	private Date addLTtime = null;    //添加连接类型时间
	private Date delLTtime = null;    //删除连接类型时间
	public int getLinkTypeID() {
		return linkTypeID;
	}
	public void setLinkTypeID(int linkTypeID) {
		this.linkTypeID = linkTypeID;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkCode() {
		return linkCode;
	}
	public void setLinkCode(String linkCode) {
		this.linkCode = linkCode;
	}
	public Date getAddLTtime() {
		return addLTtime;
	}
	public void setAddLTtime(Date addLTtime) {
		this.addLTtime = addLTtime;
	}
	public Date getDelLTtime() {
		return delLTtime;
	}
	public void setDelLTtime(Date delLTtime) {
		this.delLTtime = delLTtime;
	}
	
}
