package com.customerapp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerapp.model.dao.user.User;

@WebFilter(filterName = "login")
public class LoginFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		boolean loggedIn=false;
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		HttpSession httpSession=req.getSession(false);
		if(httpSession!=null){
			User user=(User) httpSession.getAttribute("user");
			if(user!=null){
				loggedIn=true;
			}
			
		}
		if(loggedIn)
			chain.doFilter(request, response);
		else
			res.sendRedirect("login");
	}

	public void destroy() {

	}
}








