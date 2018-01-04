package com.ananas.mn.meta.wrap.interpreter.imple;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		
		System.out.println(meta);
		
		String metaDivName = (String) meta.get("name");
		Map context = null;
		try {
			context = (Map) objectMapper.readValue(meta.get("context").toString(),Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp = (String) context.get("temp");
		Map prop = (Map) context.get("prop");
		
		int begin = temp.indexOf("@");
		int end = temp.lastIndexOf("@");
		
		String bRep = temp.substring(begin, end);
		bRep = "@"+bRep+"@";
		
		String rRep = "";
		
		Iterator  p = prop.entrySet().iterator();
		while(p.hasNext()) {
			Map.Entry<String, String> entry = (Entry<String, String>) p.next();
			rRep += entry.getKey()+"="+"'"+entry.getValue()+"' ";
		}
		
		temp.replaceAll(bRep, rRep);
		
		
		String nodepath = this.getClass().getClassLoader().getResource("/").getPath();   
    	String filePaths = nodepath.substring(1, nodepath.length() - 16);  
		
    	//pages/file.txt
    	
		AnanasFile ananasFile = new AnanasFile(filePaths + "pages/" +metaDivName + ".html" ,(String) temp);
		creator.create(ananasFile);
		
		return true;
	}

}
