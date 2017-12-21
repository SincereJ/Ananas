package com.ananas.mn.meta.dao;

import com.ananas.mn.meta.bean.MetaComponent;

import java.util.List;
import java.util.Map;

public interface MetaDao {

    public List<Object> getAll(String sqlId , Map parameterMap);

}
