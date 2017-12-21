package com.ananas.mn.core.context;

import com.ananas.mn.core.config.Config;
import com.ananas.mn.core.config.DefaultConfig;
import com.ananas.mn.core.log.Log;
import com.ananas.mn.core.server.CacheServer;
import com.ananas.mn.core.server.Server;

import java.util.Map;

public class AnanasContext implements Context{
    protected transient final Log log = Log.getLogger(AnanasContext.class);


    //private Map<String,Server> servers;
    //private Config config = new DefaultConfig();

    
    CacheServer cacheServer = new CacheServer();;

    @Override
    public void init() {
    	
    	cacheServer.init();
    	
        //config = ConfigFactory.getDefaultConfig();
        //servers = config.getConfig();

    }

    @Override
    public void start() {
        cacheServer.start();

        /*for(Server server : servers.values()){
            server.start();
        }*/

    }

    @Override
    public void stop() {
        cacheServer.stop();
    }
}
