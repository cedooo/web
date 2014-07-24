package tk.cedoo.service.login.impl;

import tk.cedoo.service.login.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean login(String user, String passwd) {
		if("chendong".equals(user) && "g667259".equals(passwd)){
			return true;
		}
		return false;
	}

}
