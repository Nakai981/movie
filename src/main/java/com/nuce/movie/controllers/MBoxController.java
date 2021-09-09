package com.nuce.movie.controllers;

import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class MBoxController {

    @Autowired private NationServiceImpl nationService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private MovieServiceImpl movieService;

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

}
