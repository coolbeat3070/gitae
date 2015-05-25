package com.gite.simple.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gite.simple.beans.LoginInfoSessionBean;


public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		LoginInfoSessionBean sessionBean = (LoginInfoSessionBean) session.getAttribute("loginInfo");
		
		if(sessionBean == null){
			response.sendRedirect("/simple");
			return false;
		}
		
		return true;
	}
	
}
