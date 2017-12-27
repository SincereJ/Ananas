package com.ananas.mn.core.engine.bean;

public class AnanasFile {
	
	private String filePath;
	private String fileContext;
	
	public AnanasFile(String filePath, String fileContext) {
		this.filePath = filePath;
		this.fileContext = fileContext;
	}
	
	
	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getFileContext() {
		return fileContext;
	}
	public void setFileContext(String fileContext) {
		this.fileContext = fileContext;
	}
	
}
