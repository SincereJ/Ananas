package com.ananas.mn.meta.wrap.wrapper;

import java.util.List;
import java.util.Map;

import com.ananas.mn.meta.wrap.interpreter.DivInterpreter;
import com.ananas.mn.meta.wrap.interpreter.imple.DivInterpreterImpl;

public class DivWrapper implements Wrapper {

    private String wrapperName = "div";
    private DivInterpreter divInterpreter = new DivInterpreterImpl();
    private List metaList = null;
    private Map meta = null;
    
    public String getWrapperName() {
        return wrapperName;
    }

    public void setWrapperName(String wrapperName) {
        this.wrapperName = wrapperName;
    }

    public Map getMeta() {
		return meta;
	}

	public void setMeta(Map meta) {
		this.meta = meta;
	}

	@Override
    public void init() {
    	
    }

    @Override
    public void begin() {
    	divInterpreter.parse(meta);
    }

    @Override
    public void end() {

    }
}
