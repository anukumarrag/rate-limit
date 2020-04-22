package com.blueoptima.ratelimit.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseInit {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void initDb() {
	    String sqlStatements[] = {
	      "drop table employees if exists",
	      "create table employees(id serial,first_name varchar(255),last_name varchar(255))",
	      "insert into employees(first_name, last_name) values('Eugen','Paraschiv')",
	      "insert into employees(first_name, last_name) values('Scott','Tiger')"
	    };
	 
	    Arrays.asList(sqlStatements).forEach(sql -> {
	        jdbcTemplate.execute(sql);
	    });
	 
	    // Query test data and print results
	}
	
}
