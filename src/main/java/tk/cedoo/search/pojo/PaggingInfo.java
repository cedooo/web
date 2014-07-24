package tk.cedoo.search.pojo;

import java.io.Serializable;
/**
 * 结果分页信息
 * @author Administrator
 *
 */
public class PaggingInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1635319002051680133L;
	private int nowPage = 0;    //当前所在页
	private int totalPage = 0;    //总页数
	private int numPerPage = 0;    //每页结果个数
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PaggingInfo [nowPage=" + nowPage + ", totalPage=" + totalPage
				+ ", numPerPage=" + numPerPage + "]";
	}

}
