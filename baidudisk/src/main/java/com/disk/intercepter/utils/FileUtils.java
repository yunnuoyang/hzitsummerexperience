package com.disk.intercepter.utils;
import java.io.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy年MM月dd日");
    public static String getUnqiueByName(String filename){
        if(filename==null || filename.trim().length()==0){
            return "";
        }
        return format.format(new Date())+filename.substring(filename.lastIndexOf("."));
    }
    public static String loadEmailContent(String fileName) {
        try {
            fileName = fileName.startsWith("/")?fileName:"/"+fileName;
            InputStreamReader isr  = new  InputStreamReader(MailSend.class.getResourceAsStream(fileName),"utf-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s=br.readLine())!=null) {
                //通过读取当前的环境变量，得到当前系统的换行符
                sb.append(s).append("<br>");
//				sb.append(s).append(System.getProperties().getProperty("line.separator"));
            }
            br.close();

            String content = replace(sb.toString());

            System.out.println(content);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    private static String replace(String content){

        String date = formatDate.format(new Date());
        return content.replace(",date,", date);

    }

    /**
     * 计算文件的MD5
     * @param filename
     * @return
     * @throws Exception
     */
    private static byte[] createChecksum(String filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);

        MessageDigest complete = MessageDigest.getInstance("MD5");

        byte[] buffer;
        int size = fis.available();
        //如果文件小于20M
        if(size>=0 && size<20480){
            buffer=new byte[size];

            fis.read(buffer);
//            buffer = bis.readAllBytes();
            complete.update(buffer);//使用指定的字节数组更新摘要
        }else {
            buffer = new byte[10240];
            int numRead;
            do {
                numRead = bis.read(buffer);
                if (numRead > 0) {
                    complete.update(buffer, 0, numRead);//使用指定的字节数组更新摘要
                }
            } while (numRead != -1);
        }
        fis.close();
        return complete.digest();
    }

    public static String getMD5(File file) throws Exception {
        return getMD5Checksum(file.getAbsolutePath());
    }
    public static String getMD5Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }
}
