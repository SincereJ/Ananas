package com.ananas.mn.meta.service;


import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MetaService {

    //public List<MetaComponent> getAllComponentsAll(Map parameter);
	
	public int insertIntoMeta(Map parameterMap) ;
	
	public List getMetaList(Map parameterMap);
	
	public void saveMetaDivInst(Map parameterMap) throws JsonProcessingException ; 
	
	public Map getMetaInstByName(Map parameterMap);
	
}
