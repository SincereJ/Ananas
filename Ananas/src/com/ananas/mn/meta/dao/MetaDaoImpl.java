package com.ananas.mn.meta.dao;

import com.ananas.mn.core.client.BaseJdbcTemplateClient;
import com.ananas.mn.meta.bean.MetaComponent;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class MetaDaoImpl extends BaseJdbcTemplateClient implements MetaDao {

    @Override
    public List<Object> getAll(String sqlId , Map paramterMap){
        List all = null;
        all = jdbcTemplate.queryForList(sqlId ,paramterMap);
        if(all != null && all.size() != 0){
            return all;
        }

        return null;
    }
}
