package tk.cedoo.search.pojo;

import java.io.Serializable;

/**
 * 搜索结果
 * @author Administrator
 *
 */
public class SearchResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1170119816642251618L;
	private PaggingInfo paggingInfo = null;
	public PaggingInfo getPaggingInfo() {
		return paggingInfo;
	}
	public void setPaggingInfo(PaggingInfo paggingInfo) {
		this.paggingInfo = paggingInfo;
	}
	@Override
	public String toString() {
		return "SearchResult [paggingInfo=" + paggingInfo + "]";
	}
}
