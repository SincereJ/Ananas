package com.ananas.mn.core.context;

import com.ananas.mn.core.cache.Cache;
import com.ananas.mn.core.cache.EhCacheImpl;
import com.ananas.mn.core.config.Config;
import com.ananas.mn.core.config.ConfigFactory;
import com.ananas.mn.core.log.Log;
import com.ananas.mn.core.server.CacheServer;
import com.ananas.mn.core.server.Server;

import java.util.Map;

public class AnanasContext implements Context{
    protected transient final Log log = Log.getLogger(AnanasContext.class);


    private Map<String,Server> servers;
    private Config config;

    private Cache cache;
    CacheServer cacheServer;

    @Override
    public void init() {
        cache = new EhCacheImpl();
        config = ConfigFactory.getDefaultConfig();
        servers = config.getConfig();

    }

    @Override
    public void start() {

        cacheServer = new CacheServer(cache);
        cacheServer.start();

        for(Server server : servers.values()){
            server.start();
        }

    }

    @Override
    public void stop() {
        cacheServer.stop();
    }
}
