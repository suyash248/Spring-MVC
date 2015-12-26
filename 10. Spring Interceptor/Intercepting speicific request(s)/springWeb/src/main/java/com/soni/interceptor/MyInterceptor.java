package com.soni.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * This method is invoked before the execution of handler method. 
	 * @return If it returns <code>true</code> then it means request will be handed over to handler method. (Continue execution).
	 * And if it returns <code>false</code> then it means that request will be abandoned and won't preoceed further.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		int day = Calendar.DAY_OF_WEEK;
		if(day == 1){	//1= Sunday, 7=Saturday
			response.getWriter().write("This URL " +request.getRequestURL() + " can't be accessed on Sunday.");
			return false;
		}
		return true;
	}

	/**
	 * This method is invoked immediately after handler method is executed.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("postHandle method is called for : "+request.getRequestURL());
	}

	/**
	 * This method is invoked after response object is created/produced for this request.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion method is called for : "+request.getRequestURL());
	}
}
