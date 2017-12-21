package com.ananas.mn.core.engine;

import com.ananas.mn.core.engine.bean.AsFile;

import com.ananas.mn.core.log.Log;
import org.apache.log4j.Logger;

import java.io.*;

public class FileCreatorImpl implements FileCreator {

    private static final Log log = Log.getLogger(FileCreatorImpl.class);

    @Override
    public boolean create(AsFile asFile) {
        String filePath = asFile.getPath() + "\\" +asFile.getName() + "." + asFile.getExtendName();

        File file = new File(filePath);
        if (file.exists()) {// 判断文件是否存在
            log.warn("目标文件已存在" + filePath);
            return false;
        }
        if (filePath.endsWith(File.separator)) {// 判断文件是否为目录
            log.warn("目标文件不能为目录！");
            return false;
        }
        if (!file.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
            // 如果目标文件所在的文件夹不存在，则创建父文件夹
            if (!file.getParentFile().mkdirs()) {// 判断创建目录是否成功
                log.warn("创建目标文件所在的目录失败！");
                return false;
            }
        }
        try {
            if (file.createNewFile()) {// 创建目标文件

                log.warn("创建文件成功:" + filePath);
                writeFileContent(filePath,asFile.getContent());
                return true;
            } else {
                log.warn("创建文件失败！");
                return false;
            }
        } catch (IOException e) {// 捕获异常
            e.printStackTrace();
            log.warn("创建文件失败！" + e.getMessage());
            return false;
        }
    }

    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
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
