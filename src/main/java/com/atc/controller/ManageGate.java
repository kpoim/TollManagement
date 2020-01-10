package com.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/manage-gate")
public class ManageGate {
  
  @GetMapping
  public String adminHome(){
	return "admin/manageGate/home";
  }
  @GetMapping("/create")
  public String create(){
	return "admin/manageGate/create";
  }
  
  
}
