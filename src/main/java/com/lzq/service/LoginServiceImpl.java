package com.lzq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzq.dao.LoginMapper;
import com.lzq.po.Login;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginMapper lmapper;
	@Override
	public Login getlogin(Login login) {
		Login log = lmapper.getlogin(login);
		return log;
	}
	@Override
	public int upStuPwd(Login login) {
		int n = lmapper.upStuPwd(login);
		return n;
	}

}
