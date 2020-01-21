package com.atc.controller;

import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.ProClient;
import com.atc.entity.RetailClient;
import com.atc.service.ProClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(("/user"))
public class UserController {

    @Autowired
    ProClientService proClientService;

    @Autowired
    AuthenticationFacade auth;

    @GetMapping
    public String userHome(Model m) {
        MyUserDetails principal = (MyUserDetails) auth.getAuthentication().getPrincipal();
        System.out.println("PRINCIPAL" + (principal));
        try {
            ProClient ud = (ProClient) principal.getUser();
            m.addAttribute("puser", ud);
            return "user/home-pro";
        } catch (Exception e) {
        }
        try {
            RetailClient ud = (RetailClient) principal.getUser();
            m.addAttribute("ruser", ud);
            return "user/home-retail";
        } catch (Exception e) {
        }
        return "redirect:/";
    }
	
	@GetMapping("/history")
	public String showMap(){
	  return "user/history";
	}

}
