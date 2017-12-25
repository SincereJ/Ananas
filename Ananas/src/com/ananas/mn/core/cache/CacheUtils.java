package com.ananas.mn.core.cache;

import com.ananas.mn.core.spring.SpringBeanInvoker;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheUtils {

	private static CacheManager cacheManager = ((CacheManager) SpringBeanInvoker.getBean("cacheManager"));

	private static final String SYS_CACHE = "sysCache";

	public static Object get(String key) {
		return get(SYS_CACHE, key);
	}

	public static void put(String key, Object value) {
		put(SYS_CACHE, key, value);
	}

	public static void remove(String key) {
		remove(SYS_CACHE, key);
	}

	public static Object get(String cacheName, String key) {
		Element element = (Element) getCache(cacheName).get(key);
		return element == null ? null : element.getObjectValue();
	}

	public static void put(String cacheName, String key, Object value) {
		Element element = new Element(key, value);
		getCache(cacheName).put(element);
	}

	public static void remove(String cacheName, String key) {
		getCache(cacheName).remove(key);
	}

	private static net.sf.ehcache.Cache getCache(String cacheName) {
		net.sf.ehcache.Cache cache = (net.sf.ehcache.Cache) cacheManager.getCache(cacheName);
		if (cache == null) {
			cacheManager.addCache(cacheName);
			cache = (net.sf.ehcache.Cache) cacheManager.getCache(cacheName);
			cache.getCacheConfiguration().setEternal(true);
		}
		return cache;
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}

}
