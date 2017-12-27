package com.ananas.mn.core.engine;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ananas.mn.core.engine.bean.AnanasFile;

public class FileCreatorProxy {

	private Creator creator = new FileCreatorImpl();
	private AnanasFile ananasFile ;

	
	public void progress(List fileList) {
		
		String nodepath = this.getClass().getClassLoader().getResource("/").getPath();   
    	String filePaths = nodepath.substring(1, nodepath.length() - 16);  
		
		if(fileList == null) {
			return ;
		}
		
		Iterator iterator = fileList.iterator();
		while(iterator.hasNext()) {
			Map map = (Map) iterator.next();
			ananasFile = new AnanasFile(filePaths + map.get("path").toString(),(String) map.get("context"));
			creator.create(ananasFile);
		}
		
	}
}
