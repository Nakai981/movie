package com.nuce.movie.controllers;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.entity.Role;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.services.RoleService;
import com.nuce.movie.services.SecurityService;
import com.nuce.movie.services.UserService;
import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class MLoginController {

    @Autowired private NationServiceImpl nationService;
    @Autowired private UserRepository userService;
    @Autowired private RoleService roleService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private SecurityService securityService;
    private List<Nation> nations;
    private List<Category> categories;

    private String covert_status;

    @GetMapping("/login")
    public String getlogin(ModelMap model){
        //Header

        this.categories = categoryService.getAllByStatus();
        this.nations = nationService.getALlByStatus();

        model.addAttribute("categories",categories);
        model.addAttribute("nations",nations);

        covert_status = "signup";
        model.addAttribute("covert_status",covert_status);
        return "page/login";
    }
//
    @PostMapping("/login/process")
    public String processLogin(@RequestParam  String username, @RequestParam String password, HttpSession session){
        boolean loginResponse = securityService.login(username,password);

        if(loginResponse){
            User u = userService.getUserByEmail(username);
            session.setAttribute("name",u.getFullname());
            session.setAttribute("user_id",u.getId());
            boolean check_admin = roleService.getIdByRoleIDAndUserId(1,u.getId());
            boolean check_manager = roleService.getIdByRoleIDAndUserId(2,u.getId());
            if(!check_admin){
                return "redirect:/user";
            }
            if(!check_manager){
                return "redirect:/admin/nation";
            }
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/signin")
    public String getSignin(ModelMap model){
        //Header

        this.categories = categoryService.getAllByStatus();
        this.nations = nationService.getALlByStatus();

        model.addAttribute("categories",categories);
        model.addAttribute("nations",nations);

        covert_status = "signin";
        model.addAttribute("covert_status",covert_status);
        return "page/login";
    }

    @RequestMapping("/home/film")
    public String getFilm () {
        return "page/film";
    }

}
