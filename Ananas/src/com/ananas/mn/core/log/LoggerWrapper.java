package com.ananas.mn.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerWrapper {

    private Logger logger = null;

    public LoggerWrapper(String name) {
        if(logger == null){
            logger = LoggerFactory.getLogger(name);
        }
    }

    public void info(String message , Object ... args){
        logger.info(message,args);
    }

    public void debug(String message , Object ... args){
        logger.debug(message,args);
    }

    public void warn(String message , Object ... args){
        logger.warn(message,args);
    }

    public void error(String message , Object ... args){
        logger.error(message,args);
    }

    public void trace(String message , Object ... args){
        logger.trace(message,args);
    }

}
