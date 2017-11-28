package com.lzq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzq.po.Login;
import com.lzq.service.LoginService;
import com.lzq.service.StuService;

@Controller
public class LoginController {
	@Resource
	LoginService loginService;
	@Resource
	StuService stuService;
	@RequestMapping("/login")
	public String getlogin(Login login,Model model,HttpServletRequest request){
		Login user = loginService.getlogin(login);
		if(user!=null){
			if(user.getRole()==3){
				int classid=stuService.getclaid(user);
				request.getSession().setAttribute("classid", classid);
			}
			request.getSession().setAttribute("user", user);
			return "homepage/index";
		}else{
			model.addAttribute("msg", "用户名或密码错误！");
			return "login";
		}
	}

}
