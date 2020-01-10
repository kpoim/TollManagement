package com.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/manage-employee")
public class ManageEmployee {
  
  @GetMapping
  public String adminHome(){
	return "admin/manageEmployee/home";
  }
  @GetMapping("/create")
  public String create(){
	return "admin/manageEmployee/create";
  }
  
  
}
