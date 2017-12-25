package com.ananas.mn.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

public class FileTest {

	
	@Test
	public void createFile() throws IOException {
		File file = new File("WebContent/WEB-INF/jsp/file.txt");
		//System.out.println(file);
		
		//System.getProperty("user.dir");
		
		//URL webAppRootKey = FileTest.class.getClassLoader().getResource("");
		//String webAppRootKey = System.getProperty("user.dir");
		//System.out.println(webAppRootKey);
		
		//File file = new File(webAppRootKey+"/WebContent/WEB-INF/jsp/file.txt");
		file.createNewFile();
	}
	
}
