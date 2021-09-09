package com.nuce.movie.controllers;

import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.servicesImpl.ProviderServiceImpl;
import com.nuce.movie.servicesImpl.RoleServiceImpl;
import com.nuce.movie.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class AUserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/user")
    public String getUser(ModelMap modelMap){
        modelMap.addAttribute("users",userService.getListUser());
        modelMap.addAttribute("user_sidebar", "table");
        modelMap.addAttribute("active", "user");

        return "admin/user";
    }

    @PostMapping("/user/status")
    public String getStatus(@RequestParam int user_id, @RequestParam boolean user_status){
        userService.setStatus(user_id,user_status);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam int id, Principal p){
        User u = userService.getUserByEmail(p.getName());
        if(u.getId() == id){
            return "redirect:/admin/user";
        }
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/add")
    public String addUser(ModelMap modelMap){


        modelMap.addAttribute("user",null);
        modelMap.addAttribute("roles",roleService.getAllRole());
        modelMap.addAttribute("user_sidebar", "action-table");
        modelMap.addAttribute("active", "user");
        return "admin/user-add";
    }

    @PostMapping("/user/save")
    public String saveUser(ModelMap modelMap,
                           @RequestParam int user_id,
                          @RequestParam String user_fullname,
                          @RequestParam String user_birthday,
                          @RequestParam Long user_phone,
                          @RequestParam boolean user_gender,
                          @RequestParam String user_email,
                          @RequestParam String user_password,
                          @RequestParam int user_role
    )throws Exception{

            userService.saveUser(user_id,user_fullname,user_birthday,user_phone,user_gender,user_email,
                    user_password,1,user_role,true);
        return "redirect:/admin/user/add";
    }

    @GetMapping("/user/edit")
    public String addUser(ModelMap modelMap, @RequestParam int id
                          ){


        modelMap.addAttribute("user",userService.getUserByUserId(id));
        modelMap.addAttribute("roles",roleService.getAllRole());
        modelMap.addAttribute("user_sidebar", "action-table");
        modelMap.addAttribute("active", "user");
        return "admin/user-add";
    }


}
