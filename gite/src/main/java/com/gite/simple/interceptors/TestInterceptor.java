package com.gite.simple.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("====================CATCH HERE TEST INTERCEPTOR=========================");
		
		//response.sendRedirect("http://www.naver.com");
		
		return false;
	}

}
