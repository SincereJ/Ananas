package com.ananas.mn.core.server;

import com.ananas.mn.core.cache.CacheProxy;
//import com.ananas.mn.core.client.DefaultJdbcTemplateClient;

public class CacheServer extends DefaultServer {

	//private Cache cache;
    //private CacheManager cacheManager = CacheManager.create();
    //private DefaultJdbcTemplateClient defaultJdbcTemplateClient = new DefaultJdbcTemplateClient();
    
    //private static final String SYS_CACHE = "sysCache";
    
    private CacheProxy cacheProxy = CacheProxy.getCacheProxyInstance();
    
    @Override
    public void init() {
    	//cacheManager.init();
    	//cache = cacheManager.getCache();
    	//cache.put("testString",baseJdbcTemplateClient.getTestString());
    	
    	//Cache simpleCache = new Cache(SYS_CACHE, 5000, false, false, 5, 2);
    	//cacheManager.addCache(simpleCache);
    	//cache = cacheManager.getCache(SYS_CACHE);
    	
    	cacheProxy.initCache();
    }

	@Override
    public void start() {
		cacheProxy.loadCache();
		cacheProxy.loadFileCache();
    }

    @Override
    public void stop() {
    	//cacheProxy.destoryCache();
    }
}
