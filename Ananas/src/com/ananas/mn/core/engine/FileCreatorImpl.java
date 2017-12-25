package com.ananas.mn.core.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.ananas.mn.core.log.Log;

public class FileCreatorImpl implements FileCreator {

    private static final Log log = Log.getLogger(FileCreatorImpl.class);

    @Override
    public boolean create(File asFile) {
        String filePath = asFile.getPath() + "\\" +asFile.getName() ;

        File file = new File(filePath);
        if (file.exists()) {
     
            return false;
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

  
                writeFileContent(filePath,"");
                return true;
            } else {
            
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
  
            return false;
        }
    }

  
    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);

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
