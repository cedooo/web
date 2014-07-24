package tk.cedoo.search.pojo;

import java.io.Serializable;
/**
 * 搜索范围
 * @author Administrator
 *
 */
public class SearchScope implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5189768933223904524L;
	

	public static final String YES = "Y";    
	public static final String NO  = "N";
	
	private String nodeName = NO;
	private String title = NO;
	private String content = NO;
	private String tag = NO;

	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "SearchScope [nodeName=" + nodeName + ", title=" + title
				+ ", content=" + content + ", tag=" + tag + "]";
	}
	
}
