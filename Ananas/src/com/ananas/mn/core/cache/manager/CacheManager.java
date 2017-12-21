package com.ananas.mn.core.cache.manager;

import com.ananas.mn.core.cache.Cache;

public interface CacheManager {

    public void refresh();
    public boolean needRefresh();
    public void init();
    
}
