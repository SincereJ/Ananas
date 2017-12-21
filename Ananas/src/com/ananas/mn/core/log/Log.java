package com.ananas.mn.core.log;

public class Log {

    private LoggerWrapper log ;
    private static String defaultName = "com.ananas.mn.core.log.Log";

    public Log(String name) {
        this.log = new LoggerWrapper(name);
    }

    public static Log getLogger(String name){
        String sName = name;
        if(sName == null){
            sName = defaultName;
        }
        return new Log(sName);
    }

    public static Log getLogger(Class clazz){
        String sName = defaultName;
        if(clazz.getName() != null){
            sName = clazz.getName();
        }
        return getLogger(sName);
    }

    public void info(String message, Object ... argw){
        try{
            log.info(message,argw);
        }catch(Throwable e){
            e.printStackTrace();;
        }
    }

    public void debug(String message , Object ... args){
        try{
            log.debug(message,args);
        }catch (Throwable e){
            e.printStackTrace();;
        }
    }

    public void warn(String message, Object ... args){
        try{
            log.warn(message,args);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    public void error(String message, Object ... args){
        try{
            log.error(message,args);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public void trace(String message, Object ... args){
        try{
            log.trace(message,args);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

}
