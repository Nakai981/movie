package com.nuce.movie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


    @RequestMapping("/admin")
    public String getDashboard(ModelMap modelMap){
        modelMap.addAttribute("status", "DASHBOARD");
        return "admin/dashboard";
    }

    @RequestMapping("/admin/user")
    public String getUser(ModelMap modelMap){
        modelMap.addAttribute("status", "USER");
        return "admin/user";
    }
}
