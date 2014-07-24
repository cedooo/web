package tk.cedoo.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 节点类型 
 * 对应  t_node_type
 * t_node_type.N_NODE_TYPE_ID,
t_node_type.VC_NODE_TYPE_CODE,
t_node_type.VC_NODE_TYPE_NAME,
t_node_type.VC_REF_TABLE_NAME,
t_node_type.DT_ADD_NT_TIME,
t_node_type.DT_DEL_NT_TIME
 * @author Administrator
 *
 */
public class NodeType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6669054161672355652L;
	
	private int nodeTypeID = -1;    //节点类型ID
	private String nodeTypeCode = "";    //节点类型编码
	private String refTableName = "";    //外联内容表ID
	private Date addNTTime = null;    //添加节点类型时间
	private Date delNTTime = null;     //删除节点类型时间
	public int getNodeTypeID() {
		return nodeTypeID;
	}
	public void setNodeTypeID(int nodeTypeID) {
		this.nodeTypeID = nodeTypeID;
	}
	public String getNodeTypeCode() {
		return nodeTypeCode;
	}
	public void setNodeTypeCode(String nodeTypeCode) {
		this.nodeTypeCode = nodeTypeCode;
	}
	public String getRefTableName() {
		return refTableName;
	}
	public void setRefTableName(String refTableName) {
		this.refTableName = refTableName;
	}
	public Date getAddNTTime() {
		return addNTTime;
	}
	public void setAddNTTime(Date addNTTime) {
		this.addNTTime = addNTTime;
	}
	public Date getDelNTTime() {
		return delNTTime;
	}
	public void setDelNTTime(Date delNTTime) {
		this.delNTTime = delNTTime;
	}
	
	
}
