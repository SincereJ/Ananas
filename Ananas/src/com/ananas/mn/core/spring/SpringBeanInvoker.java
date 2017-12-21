package com.ananas.mn.core.spring;

public class SpringBeanInvoker {

    public static Object getBean (String beanName){
        return ContextHolder.getApplicationContext().getBean(beanName);
    }
}
