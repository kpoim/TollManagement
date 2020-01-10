package com.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
  
  @GetMapping
  public String adminHome(){
	return "admin/home";
  }
  
  @GetMapping("/manageGate")
  public String manageGate(){
	return "admin/manageGate";
  }
  
  @GetMapping("/manageEmployee")
  public String manageEmployee(){
      return "admin/manageEmployee";
  }
}
