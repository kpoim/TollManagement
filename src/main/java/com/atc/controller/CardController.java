package com.atc.controller;

import com.atc.components.AuthenticationFacade;
import com.atc.entity.Gate;
import com.atc.entity.History;
import com.atc.entity.Ongoing;
import com.atc.service.HistoryService;
import com.atc.service.OngoingService;
import com.atc.service.PassageService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/card")
public class CardController {

  @Autowired
  PassageService passageService;

  @Autowired
  AuthenticationFacade auth;

  @GetMapping("/{id}")
  public String processCard(@PathVariable("id") String id, Model model) {
	String authority = new ArrayList<>(auth.getAuthentication().getAuthorities()).get(0).getAuthority();
	System.out.println("---> AUTHORITY: " + authority);
	switch (authority) {
	  case "ROLE_TERMINAL":

		Gate gate = passageService.extractGateFromTerminal(id);
		History history = passageService.processCard(id);
		model.addAttribute("history", history);
		model.getAttribute("history");
		if (history == null) {
		  model.addAttribute("station", gate.getStation());
		} else {
		  model.addAttribute("entrylat", history.getEntrygate().getStation().getLatitude());
		  model.addAttribute("entrylong", history.getEntrygate().getStation().getLongtitude());
		  model.addAttribute("exitlat", history.getExitgate().getStation().getLatitude());
		  model.addAttribute("exitlong", history.getExitgate().getStation().getLongtitude());
		}
		return "terminal/card";
	  case "ROLE_CLIENT":
	  default:
		return "misc/landing-page";
	}
  }

}
