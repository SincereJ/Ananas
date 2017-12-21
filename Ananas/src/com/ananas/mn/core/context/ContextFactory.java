package com.ananas.mn.core.context;

import com.ananas.mn.core.spring.SpringBeanInvoker;

public class ContextFactory {
    private Context context = null;
    private static final String defaultContextName = "com.ananas.mn.core.context.AnanasContext";

    public static Context getContext(){
        return (Context) SpringBeanInvoker.getBean(defaultContextName);
    }

}
