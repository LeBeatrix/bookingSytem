package com.startup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("message", "welcome to appointment system !!!!");
        return "welcome";
    }
}
