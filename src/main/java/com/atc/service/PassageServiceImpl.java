package com.atc.service;

import com.atc.entity.History;
import com.atc.entity.Ongoing;
import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.Employee;
import com.atc.entity.Gate;
import com.atc.entity.Terminal;
import com.atc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassageServiceImpl implements PassageService {

  @Autowired
  OngoingService ongoingService;

  @Autowired
  HistoryService historyService;
  
  @Autowired
  AuthenticationFacade auth;
  
  @Autowired
  GateService gateService;

  @Override
  public History processCard(String id) {
	Ongoing ongoing = ongoingService.findOngoingByCardId(id);
	System.out.println("PROCESSCARD ONGOING: " + ongoing);
	Gate gate = getGateId(id);
	System.out.println("PROCESSCARD GATE: " + gate);
	if (ongoing == null) {
	  ongoingService.newEntry(id, gate);
	  return null;
	} else {
	  System.out.println("PC ONGOING NOT NULL");
	  History history = historyService.addToHistory(ongoing, gate);
	  System.out.println("RETURNEDD" + history);
	  if (history != null) {
		ongoingService.delete(ongoing);
	  }
	  return history;
	}
  }
  
  private Gate getGateId(String id){
//	User terminal = (User)auth.getAuthentication().getPrincipal();
	MyUserDetails principal = (MyUserDetails)auth.getAuthentication().getPrincipal();
	Terminal terminal = (Terminal) principal.getUser();
//	System.out.println("PSI TERMINAL: "+terminal);
//	System.out.println("PSI EXIT GATE: " + terminal.getGate());
//	terminalid must be the same as gateid
//	Until the logic is implemented, terminal users must have usernames like
//  "terminal33" or "terminal6", to be able to extract gateid
	return terminal.getGate();
//	return gateService.findById(terminal.getGate().getId().toString());
//	String username = ((UserDetails)auth.getAuthentication().getPrincipal()).getUsername();
//	return username.replace("terminal", "");
  }

}
