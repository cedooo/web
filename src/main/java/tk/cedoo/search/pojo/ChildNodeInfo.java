package tk.cedoo.search.pojo;

import java.io.Serializable;
import java.util.List;

import tk.cedoo.vo.Node;
/**
 * ‘孩子节点’的信息
 * @author Administrator
 *
 */
public class ChildNodeInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6580599738430694575L;
	private int childNums = 0;
	private List<Node> listChildNode = null;    //所有'孩子节点'
	public int getChildNums() {
		return childNums;
	}

	public void setChildNums(int childNums) {
		this.childNums = childNums;
	}

	public List<Node> getListChildNode() {
		return listChildNode;
	}

	public void setListChildNode(List<Node> listChildNode) {
		this.listChildNode = listChildNode;
	}
	
}
