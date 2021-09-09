package com.nuce.movie.controllers;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.repositories.NationRepository;
import com.nuce.movie.services.MovieService;
import com.nuce.movie.services.NationService;
import com.nuce.movie.servicesImpl.CategoryServiceImpl;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ANationController {

    @Autowired
    NationServiceImpl nationService;


    @GetMapping("/admin/nation")
    public String getNation(ModelMap m){

        m.addAttribute("nations",nationService.getAllNation());
        m.addAttribute("nation",null);
        m.addAttribute("active","nation");
        return "admin/nation";
    }

    @PostMapping("/admin/nation/save")
    public String saveNation(
                            @RequestParam String nation_name,
                             @RequestParam int nation_id
                            ){
        nationService.saveNation(nation_id,nation_name);
        return "redirect:/admin/nation";
    }

    @PostMapping("/admin/nation/status")
    public String setStatus(@RequestParam int nation_id, @RequestParam boolean nation_status){
        nationService.setStatus(nation_id,nation_status);
        return "redirect:/admin/nation";
    }
    @GetMapping("/admin/nation/edit")
    public String editNation(ModelMap m, @RequestParam int id){

        m.addAttribute("nations",nationService.getAllNation());
        m.addAttribute("nation",nationService.getNationById(id));
        m.addAttribute("active","nation");
        return "/admin/nation";
    }

    @GetMapping("/admin/nation/delete")
    public String deleteNation(@RequestParam int id){
        nationService.deleteNation(id);
        return "redirect:/admin/nation";
    }

}
