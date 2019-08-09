package com.struts.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.structs.utils.Config;
import com.structs.utils.FileUpLoad;
import com.struts.pojo.Chairman;
import com.struts.pojo.User;
import com.struts.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserController extends BaseController implements ModelDriven<Chairman> {
    private Chairman chairman=new Chairman();
    private UserService userService;
    private File file;
    private String fileFileName;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String register(){
        System.out.println(chairman.getName()+"==="+chairman.getNationId());
        userService.save(this.chairman);
        return SUCCESS;
    }
    public String fileUpLoad(){
        try {
            FileUpLoad.fileUpLoad(session,file,fileFileName,Config.uploadFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    @Override
    public Chairman getModel() {
        return chairman;
    }
}
