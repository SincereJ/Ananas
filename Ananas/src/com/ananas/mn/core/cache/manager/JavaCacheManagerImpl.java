package com.ananas.mn.core.cache.manager;

import com.ananas.mn.core.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.Key;
import java.util.concurrent.ConcurrentHashMap;

public class JavaCacheManagerImpl implements CacheManager {

    private static final String KEY_MEN_CACHE_VERSION = "ANANAS_JAVA_CACHE_VERSION";
    private String sqlQueryDbCacheVersion;
    private ConcurrentHashMap<Object , Object> versionMap = new ConcurrentHashMap<Object, Object>();

    @Autowired
    private Cache<Object, Object> cache;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cache<Object, Object> getCache() {
        return cache;
    }

    public void setCache(Cache<Object, Object> cache) {
        this.cache = cache;
    }

    @Override
    public synchronized void refresh() {
        cache.clear();
        init();
    }

    @Override
    public boolean needRefresh() {
        String dbVersion = getDBCacheVersion();
        String memVersion = getMemCacheVersion();
        if(!memVersion.equals(dbVersion)){
            return true;
        }
        return false;
    }

    @Override
    public void init() {
        versionMap.clear();
        setMemCacheVersion(getDBCacheVersion());
    }

    private String getDBCacheVersion(){
        String version = (String)jdbcTemplate.queryForObject(this.sqlQueryDbCacheVersion,String.class);
        return version;
    }

    private void setMemCacheVersion(String version){
        versionMap.put(KEY_MEN_CACHE_VERSION,version);
    }

    private String getMemCacheVersion(){
        String version = (String) versionMap.get(KEY_MEN_CACHE_VERSION);
        return version;
    }


}
