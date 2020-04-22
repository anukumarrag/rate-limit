package com.blueoptima.ratelimit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueoptima.ratelimit.model.UserAccessEntity;
import com.blueoptima.ratelimit.service.UserAccessService;


@Component
public class RequestFilter implements Filter {

	Logger LOG = LoggerFactory.getLogger(RequestFilter.class);
	
	@Autowired
	UserAccessService userAccessService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
		
		userAccessService.create(new UserAccessEntity(req.getHeader("Access-Token"), req.getRequestURI()));
		
		userAccessService.findAll().stream().forEach(user -> System.out.println(user));
		
		System.out.println("report : "+userAccessService.getReport(req.getHeader("Access-Token"), req.getRequestURI()));
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
