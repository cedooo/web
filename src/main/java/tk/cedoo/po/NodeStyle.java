package tk.cedoo.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 节点样式表
 * 对应 t_node_style
 * t_node_style.N_NODE_STYLE_ID,
t_node_style.VC_NODE_STYLE_NAME,
t_node_style.VC_STROKE_COLOR,
t_node_style.N_STROKE_WEIGHT,
t_node_style.VC_FILL_COLOR,
t_node_style.DA_IMG,
t_node_style.N_IMG_HEIGHT,
t_node_style.N_IMG_WIDTH,
t_node_style.N_FONT_SIZE,
t_node_style.N_R,
t_node_style.VC_FONT_COLOR,
t_node_style.DT_NODE_STYLE_ADD_TIME
 * @author Administrator
 *
 */
public class NodeStyle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7649064259749453390L;
	private int nodeStyleID = -1;    //节点样式ID
	private String nodeStyleName = "";    //节点样式名称
	private String strokeColor = "";    //边框颜色
	private int strokeWeight = -1;    //边框宽度
	private String fillColor = "";    //填充颜色
	private String img = "";    //图片路径
	private int imgHeight = -1;    //图片高度
	private int imgWidth = -1;    //图片宽度
	private int fontSize = -1;    //字体大小
	private int r = -1;    //半径
	private String fontColor = "";    //字体颜色
	private Date nodeStyleAddTime = null;    //节点样式添加时间
	public int getNodeStyleID() {
		return nodeStyleID;
	}
	public void setNodeStyleID(int nodeStyleID) {
		this.nodeStyleID = nodeStyleID;
	}
	public String getNodeStyleName() {
		return nodeStyleName;
	}
	public void setNodeStyleName(String nodeStyleName) {
		this.nodeStyleName = nodeStyleName;
	}
	public String getStrokeColor() {
		return strokeColor;
	}
	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}
	public int getStrokeWeight() {
		return strokeWeight;
	}
	public void setStrokeWeight(int strokeWeight) {
		this.strokeWeight = strokeWeight;
	}
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	public int getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	public Date getNodeStyleAddTime() {
		return nodeStyleAddTime;
	}
	public void setNodeStyleAddTime(Date nodeStyleAddTime) {
		this.nodeStyleAddTime = nodeStyleAddTime;
	}
	@Override
	public String toString() {
		return "NodeStyle [nodeStyleID=" + nodeStyleID + ", nodeStyleName="
				+ nodeStyleName + ", strokeColor=" + strokeColor
				+ ", strokeWeight=" + strokeWeight + ", fillColor=" + fillColor
				+ ", img=" + img + ", imgHeight=" + imgHeight + ", imgWidth="
				+ imgWidth + ", fontSize=" + fontSize + ", r=" + r
				+ ", fontColor=" + fontColor + ", nodeStyleAddTime="
				+ nodeStyleAddTime + "]";
	}
	
}
