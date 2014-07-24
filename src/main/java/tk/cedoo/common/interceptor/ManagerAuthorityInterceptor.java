package tk.cedoo.common.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ManagerAuthorityInterceptor extends AbstractInterceptor {
	static private final Logger log = Logger.getLogger(ManagerAuthorityInterceptor.class.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -305600808442484681L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.info("执行用户权限验证");
		Long loginTime = null;
		try{
			loginTime = (Long) ActionContext.getContext().getSession().get("loginTime");
		}catch(ClassCastException e){
			log.debug("登录时间戳错误!");
		}catch(Exception e){
		}
		if(loginTime==null){
			return Action.ERROR;
		}
		return invocation.invoke();
	}

}
