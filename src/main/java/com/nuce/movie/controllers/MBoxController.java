package com.nuce.movie.controllers;

import com.nuce.movie.repositories.RoleRepository;
import com.nuce.movie.servicesImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class MBoxController {

    @Autowired private NationServiceImpl nationService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private UserServiceImpl userService;
    @Autowired private MovieServiceImpl movieService;
    @Autowired private RoleRepository roleService;


    @GetMapping("/box")
    public String getBox(ModelMap modelMap, HttpSession session){
        //header
        modelMap.addAttribute("categories",categoryService.getAllByStatus());
        modelMap.addAttribute("nations",nationService.getALlByStatus());

        // movie
        int user_id = (int)session.getAttribute("user_id");
        modelMap.addAttribute("movie_box",movieService.getAllByUserId(user_id, PageRequest.of(0,5)));
        return "page/box";
    }


    @GetMapping("/account")
    public String getAccount(ModelMap modelMap, HttpSession session){
        //header
        modelMap.addAttribute("categories",categoryService.getAllByStatus());
        modelMap.addAttribute("nations",nationService.getALlByStatus());

        // movie
        Integer user_id = (Integer)session.getAttribute("user_id") ;
        modelMap.addAttribute("user",userService.getUserByUserId(user_id));
        String role ="";
        List<String> list_role_name = roleService.getAllNameByUserId(user_id);
        for(String i: list_role_name){
            role += " "+i;
        }
        modelMap.addAttribute("role",role);
        return "page/account";
    }
    @PostMapping("/process/account")
    public String updateAccount(HttpSession session,
                                @RequestParam String user_fullname,
                                @RequestParam boolean user_gender,
                                @RequestParam String user_birthday,
                                @RequestParam String user_password
                                ) throws  Exception{



        Integer user_id = (Integer)session.getAttribute("user_id") ;
        userService.updateUser(user_id,user_fullname,user_birthday,user_password,user_gender);
        return "redirect:/logout";
    }
}
