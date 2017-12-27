package com.ananas.mn.core.client;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ananas.mn.core.spring.SpringBeanInvoker;

public abstract class BaseJdbcTemplateClient {

    private static final String defaultJdbcTemplateName = "jdbcTemplate";

    private static JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringBeanInvoker.getBean(defaultJdbcTemplateName);


    public static List getAllCache() {
    	String sql = "select * from cache";
    	return jdbcTemplate.queryForList(sql);
    }

    
    public static List getAllFileCache() {
    	String sql = "select * from file where 1=1";
    	return jdbcTemplate.queryForList(sql);
    }

}
