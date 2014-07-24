package tk.cedoo.search.interceptor;

import java.util.Date;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 搜索 时间戳
 * @author CeDo
 *
 */
public class SearchTimerTagInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204305666155116197L;
	static private final Logger log = Logger.getLogger(SearchTimerTagInterceptor.class.getClass());

	@Override
	public String intercept(ActionInvocation acIn) throws Exception {
		long searchTime = new Date().getTime();
		ActionContext.getContext().getSession().put("lastSearchTime", searchTime);
		log.info("搜索时间: " + searchTime);
		return acIn.invoke();
	}

}
