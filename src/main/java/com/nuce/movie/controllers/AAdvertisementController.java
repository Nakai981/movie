package com.nuce.movie.controllers;


import com.nuce.movie.entity.Advertisement;
import com.nuce.movie.entity.Comment;
import com.nuce.movie.servicesImpl.AdvertisementServiceImpl;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AAdvertisementController {

    @Autowired
    private AdvertisementServiceImpl advertisementService;


    @GetMapping("/api/advertisement")
    @ResponseBody
    public ResponseEntity<List<Advertisement>> getAdvertisement(){
        return new ResponseEntity<>(advertisementService.getAdvertisementByAdvertisementLocation(), HttpStatus.OK);
    }


    @GetMapping("/admin/advertisement")
    public String getAdvertisement(ModelMap m){
        m.addAttribute("advertisements",advertisementService.getAllAdvertisement());
        m.addAttribute("advertisement",null);
        m.addAttribute("active","advertisement");
        return "admin/advertisement";
    }

    @PostMapping("/admin/advertisement/save")
    public String saveAdvertisement(
            @RequestParam String advertisement_cooperation,
            @RequestParam String advertisement_banner,
            @RequestParam String advertisement_access,
            @RequestParam int advertisement_location,
            @RequestParam String advertisement_created_at,
            @RequestParam String advertisement_end_at,

            @RequestParam int advertisement_id
    ){
        advertisementService.saveAdvertisement(advertisement_id,advertisement_access,advertisement_banner,advertisement_location,
                advertisement_created_at,advertisement_end_at,advertisement_cooperation);
        return "redirect:/admin/advertisement";
    }

    @PostMapping("/admin/advertisement/status")
    public String setStatus(@RequestParam int advertisement_id, @RequestParam boolean advertisement_status){
        advertisementService.setStatus(advertisement_id,advertisement_status);
        return "redirect:/admin/advertisement";
    }

    @GetMapping("/admin/advertisement/edit")
    public String editCAdvertisement(ModelMap m, @RequestParam int id){

        m.addAttribute("advertisements",advertisementService.getAllAdvertisement());
        m.addAttribute("advertisement",advertisementService.getAdvertisementById(id));
        m.addAttribute("active","advertisement");
        return "/admin/advertisement";
    }

    @GetMapping("/admin/advertisement/delete")
    public String deleteAdvertisement(@RequestParam int id){
        advertisementService.deleteAdvertisement(id);
        return "redirect:/admin/advertisement";
    }

}
