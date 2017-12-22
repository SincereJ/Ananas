package com.ananas.mn.core.server;

import com.ananas.mn.core.cache.CacheProxy;
import com.ananas.mn.core.client.DefaultJdbcTemplateClient;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Iterator;


public class CacheServer extends DefaultServer {

	//private Cache cache;
    //private CacheManager cacheManager = CacheManager.create();
    private DefaultJdbcTemplateClient defaultJdbcTemplateClient = new DefaultJdbcTemplateClient();
    
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
    	
    	cacheProxy.createCache();
    }

	@Override
    public void start() {
		cacheProxy.initCache();
    }

    @Override
    public void stop() {
    	cacheProxy.destoryCache();
    }
}
