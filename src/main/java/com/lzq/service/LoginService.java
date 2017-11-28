package com.lzq.service;

import com.lzq.po.Login;

public interface LoginService {
	public Login getlogin(Login login);
	public int upStuPwd(Login login);
}
