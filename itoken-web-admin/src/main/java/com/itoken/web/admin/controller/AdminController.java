package com.itoken.web.admin.controller;


import com.itoken.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"","/login"}, method = RequestMethod.GET)
    public String login() {
        String login = adminService.login("123456", "123456");
        System.out.println(login);
        return "index";
    }

}
