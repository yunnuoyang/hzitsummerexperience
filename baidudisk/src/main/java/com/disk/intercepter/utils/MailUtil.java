package com.disk.intercepter.utils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {
	private String from;
	private String to;
	private String subject;
	private String smtpServer;
	public void setFrom(){
		
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setSmtpServer(String stmpServer) {
		this.smtpServer = stmpServer;
	}
	/**
	 * �����ʼ�
	 * @param content
	 * @return
	 */
	public boolean sendMail(String content) {

        try {
//****************************�����Ự***************************************
            Properties props = new Properties();
//            props.put("mail.transport.protocol", "smtp"); //�����ʼ�������������Э�飨����ʡ�ԣ�
            props.put("mail.smtp.host", smtpServer.trim()); //���÷�����������ַ
           // props.put("mail.smtp.port", "25"); //�����ʼ�����ʹ�õ� �˿ںţ�����ʡ�ԣ�
            Session mailsession = Session.getInstance(props); //���Ĭ�ϵ�session����

//*****************************������Ϣ***************************************
            Message msg = new MimeMessage(mailsession);

            msg.setFrom(new InternetAddress(from)); //���÷����˵�ַ new InternetAdress()���������˵�ַ����
            msg.setRecipients(Message.RecipientType.TO,
                              InternetAddress.parse(to)); //�����ռ��˵�ַ���涨������
            msg.setSentDate(new Date()); //���÷���ʱ��
            msg.setSubject(subject); //��������
           // msg.setText(body); //���� ����
            msg.setContent(content, "text/html;charset= GB2312");//���� �����ʼ�����ΪHTML����,��Ϊ���ı���

//*******************************������Ϣ********************************
            Transport.send(msg); //������Ϣ
            msg.writeTo(System.out);//������Ϣ ���ڿ���̨ ��ʾ��Ϣ������������Ϣ
            System.out.println("�ʼ��ѳɹ����͵� " + to);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }
	
	
}
