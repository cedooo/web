package tk.cedoo.search.content;

import tk.cedoo.search.pojo.RecordContent;
import tk.cedoo.search.pojo.SearchResult;
/**
 * 搜索结果
 * @author Administrator
 *
 */
public class SearchContentResult extends SearchResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3791826094429107156L;
	private RecordContent recordContent;
	public RecordContent getRecordContent() {
		return recordContent;
	}
	public void setRecordContent(RecordContent recordContent) {
		this.recordContent = recordContent;
	}
	@Override
	public String toString() {
		return "SearchContentResult [recordContent=" + recordContent + "]";
	}
	
	
}
