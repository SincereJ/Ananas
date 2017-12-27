package com.ananas.mn.meta.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ananas.mn.meta.dao.MetaDao;

@Service
public class MetaServiceImpl implements MetaService {

    @Resource
    private MetaDao metaDao;

    //@Override
    //public List<MetaComponent> getAllComponentsAll(Map parameter) {
    //    List components = null;
    //    components = metaDao.getAll("metaComponent.getComponentsAll",parameter);
    //    return components;
    //}
    
    @Override
    public int insertIntoMeta(Map parameterMap) {
    	return metaDao.insertIntoMeta("ananas.meta.insertIntoMeta", parameterMap);
    }
}
