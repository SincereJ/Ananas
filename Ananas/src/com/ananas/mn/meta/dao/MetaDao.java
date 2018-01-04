package com.ananas.mn.meta.dao;

import java.util.List;
import java.util.Map;

public interface MetaDao {

    public List<Object> getAll(String sqlId , Map parameterMap);

    
    public int insertIntoMeta(String sqlId, Map parameterMap);
    
    
    public List getMetaList(String sqlId, Map parameterMap);
    
    public int insertIntoMetaConfig(String sqlId, Map parameterMap);
    
    public int insertIntoMetaInst(String sqlId,  Map parameterMap);
    
    public Map getMetaInstByName(String sqlId, Map parameterMap);
}
