package tk.cedoo.common.action;

import java.util.Date;

import org.apache.log4j.Logger;

import tk.cedoo.common.DoActionResult;
import tk.cedoo.service.login.LoginService;
import tk.cedoo.service.login.impl.LoginServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 管理员登陆
 * @author Administrator
 *
 */
public class LoginAction extends ActionSupport {
	static private final Logger log = Logger.getLogger(LoginAction.class.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -9127486824517280381L;
	private String userName = "";
	private String passwd = "";

	private DoActionResult doResult = new DoActionResult();
	/**
	 * 登入
	 * @return
	 */
	public String login()  {
		LoginService loginService = new LoginServiceImpl();
		if(loginService.login(userName, passwd)){
			doResult.setState(DoActionResult.STAT_SUCCESS);
			doResult.setInfo("登陆成功");
			ActionContext.getContext().getSession().put("loginTime", new Date().getTime());
			log.info(userName + ", 登陆成功");
		}else{
			doResult.setState(DoActionResult.STAT_FAIL);
			doResult.setInfo("登陆失败");
			log.warn("登陆失败！登录名：" + userName + ", 密码： " + passwd);
			ActionContext.getContext().getSession().put("actionTime", new Date().getTime());
		}
		return SUCCESS;
	}
	/**
	 * 登出
	 * @return
	 */
	public String logout(){
		doResult.reset();
		Long loginTime = (Long) ActionContext.getContext().getSession().get("loginTime");
		if(loginTime!=null){
			doResult.setState(DoActionResult.STAT_SUCCESS);
			doResult.setInfo("注销成功");
			log.info("注销成功");
			ActionContext.getContext().getSession().remove("loginTime");
		}else{
			doResult.setState(DoActionResult.STAT_FAIL);
			doResult.setInfo("未登陆，不能注销");
		}
		return SUCCESS;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public DoActionResult getDoResult() {
		return doResult;
	}

	public void setDoResult(DoActionResult doResult) {
		this.doResult = doResult;
	}
}
