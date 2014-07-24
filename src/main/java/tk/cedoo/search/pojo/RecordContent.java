package tk.cedoo.search.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RecordContent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1693734164978594418L;
	private int nodeID;    //节点ID
	private int recordID;    //内容ID
	private String title;    //标题
	private String subhead;    //子标题
	private String preview;    //预览
	private String content;   //记录内容
	private String intro;    //文章介绍
	private String downloadUrl;   //下载连接
	private String linkUrl;    //外联链接
	private Date addTime;    //添加时间
	
	private List<Tag> tags;    //关键字/标签
	private int preNodeID;     //上一篇关联文章ID
	private int nextNodeID;    //下一关联文章ID

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}


	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubhead() {
		return subhead;
	}

	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public int getPreNodeID() {
		return preNodeID;
	}

	public void setPreNodeID(int preNodeID) {
		this.preNodeID = preNodeID;
	}

	public int getNextNodeID() {
		return nextNodeID;
	}

	public void setNextNodeID(int nextNodeID) {
		this.nextNodeID = nextNodeID;
	}

	@Override
	public String toString() {
		return "RecordContent [nodeID=" + nodeID + ", recordID=" + recordID
				+ ", title=" + title + ", subhead=" + subhead + ", preview="
				+ preview + ", content=" + content + ", intro=" + intro
				+ ", downloadUrl=" + downloadUrl + ", linkUrl=" + linkUrl
				+ ", addTime=" + addTime + ", tags=" + tags + ", preNodeID="
				+ preNodeID + ", nextNodeID=" + nextNodeID + "]";
	}

	
	
}
