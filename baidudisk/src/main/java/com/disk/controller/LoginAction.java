package com.disk.controller;

import com.disk.intercepter.service.IRegister;
import com.disk.intercepter.pojo.Netuser;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;

public class LoginAction extends BaseController implements ModelDriven<Netuser> {
    private Netuser nu=new Netuser();
    @Autowired
    private IRegister register;
    private String loginName;
    private String rempas;
    public String dologin(){
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        for(Cookie c:cookies){
            //先将sessionId清除
            ServletActionContext.getRequest().getSession().invalidate();
            System.out.println(c.getName()+"======");
            if ("remember".equals(c.getName())){
                return SUCCESS;
            }
        }

        Netuser isExit=register.isExit(nu,loginName);
        if(rempas!=null&&isExit!=null) {
            //将记住的用户的密码设置进入cookie
                httpServletResponse.addCookie(new Cookie("remember",isExit.getUsername()+isExit.getPassword()));
       }
        if (isExit==null)return ERROR;
        else
        return SUCCESS;
    }





    public void setRempas(String rempas) {
        this.rempas = rempas;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setNu(Netuser nu) {
        this.nu = nu;
    }

    @Override
    public Netuser getModel() {
        return nu;
    }
}
