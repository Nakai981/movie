package com.nuce.movie.controllers;

import com.nuce.movie.entity.Purchase;
import com.nuce.movie.servicesImpl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class APurchaseController {
    @Autowired
    PurchaseServiceImpl purchaseService;

    @GetMapping("/manager/purchase")
    public String getPurchase(ModelMap modelMap){
        modelMap.addAttribute("messages",null);
        modelMap.addAttribute("active","purchase");
        modelMap.addAttribute("purchases",purchaseService.getAllPurchase());
        return "admin/purchase";
    }
}
