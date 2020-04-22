package com.blueoptima.ratelimit.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blueoptima.ratelimit.filter.RequestFilter;

@Configuration
public class CustomBeanConfig {

	@Bean
	public FilterRegistrationBean<RequestFilter> loggingFilter(){
	    FilterRegistrationBean<RequestFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new RequestFilter());
	    registrationBean.addUrlPatterns("/developer/*", "/orgamization/*");
	         
	    return registrationBean;    
	}
}
