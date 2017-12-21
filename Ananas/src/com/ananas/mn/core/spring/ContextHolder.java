package com.ananas.mn.core.spring;

import org.springframework.context.ApplicationContext;

public class ContextHolder {
    private static ApplicationContext applicationContext;

    public ContextHolder() {
    }

    public static  ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        applicationContext = applicationContext;
    }
}
