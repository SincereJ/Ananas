package com.ananas.mn.meta.wrap.wrapper;

import java.util.List;

import com.ananas.mn.meta.wrap.interpreter.Interpreter;
import com.ananas.mn.meta.wrap.interpreter.imple.DivInterpreter;

public class DivWrapper implements Wrapper {

    private String wrapperName = "div";
    private Interpreter divInterpreter = new DivInterpreter();
    private List metaList = null;
    
    public String getWrapperName() {
        return wrapperName;
    }

    public void setWrapperName(String wrapperName) {
        this.wrapperName = wrapperName;
    }

    @Override
    public void init() {
    	
    }

    @Override
    public void begin() {
    	
    }

    @Override
    public void end() {

    }
}
