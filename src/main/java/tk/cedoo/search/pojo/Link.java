package tk.cedoo.search.pojo;

import java.io.Serializable;

/**
 * 节点之间的联系---‘边’
 * @author Administrator
 *
 */
public class Link implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3870635213190907496L;
	private int source = -1;
	private int target = -1;
	private int weight = -1;
	private String color = "";
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "链路起点ID:" + this.source + ",终点ID:" + this.target + 
				"，颜色： " + this.color + ", 宽度：" + this.weight;
	}
}	
