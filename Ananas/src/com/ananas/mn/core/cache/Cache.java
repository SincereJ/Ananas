package com.ananas.mn.core.cache;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

public interface Cache<K,V> {

    public V put(K key ,V value);

    public V put(K key , V value , Date expiry);

    public V put(K key , V value , int TTL);

    public V get(K key);

    public V remove(K key);

    public boolean clear();

    public int size();

    public Set<K> keySet();

    public Collection<V> values();

    public boolean containsKey(K key);

    public void destory();
}
