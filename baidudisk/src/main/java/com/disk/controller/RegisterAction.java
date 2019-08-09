package com.disk.controller;

import com.disk.intercepter.service.IRegister;
import com.disk.intercepter.utils.RandActiveCode;
import com.disk.intercepter.utils.SendMail;
import com.disk.intercepter.pojo.Netuser;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class RegisterAction extends BaseController implements ModelDriven<Netuser> {
    Logger logger=Logger.getLogger(RegisterAction.class);
    private Netuser netuser=new Netuser();
    @Autowired
    private IRegister register;
    public void setNetuser(Netuser netuser) {
        this.netuser = netuser;
    }
    public String register(){
        //拿到session中的激活码
        System.out.println(netuser);
        String active = (String) super.session.get("active");
        System.out.println(active+"==register=");
        if(active==null||!active.equals(netuser.getActiveCode())){
            logger.info("激活码不匹配");
            try {
                httpServletResponse.getWriter().print("erro");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            else {
            register.saveNetUser(netuser);
            try {
                httpServletResponse.getWriter().print("ok");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return SUCCESS;
    }

    /**
     * 保存激活码到session中
     * @return
     */
    public String active(){
        String active = RandActiveCode.generatorActiveCode();
        boolean code = SendMail.sendEmailTOQQbox(netuser.getEmail(), "您的恒志云盘账号激活码", active);
        super.session.put("active",active);
        System.out.println(active+"==active=");
        //设置有效时间
        ServletActionContext.getRequest().getSession().setMaxInactiveInterval(30*60*60);
        return SUCCESS;
    }
    public String  checkUser(){
        String username = netuser.getUsername();
        boolean b = register.checkUser(username);
        if(b){
            try {
                httpServletResponse.getWriter().print("ERRO");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Netuser getModel() {
        return this.netuser;
    }
}
