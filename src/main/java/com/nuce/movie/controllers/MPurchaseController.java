package com.nuce.movie.controllers;

import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import com.nuce.movie.servicesImpl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MPurchaseController {
    @Autowired
    private NationServiceImpl nationService;
    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private PurchaseServiceImpl purchaseService;

    @GetMapping("/purchase")
    public String getPurchase(ModelMap modelMap){
        modelMap.addAttribute("categories",categoryService.getAllByStatus());
        modelMap.addAttribute("nations",nationService.getALlByStatus());
        modelMap.addAttribute("purchases",purchaseService.getAllPurchase());

        return "page/purchase";
    }
}
