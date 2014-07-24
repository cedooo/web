package tk.cedoo.manage;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 首页
 * @author Administrator
 *
 */
public class IndexManageAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8127056355411672126L;
	@Override
	public String execute() throws Exception {
System.out.println("默认跳转到管理界面");
		return super.execute();
	}
}
