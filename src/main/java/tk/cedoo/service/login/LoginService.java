package tk.cedoo.service.login;

public interface LoginService {
	/**
	 * 登录验证
	 * @param user 用户名
	 * @param passwd 密码
	 * @return
	 */
	public boolean login(String user, String passwd);
}
