package tk.cedoo.search.interceptor;

import java.util.Date;

import org.apache.log4j.Logger;

import tk.cedoo.common.interceptor.ManagerAuthorityInterceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 用户搜索频率 限制
 * @author CeDo
 *
 */
public class SearchLimitInterceptor extends AbstractInterceptor {
	static final int SEARCH_ALLOW_INTERVAL_MIN_TIME = 200;    //搜索最小间隔时间(ms)
	/**
	 * 
	 */
	private static final long serialVersionUID = 6730167088459528695L;
	static private final Logger log = Logger.getLogger(ManagerAuthorityInterceptor.class.getClass());

	@Override
	public String intercept(ActionInvocation acInv) throws Exception {
		log.debug("用户搜索限制验证");
		Long lastSearchTime = null;
		try{
			lastSearchTime = (Long) ActionContext.getContext().getSession().get("lastSearchTime");
		}catch(ClassCastException e){
			log.debug("登录时间戳错误!");
		}catch(Exception e){
		}
		if(lastSearchTime==null){
			lastSearchTime = 0l;
		}
		Date now = new Date();
		Long interval = now.getTime() - lastSearchTime;
		log.info("搜索间隔时间:" + interval + "(ms)");
		if(interval>SEARCH_ALLOW_INTERVAL_MIN_TIME){
			return acInv.invoke();
		}else{
			log.info("搜索间隔时间小于" + SEARCH_ALLOW_INTERVAL_MIN_TIME + " ms");
			return Action.ERROR;
		}
	}

}
