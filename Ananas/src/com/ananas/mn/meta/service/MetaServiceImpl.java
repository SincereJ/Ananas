package com.ananas.mn.meta.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ananas.mn.meta.dao.MetaDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    @Transactional
    public int insertIntoMeta(Map parameterMap) {
    	return metaDao.insertIntoMeta("ananas.meta.insertIntoMeta", parameterMap);
    }
    
    @Override
    @Transactional
    public List getMetaList(Map parameterMap) {
    	return metaDao.getMetaList("ananas.meta.getMetaList", parameterMap);
    }
    
    @Override
    @Transactional
    public void saveMetaDivInst(Map parameterMap) throws JsonProcessingException {
    	Map configMeta = (Map) parameterMap.get("configMeta");
    	Map inst = (Map) parameterMap.get("inst");
		
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	String treeConfigJson =  objectMapper.writeValueAsString(configMeta.get("treeConfig"));
    	configMeta.put("treeConfig", treeConfigJson);
    	
    	String instContextJson = objectMapper.writeValueAsString(inst.get("context"));
    	inst.put("context", instContextJson);
			
    	metaDao.insertIntoMetaConfig("ananas.meta.insertIntoMetaConfig", configMeta);
    	metaDao.insertIntoMetaInst("ananas.meta.insertIntoMetaInst", inst);
    	
    }
    
    @Override
    public Map getMetaInstByName(Map parameterMap) {
    	return metaDao.getMetaInstByName("ananas.meta.getMetaInstByName",parameterMap);
    }
    
}
