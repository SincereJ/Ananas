package com.ananas.mn.core.server;

import com.ananas.mn.core.client.DefaultJdbcTemplateClient;
import com.ananas.mn.core.spring.SpringBeanInvoker;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Map;

public class CacheServer extends DefaultServer {

	private Cache cache;
    private CacheManager cacheManager = CacheManager.create();
    private DefaultJdbcTemplateClient defaultJdbcTemplateClient = new DefaultJdbcTemplateClient();

    private static final String SYS_CACHE = "sysCache";
    
    @Override
    public void init() {
    	//cacheManager.init();
    	//cache = cacheManager.getCache();
    	//cache.put("testString",baseJdbcTemplateClient.getTestString());
    	
    	Cache simpleCache = new Cache(SYS_CACHE, 5000, false, false, 5, 2); 
    	cacheManager.addCache(simpleCache);
    	cache = cacheManager.getCache(SYS_CACHE);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start() {
    	
    	cache.put(new Element("testString","testString"));
    	
        @SuppressWarnings("rawtypes")
		Iterator iterator = cache.getKeys().iterator();
        while(iterator.hasNext()){
           System.out.println(iterator.next());
        }
    }

    @Override
    public void stop() {
    	cacheManager.removalAll();
    }
}
