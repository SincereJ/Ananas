package com.ananas.mn.core.cache;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ananas.mn.core.client.DefaultJdbcTemplateClient;

public class CacheProxy extends EhCacheImpl {

    //private BaseJdbcTemplateClient baseJdbcTemplateClient = new DefaultJdbcTemplateClient();
	
	public static CacheProxy getCacheProxyInstance() {
		return cp.getCpIns();
	}
	
	public void initCache() {
		CacheUtils.put("aa", "aa");
		CacheUtils.put("bb", "bb");
		CacheUtils.put("cc", "cc");
		CacheUtils.put("dd", "dd");
	}
	
	public void loadCache() {
		List cacheList = DefaultJdbcTemplateClient.getAllCache();
		
		Iterator iterator = cacheList.iterator();
		while(iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String key = (String) map.get("name");
			String value = (String) map.get("value");
			CacheUtils.put(key, value);
		}		
	}
	
	public void destoryCache() {
		//cacheManager.removalAll();
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
