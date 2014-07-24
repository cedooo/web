package tk.cedoo.po;

import java.io.Serializable;

/**
 * 节点
 * 对应 t_node
 * t_node.N_NODE_ID,
t_node.N_NODE_TYPE_ID,
t_node.N_NODE_STYLE_ID,
t_node.VC_NODE_NAME,
t_node.VC_NODE_DESCRIPTION,
t_node.N_RECORD_OR_CT_ID
 * @author Administrator
 *
 */
public class Node implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2175187060960768813L;
	
	private int nodeID = -1;    //节点ID
	private int nodeTypeID = -1;    //节点类型ID
	private int nodeStyleID = -1;    //节点样式ID
	private String nodeName = "";    //节点名称
	private String nodeDescription = "";    //节点描述
	private int recordOrCTID = -1;    //外联内容ID 
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	public int getNodeTypeID() {
		return nodeTypeID;
	}
	public void setNodeTypeID(int nodeTypeID) {
		this.nodeTypeID = nodeTypeID;
	}
	public int getNodeStyleID() {
		return nodeStyleID;
	}
	public void setNodeStyleID(int nodeStyleID) {
		this.nodeStyleID = nodeStyleID;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeDescription() {
		return nodeDescription;
	}
	public void setNodeDescription(String nodeDescription) {
		this.nodeDescription = nodeDescription;
	}
	public int getRecordOrCTID() {
		return recordOrCTID;
	}
	public void setRecordOrCTID(int recordOrCTID) {
		this.recordOrCTID = recordOrCTID;
	}
	@Override
	public String toString() {
		return "Node [nodeID=" + nodeID + ", nodeTypeID=" + nodeTypeID
				+ ", nodeStyleID=" + nodeStyleID + ", nodeName=" + nodeName
				+ ", nodeDescription=" + nodeDescription + ", recordOrCTID="
				+ recordOrCTID + "]";
	}
	
}
