package com.nuce.movie.controllers;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.entity.Role;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.services.EmailService;
import com.nuce.movie.services.RoleService;
import com.nuce.movie.services.SecurityService;
import com.nuce.movie.services.UserService;
import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import com.nuce.movie.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class MLoginController {

    @Autowired private NationServiceImpl nationService;
    @Autowired private UserServiceImpl userService;

    @Autowired private RoleService roleService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private SecurityService securityService;
    @Autowired private EmailService emailService;

    private List<Nation> nations;
    private List<Category> categories;
    private User user;
    private int num=0;
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
            session.setAttribute("position",String.valueOf(roleService.getRoleNameByUserId(u.getId())));
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
        this.user = null;

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

    @PostMapping("/signin/process")
    public String processLogin(ModelMap model,
                               @RequestParam String user_fullname,
                               @RequestParam String user_email,
                               @RequestParam String user_password,
                               @RequestParam String user_brithday,
                               @RequestParam boolean user_gender
                               ){
        User u_check = userService.getUserByEmail(user_email);
        if(u_check != null){
            return "redirect:/signin";
        }
//        random
        Random rand = new Random();
        this.num = rand.nextInt(9999);

        try{
            emailService.sendEmail(user_email,"Your code: "+this.num,"OTP");
        }catch (Exception e){
            return "redirect:/signin";
        }

        this.user = new User();
        user.setFullname(user_fullname);
        user.setGender(user_gender);
        user.setPassword(user_password);
        user.setEmail(user_email);
        try{
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(user_brithday);
            user.setBirthday(date1);

        }catch (Exception e){

        }

        //header
        this.categories = categoryService.getAllByStatus();
        this.nations = nationService.getALlByStatus();

        model.addAttribute("categories",categories);
        model.addAttribute("nations",nations);
        model.addAttribute("message","");


        return "page/otp";
    }
    @PostMapping("/signin/otp")
    public String test(ModelMap model, @RequestParam int otp){

        if( otp == this.num){
            userService.saveUser(this.user);
        }
        if(otp != this.num){
            //header
            this.categories = categoryService.getAllByStatus();
            this.nations = nationService.getALlByStatus();

            model.addAttribute("categories",categories);
            model.addAttribute("nations",nations);
            model.addAttribute("message","fail otp");

            return "page/otp";

        }
        return "redirect:/login";
    }

}
