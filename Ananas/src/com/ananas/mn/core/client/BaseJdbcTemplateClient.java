package com.ananas.mn.core.client;

import com.ananas.mn.core.spring.SpringBeanInvoker;
//import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseJdbcTemplateClient {

    private static final String defaultJdbcTemplateName = "jdbcTemplate";

    //public JdbcTemplate jdbcTemplate = null;//(JdbcTemplate) SpringBeanInvoker.getBean(defaultJdbcTemplateName);


    public String getTestString(){
        return "{\"a\":\"a\"}";
    }


}
