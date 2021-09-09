package com.nuce.movie.controllers;


import com.nuce.movie.servicesImpl.CategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class ACategoryController {

    @Autowired
    CategoryServiceImpl categoryService;


    @GetMapping("/admin/category")
    public String getCategory(ModelMap m){

        m.addAttribute("categories",categoryService.getAllCategory());
        m.addAttribute("category",null);
        m.addAttribute("active","category");
        return "admin/category";
    }

    @PostMapping("/admin/category/save")
    public String saveCategory(
            @RequestParam String category_name,
            @RequestParam int category_id
    ){
        categoryService.saveCategory(category_id,category_name);
        return "redirect:/admin/category";
    }

    @PostMapping("/admin/category/status")
    public String setStatus(@RequestParam int category_id, @RequestParam boolean category_status){
        categoryService.setStatus(category_id,category_status);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/category/edit")
    public String editCategory(ModelMap m, @RequestParam int id){

        m.addAttribute("categories",categoryService.getAllCategory());
        m.addAttribute("category",categoryService.getCategoryById(id));
        m.addAttribute("active","category");
        return "/admin/category";
    }

    @GetMapping("/admin/category/delete")
    public String deleteCategory(@RequestParam int id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }

}
