package com.ananas.mn.core.cache.manager;

public interface CacheManager {

    public void refresh();
    public boolean needRefresh();
    public void init();
}
