package com.ananas.mn.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class ContextHolder {
    private static ApplicationContext applicationContext;

    public ContextHolder() {
    }

    public static  ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }
}
