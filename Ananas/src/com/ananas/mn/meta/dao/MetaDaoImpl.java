package com.ananas.mn.meta.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ananas.mn.core.client.BaseJdbcTemplateClient;

@Repository
public class MetaDaoImpl extends BaseJdbcTemplateClient implements MetaDao {

	@Resource
	private SqlSessionTemplate sqlMapClientTemplate;
	
    @Override
    public List<Object> getAll(String sqlId , Map paramterMap){
        List all = null;
        //sqlMapClientTemplate.insert(sqlId, paramterMap);

        return null;
    }
    
    @Override
    public int insertIntoMeta(String sqlId, Map parameterMap) {
    	return sqlMapClientTemplate.insert(sqlId, parameterMap);
    }
    
    @Override
    public List getMetaList(String sqlId, Map parameterMap) {
    	return sqlMapClientTemplate.selectList(sqlId, parameterMap);
    }
    
    @Override
    public int insertIntoMetaConfig(String sqlId, Map parameterMap) {
    	return sqlMapClientTemplate.insert(sqlId, parameterMap);
    }
    
    @Override
    public int insertIntoMetaInst(String sqlId, Map parameterMap) {
    	return sqlMapClientTemplate.insert(sqlId, parameterMap);
    }
    
    @Override
    public Map getMetaInstByName(String sqlId, Map parameterMap) {
    	
    	return sqlMapClientTemplate.selectOne(sqlId, parameterMap);
    }
}
