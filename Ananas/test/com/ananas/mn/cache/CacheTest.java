package com.ananas.mn.cache;

import org.junit.Test;

import com.ananas.mn.core.cache.CacheProxy;
import com.ananas.mn.core.cache.CacheUtils;

public class CacheTest {
	
	@Test
	public void ct () {
		CacheUtils.put("a", "a");
		
		String s = (String) CacheUtils.get("a");
		System.out.println(s);
	}
	

}
