package com.atc.controller;

import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.Employee;
import com.atc.entity.Gate;
import com.atc.entity.Terminal;
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
  
  @Autowired
  AuthenticationFacade auth;
  
  @GetMapping
  public String employeeHome(Model m){
//	List<Gate> gates = gateService.findAll();
	MyUserDetails principal = (MyUserDetails)auth.getAuthentication().getPrincipal();
	Employee emp = (Employee) principal.getUser();
	m.addAttribute("fullName", emp.getFname() + " " + emp.getLname());
//	m.addAttribute("gates", gates);
	return "employee/home";
  }
  
}
