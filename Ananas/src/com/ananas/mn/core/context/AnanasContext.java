package com.ananas.mn.core.context;

import com.ananas.mn.core.log.Log;
import com.ananas.mn.core.server.CacheServer;
import com.ananas.mn.core.server.ConfigServer;


public class AnanasContext implements Context{
    protected transient final Log log = Log.getLogger(AnanasContext.class);



    
    CacheServer cacheServer = new CacheServer();;
    ConfigServer configServer = new ConfigServer();

    @Override
    public void init() {
    	
    	cacheServer.init();
    	
    	configServer.init();

    }

    @Override
    public void start() {
        cacheServer.start();
        configServer.start();

    }

    @Override
    public void stop() {
        cacheServer.stop();
        configServer.stop();
    }
}
