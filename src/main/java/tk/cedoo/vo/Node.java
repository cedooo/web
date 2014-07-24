package tk.cedoo.vo;

import java.io.Serializable;

/**
 * 节点
 * @author Administrator
 *
 */
public class Node implements Serializable{

	/**
	 * nodeID: 1, name:"下载", type:"clazz", color:"#cc9966", stroke:"#090909", 
		strokewidth:1, r:46, font_size:12, font_color: "#000000",
		description: "资源下载", img:"images/navImgWithD3/download.ico",img_width:48, img_height:48
	 */
	private static final long serialVersionUID = -4918965595293950564L;
	private int nodeID = -1;    //节点ID
	private int parentID = -1;    //父节点ID
	private String name = null;    //节点名称
	private String type = null;    //节点类型
	private String color = null;
	private String stroke = null;
	private int strokewidth = -1;
	private int r = -1;
	private int font_size = -1;
	private String font_color = null;
	private String description = null;
	private String img = null;
	private int img_width = -1;
	private int img_height = -1;
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStroke() {
		return stroke;
	}
	public void setStroke(String stroke) {
		this.stroke = stroke;
	}
	public int getStrokewidth() {
		return strokewidth;
	}
	public void setStrokewidth(int strokewidth) {
		this.strokewidth = strokewidth;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getFont_size() {
		return font_size;
	}
	public void setFont_size(int font_size) {
		this.font_size = font_size;
	}
	public String getFont_color() {
		return font_color;
	}
	public void setFont_color(String font_color) {
		this.font_color = font_color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getImg_width() {
		return img_width;
	}
	public void setImg_width(int img_width) {
		this.img_width = img_width;
	}
	public int getImg_height() {
		return img_height;
	}
	public void setImg_height(int img_height) {
		this.img_height = img_height;
	}
	
	@Override
	public String toString() {
		return "Node [nodeID=" + nodeID + ", name=" + name + ", type=" + type
				+ ", color=" + color + ", stroke=" + stroke + ", strokewidth="
				+ strokewidth + ", r=" + r + ", font_size=" + font_size
				+ ", font_color=" + font_color + ", description=" + description
				+ ", img=" + img + ", img_width=" + img_width + ", img_height="
				+ img_height + "]";
	}

}
