package com.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/user")
public class UserController {  
  
  @GetMapping
  public String userHome(){
	return "user/home";
  }

}
