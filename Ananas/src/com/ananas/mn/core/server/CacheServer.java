package com.ananas.mn.core.server;

import com.ananas.mn.core.cache.Cache;
import com.ananas.mn.core.client.BaseJdbcTemplateClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheServer extends DefaultServer {

    private Cache cache ;
    private ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    @Autowired
    private BaseJdbcTemplateClient baseJdbcTemplateClient;

    public CacheServer(Cache cache){
        this.cache = cache;
    }

    @Override
    public void init() {
        concurrentHashMap.put("testString",baseJdbcTemplateClient.getTestString());
    }

    @Override
    public void start() {
        Iterator iterator = concurrentHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map m = (Map) iterator.next();
            cache.put("testString",m.get("testString"));
        }
    }

    @Override
    public void stop() {
        concurrentHashMap = null;
        cache = null;
    }
}
