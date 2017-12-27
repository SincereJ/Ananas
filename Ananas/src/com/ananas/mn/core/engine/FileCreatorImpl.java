package com.ananas.mn.core.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.ananas.mn.core.engine.bean.AnanasFile;
import com.ananas.mn.core.log.Log;

public class FileCreatorImpl implements FileCreator {

    private static final Log log = Log.getLogger(FileCreatorImpl.class);

    @Override
    public boolean create(AnanasFile ananasFile) {
    	//String nodepath = this.getClass().getClassLoader().getResource("/").getPath();   
    	//String filePaths = nodepath.substring(1, nodepath.length() - 16);  
    	
    	//System.out.println(filePaths);
        	
    	String filePath = "" + ananasFile.getFilePath();
    	
    	//add by jxx
    	System.out.println(filePath);
    	
        File file = new File(filePath);
        if (file.exists()) {
            //return false;
        	file.delete();
        }
        if (filePath.endsWith(File.separator)) {
            return false;
        }
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                return false;
            }
        }
        try {
            if (file.createNewFile()) {
                writeFileContent(file ,ananasFile.getFileContext());
                return true;
            } else {        
                return false;
            }
        } catch (IOException e) {
            //e.printStackTrace();  
        	log.warn("", e);
            return false;
        }
    }

  
    public static boolean writeFileContent(File file, String fileContext) throws IOException{
        Boolean bool = false;
        String filein = fileContext+"\r\n";
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            //File file = new File(filepath);

            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
           
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);             
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
         
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }

}
