package com.ananas.mn.cache;

import org.junit.Test;

import com.ananas.mn.core.cache.CacheProxy;

public class CacheTest {
	
	@Test
	public void ct () {
		CacheProxy cacheProxy = CacheProxy.getCacheProxyInstance();
		
		String s = (String) cacheProxy.get("testString");
		System.out.println(s);
	}
	

}
