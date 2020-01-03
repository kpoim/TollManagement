package com.atc.controller;

import com.atc.entity.Gate;
import com.atc.service.GateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
  
  @Autowired
  GateService gateService;
  
  @GetMapping
  public String employeeHome(Model m){
	List<Gate> gates = gateService.findAll();
	m.addAttribute("gates", gates);
	return "employee/home";
  }
  
}
