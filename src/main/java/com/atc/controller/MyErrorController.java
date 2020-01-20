package com.atc.controller;
import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController  {
 
    @Autowired
    AuthenticationFacade auth;
    
    @RequestMapping("/error")
    public String handleError(Model m) {
//        MyUserDetails principal = (MyUserDetails) auth.getAuthentication().getPrincipal();
//        Client client = (Client) principal.getUser();
//        System.out.println("PRINCIPAL" + (principal));
//        m.addAttribute("client", client);
//        
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}