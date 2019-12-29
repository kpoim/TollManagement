package com.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
  
  @GetMapping("/home")
  public String employeeHome(){
	return "employee/home";
  }
  
}
