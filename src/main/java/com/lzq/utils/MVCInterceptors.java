package com.lzq.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MVCInterceptors implements HandlerInterceptor{
	public List<String> limitint;
	public void setLimitint(List<String> limitint) {
		this.limitint = limitint;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		String url=request.getRequestURI();
		int ishave = url.lastIndexOf(".");
		if(ishave>-1){
			String postfix=url.substring(ishave);
			if(limitint.contains(postfix)){
				return true;
			}else{
				return false;
			}
		}else{
			if(!url.contains("/login")){
				HttpSession session = request.getSession();
				if(session.getAttribute("user")!=null){
					return true;
				}else{
					request.getRequestDispatcher("/views/login.jsp").forward(request, arg1);
					return false;
				}
			}
		}
		return true;
	}

}
