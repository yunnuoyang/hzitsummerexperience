package com.disk.controller;

import com.disk.intercepter.utils.Config;
import com.disk.intercepter.utils.FileUpLoad;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
public class FileAction extends BaseController {
    private File file;
    private String fileFileName;
    private String filename;//提供get方法给框架再下载时候可以使用此名称进行流文件名称的赋值
    public String upload(){
        try {
            FileUpLoad.fileUpLoad(session,file,fileFileName,Config.uploadFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public  String down(){
        System.out.println("====================="+filename);
        return SUCCESS;
    }

    public String fileList(){
        File file = new File(Config.uploadFilePath);
        File[] files = file.listFiles();
        System.out.println(">>>>>===="+files.length);
        //文件列表 放入request
        request.put("files",files);
        return SUCCESS;
    }

    /**
     * 输入流
     * @return
     * setter 和 getter
     * ${action.myInput}----getMyInput()
     */
    public InputStream getMyInput(){
        File file = new File(Config.uploadFilePath,filename);
        if(file.exists()==false){
            throw new RuntimeException("文件不存在！");
        }
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public String getFilename() {
        return filename;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public File getFile() {
        return file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
