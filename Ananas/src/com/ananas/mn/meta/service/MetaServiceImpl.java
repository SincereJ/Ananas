package com.ananas.mn.meta.service;

import com.ananas.mn.meta.bean.MetaComponent;
import com.ananas.mn.meta.dao.MetaDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDao metaDao;

    @Override
    public List<MetaComponent> getAllComponentsAll(Map parameter) {
        List components = null;
        components = metaDao.getAll("metaComponent.getComponentsAll",parameter);
        return components;
    }
}
