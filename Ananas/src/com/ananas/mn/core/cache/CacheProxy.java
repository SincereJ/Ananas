package com.ananas.mn.core.cache;

import java.util.Iterator;

import org.springframework.cache.ehcache.EhCacheCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheProxy extends EhCacheImpl {


	private Cache cache = (Cache) getEhcache();
    private CacheManager cacheManager = CacheManager.create();
    private static final String SYS_CACHE = "sysCache";
    
	public static CacheProxy getCacheProxyInstance() {
		return cp.getCpIns();
	}
	
	public void initCache() {
		cache.put(new Element("testString","testString"));
    	
        @SuppressWarnings("rawtypes")
		Iterator iterator = cache.getKeys().iterator();
        while(iterator.hasNext()){
           System.out.println(iterator.next());
        }
	}
	
	public void createCache() {
		Cache simpleCache = new Cache(SYS_CACHE, 5000, false, false, 5, 2);
    	cacheManager.addCache(simpleCache);
    	cache = cacheManager.getCache(SYS_CACHE);
	}
	
	public void destoryCache() {
		cacheManager.removalAll();
	}
	
	
	private static class cp {
		private static CacheProxy cacheProxy;
		
		public static CacheProxy getCpIns() {
			if(cacheProxy == null) {
				cacheProxy= new CacheProxy();	
			}
			return cacheProxy;
		}
		
	}

}
