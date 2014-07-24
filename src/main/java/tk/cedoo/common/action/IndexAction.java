package tk.cedoo.common.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 首页
 * @author Administrator
 *
 */
public class IndexAction extends ActionSupport{
	static final private Logger log = Logger.getLogger(IndexAction.class.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 8127056355411672126L;
	@Override
	public String execute() throws Exception {
		log.info("默认首页处理");
		return super.execute();
	}
}
