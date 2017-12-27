package com.ananas.mn.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.ananas.mn.core.engine.Creator;
import com.ananas.mn.core.engine.FileCreatorImpl;

public class FileTest {

	
	@Test
	public void createFile() throws IOException {
		//File file = new File("WebContent/pages/file.txt");
		
		//Creator fileCreator = new FileCreatorImpl();
		//System.out.println(file);
		
		//System.getProperty("user.dir");
		
		//URL webAppRootKey = FileTest.class.getClassLoader().getResource("");
		//String webAppRootKey = System.getProperty("user.dir");
		String webAppRootKey = this.getClass().getClassLoader().getResource("").getPath();
		int index = webAppRootKey.lastIndexOf("Ananas");
		webAppRootKey = webAppRootKey.substring(0, index+6);
		//String webAppRootKey = this.getClass().getResource("").getPath();
		System.out.println(webAppRootKey);
		
		//File file = new File(webAppRootKey+"/WebContent/WEB-INF/jsp/file.txt");
		
		//AnanasFile ananasFile = new AnanasFile(file,"ssssssssssssffffffffffffffffffffdd");
		//fileCreator.create(ananasFile);		
	}
	
}
