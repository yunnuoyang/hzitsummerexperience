package com.disk.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class BaseController extends ActionSupport implements RequestAware,SessionAware,ServletResponseAware {
      Map<String, Object> request;
      Map<String, Object> session;
      HttpServletResponse httpServletResponse;
    @Override
    public void setRequest(Map<String, Object> map) {
        this.request=map;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
            this.httpServletResponse=httpServletResponse;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}
