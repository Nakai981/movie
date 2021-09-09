package com.nuce.movie.controllers;

import com.nuce.movie.servicesImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AMessageController {

    @Autowired
    MessageServiceImpl messageService;

    @GetMapping("/admin/message")
    public String getMessage(ModelMap modelMap){

        modelMap.addAttribute("messages",messageService.getAllByStatus());
        modelMap.addAttribute("active","message");
        return "/admin/message";
    }

    @PostMapping("/admin/message/status")
    public String setStatus(@RequestParam int message_id, @RequestParam boolean message_status){

        messageService.setStatus(message_id,message_status);
        return "redirect:/admin/message";
    }

}
