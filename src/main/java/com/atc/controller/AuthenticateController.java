package com.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticateController {

    @GetMapping("/loginPage")
    public String showLoginForm(){
        return "misc/form-login";
    }
    
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "misc/access-denied";
    }
}
