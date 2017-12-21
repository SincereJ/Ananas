package com.ananas.mn.meta.wrap.regist;

import com.ananas.mn.meta.wrap.manager.WrapManager;
import com.ananas.mn.meta.wrap.wrapper.Wrapper;

public class DefaultRegister implements Register {

    @Override
    public void add(WrapManager wrapManager,  String wrapperName,  Wrapper wrapper) {
        wrapManager.getWrapList().put(wrapperName,wrapper);
    }

    @Override
    public void remove(WrapManager wrapManager, String wrapperName) {
        wrapManager.getWrapList().remove(wrapperName);
    }
}
