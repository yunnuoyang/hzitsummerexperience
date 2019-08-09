package com.structs.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 上传文件的组件类
 */
public class FileUpLoad {
    private static Logger logger = Logger.getLogger(FileUpLoad.class);
    public static void fileUpLoad(Map<String, Object> session, File file, String fileFileName, String saveDirPath) throws IOException {
        //创建上传的文件的目录
        File saveDir=new File(saveDirPath);
        if(saveDir.exists()){
            saveDir.mkdir();
        }
        //将需要保存的文件存放进入saveDir目录中
        File saveFile = new File(Config.uploadFilePath, FileUtil.getUnqiueByName(fileFileName));
        if(!file.exists()){
            logger.info("没有可上传的文件");
            return ;
        }
        FileUtils.copyFile(file,saveFile);

    }

}
class FileUtil{
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static String getUnqiueByName(String filename){
        if(filename==null || filename.trim().length()==0){
            return "";
        }
        return format.format(new Date())+filename.substring(filename.lastIndexOf("."));
    }
}

