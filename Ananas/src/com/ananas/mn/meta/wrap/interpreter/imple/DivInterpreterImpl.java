package com.ananas.mn.meta.wrap.interpreter.imple;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ananas.mn.core.common.JsonUtil;
import com.ananas.mn.core.engine.Creator;
import com.ananas.mn.core.engine.FileCreatorImpl;
import com.ananas.mn.core.engine.bean.AnanasFile;
import com.ananas.mn.meta.wrap.interpreter.DefaultInterpreter;
import com.ananas.mn.meta.wrap.interpreter.DivInterpreter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DivInterpreterImpl extends DefaultInterpreter implements DivInterpreter{
	
	private Creator creator = new FileCreatorImpl();
	
	@Override
	public boolean parse(List metaList) {		
		return false;
	}
	
	public boolean parse(Map meta) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String metaDivName = (String) meta.get("name");
		String metaTemp = (String) meta.get("temp");
		Map metaProp = (Map) JsonUtil.parse(meta.get("prop").toString(), Map.class);
		
		
		int begin = metaTemp.indexOf("@");
		int end = metaTemp.lastIndexOf("@");
		
		String bRep = metaTemp.substring(begin, end) + "@";
		String rRep = "";
		
		@SuppressWarnings("rawtypes")
		Iterator  p = metaProp.entrySet().iterator();
		while(p.hasNext()) {
			Map.Entry<String, String> entry = (Entry<String, String>) p.next();
			rRep += entry.getKey()+"="+"'"+entry.getValue()+"' ";
		}
		
		String instMetaTemp = metaTemp.replaceAll(bRep, rRep);		
		String nodepath = this.getClass().getClassLoader().getResource("/").getPath();   
    	String filePaths = nodepath.substring(1, nodepath.length() - 16);  
		
    	//pages/file.txt
    	
		AnanasFile ananasFile = new AnanasFile(filePaths + "pages/" +metaDivName + ".html" ,(String) instMetaTemp);
		creator.create(ananasFile);
		
		return true;
	}

}
