package com.atc.controller;

import com.atc.entity.ProClient;
import com.atc.entity.RetailClient;
import com.atc.service.ProClientService;
import com.atc.service.RetailClientService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
  
  @Autowired
  ProClientService proClientService;
  
  @Autowired
  RetailClientService retailClientService;

  @GetMapping("/register")
  public String newClientForm(@ModelAttribute("proClient") ProClient proClient ,@ModelAttribute("retailClient") RetailClient retailClient ) {
	return "user/register";
  }

  @PostMapping("/newProClient")
  public String newProClient(@Valid ProClient proClient) {
	proClientService.create(proClient);
	return "redirect:/";
  }
  @PostMapping("/newRetailClient")
  public String newRetailClient(@Valid RetailClient retailClient) {
	retailClientService.create(retailClient);
	return "redirect:/";
  }

  
  @GetMapping("/paypal")
    public String listEmployee(Model m) {
        
        return "paypal";
    }


}
