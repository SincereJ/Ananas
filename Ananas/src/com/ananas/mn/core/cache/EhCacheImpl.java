package com.ananas.mn.core.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


public class EhCacheImpl implements  Cache<Object , Object> {

    private Ehcache ehcache;

    public Ehcache getEhcache() {
        return ehcache;
    }

    public void setEhcache(Ehcache ehcache) {
        this.ehcache = ehcache;
    }

    @Override
    public Object put(Object key, Object value) {
        Element element = new Element(key,value);
        ehcache.put(element);
        return value;
    }

    @Override
    public Object put(Object key, Object value, Date expiry) {
        return put(key, value);
    }

    @Override
    public Object put(Object key, Object value, int TTL) {
        return put(key, value);
    }

    @Override
    public Object get(Object key) {
        Element element = ehcache.get(key);
        if(element != null){
            return element.getObjectValue();
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        return ehcache.remove(key);
    }

    @Override
    public boolean clear() {
        ehcache.removeAll();
        return true;
    }

    @Override
    public int size() {
        return ehcache.getSize();
    }

    @Override
    public Set<Object> keySet() {
        Set<Object> set = new CopyOnWriteArraySet<Object>();
        set.addAll(ehcache.getKeys());
        return set;
    }

    @Override
    public Collection<Object> values() {
        List<Object> list = new ArrayList<Object>();
        List keys = ehcache.getKeys();
        for (Iterator<Object> iter = keys.iterator(); iter.hasNext();) {
            Serializable key = (Serializable) iter.next();
            Element element = ehcache.get(key);
            if (element != null) {
                list.add(element.getObjectValue());
            }
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return this.ehcache.get(key) != null;
    }

    @Override
    public void destory() {
        ehcache.removeAll();
        ehcache = null;
    }
}
