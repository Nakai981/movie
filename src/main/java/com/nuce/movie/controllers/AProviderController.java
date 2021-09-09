package com.nuce.movie.controllers;

import com.nuce.movie.servicesImpl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AProviderController {
    @Autowired
    private ProviderServiceImpl providerService;

    @PostMapping("/admin/provider")
    public String editProvider(@RequestParam int provider_id,
                               @RequestParam String provider_name){
        providerService.editProvider(provider_id,provider_name);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/provider/delete")
    public String deleteProvider(@RequestParam int provider_id){
        providerService.deleteProvider(provider_id);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/provider/active")
    public String activeProvider(@RequestParam int provider_id){
        providerService.activeProvider(provider_id);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/provider/add")
    public String addProvider(@RequestParam String provider_name,
                              @RequestParam boolean provider_status){
        providerService.addProvider(provider_name,provider_status);
        return "redirect:/admin/user";
    }


}
