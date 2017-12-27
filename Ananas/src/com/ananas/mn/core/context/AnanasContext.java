package com.ananas.mn.core.context;

import com.ananas.mn.core.log.Log;
import com.ananas.mn.core.server.CacheServer;
import com.ananas.mn.core.server.ConfigServer;
import com.ananas.mn.core.server.EngineServer;


public class AnanasContext implements Context{
    protected transient final Log log = Log.getLogger(AnanasContext.class);



    
    CacheServer cacheServer = new CacheServer();;
    ConfigServer configServer = new ConfigServer();
    EngineServer engineServer =  new EngineServer();

    @Override
    public void init() {
    	
    	cacheServer.init();
    	
    	configServer.init();
    	
    	engineServer.init();

    }

    @Override
    public void start() {
        cacheServer.start();
        configServer.start();
        engineServer.start();

    }

    @Override
    public void stop() {
        cacheServer.stop();
        configServer.stop();
        engineServer.stop();
    }
}
