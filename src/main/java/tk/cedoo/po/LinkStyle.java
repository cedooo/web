package tk.cedoo.po;

import java.io.Serializable;
/**
 * 连接样式
 * 对应 t_link_style
 * t_link_style.N_LINK_STYLE_ID,
t_link_style.VC_LINK_COLOR,
t_link_style.N_LINK_WEIGHT
 * @author Administrator
 *
 */
public class LinkStyle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7992918099854979652L;
	
	private int linkStyleID = -1;    //连接样式ID
	private String linkColor = "";    //连接颜色
	private int linkWeight = -1;    //连接宽度
	public int getLinkStyleID() {
		return linkStyleID;
	}
	public void setLinkStyleID(int linkStyleID) {
		this.linkStyleID = linkStyleID;
	}
	public String getLinkColor() {
		return linkColor;
	}
	public void setLinkColor(String linkColor) {
		this.linkColor = linkColor;
	}
	public int getLinkWeight() {
		return linkWeight;
	}
	public void setLinkWeight(int linkWeight) {
		this.linkWeight = linkWeight;
	}
	@Override
	public String toString() {
		return "LinkStyle [linkStyleID=" + linkStyleID + ", linkColor="
				+ linkColor + ", linkWeight=" + linkWeight + "]";
	}
	
}
