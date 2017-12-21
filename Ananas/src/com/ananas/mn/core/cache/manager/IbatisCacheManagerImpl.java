package com.ananas.mn.core.cache.manager;

//import com.alibaba.druid.support.ibatis.SqlMapClientImplWrapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.ConcurrentHashMap;

public class IbatisCacheManagerImpl implements CacheManager {

    private static final String KEY_MEN_CACHE_VERSION = "ANANAS_JAVA_CACHE_VERSION";
    private String sqlQueryDbCacheVersion;
    private ConcurrentHashMap<Object , Object> versionMap = new ConcurrentHashMap<Object, Object>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DefaultSqlSession defaultSqlSession;

    @Override
    public synchronized void refresh() {
        defaultSqlSession.flushStatements();
        init();
    }

    @Override
    public boolean needRefresh() {
        String dbVersion = getDBCacheVersion();
        String memVerison = getMemCacheVersion();
        if (!memVerison.equals(dbVersion)) {
            return true;
        }
        return false;
    }

    @Override
    public void init() {
        versionMap.clear();
        setMemCacheVersion(getDBCacheVersion());
    }

    private void setMemCacheVersion(String version){
        versionMap.put(KEY_MEN_CACHE_VERSION,version);
    }

    private String getDBCacheVersion(){
        String version = (String) jdbcTemplate.queryForObject(this.sqlQueryDbCacheVersion,String.class);
        return version;
    }

    private String getMemCacheVersion(){
        String version = (String) versionMap.get(KEY_MEN_CACHE_VERSION);
        return version;
    }
}
