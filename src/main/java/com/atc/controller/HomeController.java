package com.atc.controller;

import com.atc.entity.History;
import com.atc.entity.Ongoing;
import com.atc.service.HistoryService;
import com.atc.service.OngoingService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  OngoingService ongoingService;

  @Autowired
  HistoryService historyService;

  @GetMapping
  public String home(Authentication authentication, Principal principal, Model m) {
	UserDetails ud = (UserDetails) authentication.getPrincipal();
	System.out.println(ud.getUsername());
	System.out.println(principal.getName());
	System.out.println(authentication.getAuthorities().toString());
	m.addAttribute("ud", ud);
	return principal.getName() + "/home";
  }

  @GetMapping("/card/{id}")
  public String processCard(@PathVariable("id") String id, Principal principal, Model model) {
	switch (principal.getName()) {
	  case "terminal":
		Ongoing ongoing = ongoingService.findOngoingByCardId(id);
		if (ongoing == null) {
		  System.out.println("--------------> No ongoing trip ----------------------------------");
		  ongoing = ongoingService.newEntry(id);
		} else {
		  History history = historyService.addToHistory(ongoing);
		  if (history != null) {
			ongoingService.delete(ongoing);
		  }
		  model.addAttribute("history", history);
		}
		return "terminal/card";
	  default:
		return "home";
	}
  }

}
