package com.ananas.mn.core.server;

import java.util.List;

import com.ananas.mn.core.cache.CacheUtils;
import com.ananas.mn.core.engine.FileCreatorProxy;

public class EngineServer extends DefaultServer {

	private FileCreatorProxy fileCreatorProxy = new FileCreatorProxy();
	
	private List fileList ;
	
	public void init() {
		
	}
	
	public void start() {
		fileList = (List) CacheUtils.get("file_list");
		fileCreatorProxy.progress(fileList);

	}
	
	public void stop() {
		fileList = null;
	}
	
	
}
