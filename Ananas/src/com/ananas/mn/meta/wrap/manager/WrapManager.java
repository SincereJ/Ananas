package com.ananas.mn.meta.wrap.manager;

import com.ananas.mn.meta.wrap.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WrapManager {

    private ConcurrentMap<String,Wrapper> wrapList = new ConcurrentHashMap<String,Wrapper>();

    public void setWrapList(ConcurrentMap<String, Wrapper> wrapList) {
        this.wrapList = wrapList;
    }

    public ConcurrentMap<String, Wrapper> getWrapList() {
        return wrapList;
    }
}
