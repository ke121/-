package com.tom.baiwei.controller;

import com.tom.baiwei.model.RespBean;
import com.tom.baiwei.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    HrService hrService ;
    @RequestMapping("hello")
    public String login(){
        return hrService.LoadUserByUsername("admin").getPassword() ;
    }

    @RequestMapping("/login_page")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RespBean loginpage(){
        return RespBean.build().setStatus(401).setMsg("尚未登陆，请登录") ;
    }
}
