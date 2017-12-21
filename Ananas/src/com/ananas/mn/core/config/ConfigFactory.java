package com.ananas.mn.core.config;

import com.ananas.mn.core.context.Context;
import com.ananas.mn.core.spring.SpringBeanInvoker;

public class ConfigFactory {

    private static final String defaultConfigName = "com.ananas.mn.core.config.DefaultConfig";

    public static Config getDefaultConfig(){
        return (Config) SpringBeanInvoker.getBean(defaultConfigName);
    }

}
