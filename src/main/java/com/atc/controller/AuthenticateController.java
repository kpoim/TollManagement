package com.atc.controller;

import com.atc.entity.ProClient;
import com.atc.entity.RetailClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthenticateController {

    @GetMapping("/login")
    public String showLoginForm(@ModelAttribute("proClient") ProClient proClient, @ModelAttribute("retailClient") RetailClient retailClient){
        
        return "misc/login-page";
    }
    
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "misc/access-denied";
    }
}
