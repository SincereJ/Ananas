package com.ananas.mn.meta.wrap.regist;

import com.ananas.mn.meta.wrap.manager.WrapManager;
import com.ananas.mn.meta.wrap.wrapper.Wrapper;

public interface Register {

    public void add(WrapManager wrapManager, String wrapperName, Wrapper wrapper);

    public void remove(WrapManager wrapManager, String wrapperName);



}
