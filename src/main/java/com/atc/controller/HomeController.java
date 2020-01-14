package com.atc.controller;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


  @GetMapping("/")
  public String home(Authentication authentication, Principal principal, Model m) {
//	UserDetails ud = (UserDetails) authentication.getPrincipal();
//	System.out.println(ud.getUsername());
//	System.out.println(principal.getName());
//	System.out.println(authentication.getAuthorities().toString());
//	m.addAttribute("ud", ud);
	return "misc/landing-page";
  }
  
  @GetMapping("/paypal")
    public String listEmployee(Model m) {
        
        return "paypal";
    }

}
