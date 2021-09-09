package com.nuce.movie.controllers;

import com.nuce.movie.servicesImpl.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AServerController {
    @Autowired
    private ServerServiceImpl serverService;

    @GetMapping("/admin/server")
    public String getServer(ModelMap m){

        m.addAttribute("servers",serverService.getAllServer());
        m.addAttribute("server",null);
        m.addAttribute("active","server");
        return "admin/server";
    }

    @PostMapping("/admin/server/save")
    public String saveServer(
            @RequestParam String server_name,
            @RequestParam int server_id,
            @RequestParam String server_config
    ){
        serverService.saveServer(server_id,server_name,server_config);
        return "redirect:/admin/server";
    }

    @PostMapping("/admin/server/status")
    public String setStatus(@RequestParam int server_id, @RequestParam boolean server_status){
        serverService.setStatus(server_id,server_status);
        return "redirect:/admin/server";
    }
    @GetMapping("/admin/server/edit")
    public String editServer(ModelMap m, @RequestParam int id){

        m.addAttribute("servers",serverService.getAllServer());
        m.addAttribute("server",serverService.getServerById(id));
        m.addAttribute("active","server");
        return "/admin/server";
    }

    @GetMapping("/admin/server/delete")
    public String deleteServer(@RequestParam int id){
        serverService.deleteServer(id);
        return "redirect:/admin/server";
    }
}
