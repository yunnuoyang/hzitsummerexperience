package com.disk.intercepter.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MailSend {
	private static String content;
	private static String userName = "张三";
	private static String date;

	/**
	 * 载入
	 */

	public static void main(String[] args) {
		MailUtil email = new MailUtil();
		email.setFrom("yangjunnuo@qq.com");
		email.setTo("fengchuang0706@qq.com");
		email.setSubject("这是我的主题3");
//		email.setSmtpServer("127.0.0.1");

//		String str = "<a href=\"http://127.0.0.1:8080/myweb/act.jsp?code=dfde3dfdsf3dfbhg\">点击这里激活</a>";
//		LoadEmailContent("src/mail.txt");
		System.out.println("***********************");
//		content = content.replaceAll(",url,",str);

		email.sendMail(content);


	}

	private static void LoadEmailContent(String fileName) {
//		String fileName = sc.getRealPath("/WEB-INF/classes/mail.txt");
//		this.getClass().getResourceAsStream(fileName);
//		new FileReader(new File());
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String s;
			while ((s=br.readLine())!=null) {
				//通过读取当前的环境变量，得到当前系统的换行符
				sb.append(s).append("<br>");
//				sb.append(s).append(System.getProperties().getProperty("line.separator"));
			}
			br.close();

			content = replace(sb.toString());
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static String replace(String content){
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		date = format.format(new Date());
		return content.replace(",date,", date).replace(",name,", userName);

	}

}
