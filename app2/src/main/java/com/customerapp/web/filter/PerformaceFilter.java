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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName="performaceFilter")
public class PerformaceFilter implements Filter {

	private Logger logger=LoggerFactory.getLogger(PerformaceFilter.class);
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		long start=System.currentTimeMillis();
		chain.doFilter(request, response);
		long end=System.currentTimeMillis();
		logger.info("time taken by request: "+(end-start));
	}

	public void destroy() {
	}

}











