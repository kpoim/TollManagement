package com.atc.service;

import com.atc.entity.History;
import com.atc.entity.Ongoing;
import com.atc.components.AuthenticationFacade;
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

  @Override
  public History processCard(String id) {
	Ongoing ongoing = ongoingService.findOngoingByCardId(id);
	String gateid = getGateId();
	if (ongoing == null) {
	  ongoingService.newEntry(id, gateid);
	  return null;
	} else {
	  History history = historyService.addToHistory(ongoing, gateid);
	  if (history != null) {
		ongoingService.delete(ongoing);
	  }
	  return history;
	}
  }
  
  private String getGateId(){
//	terminalid must be the same as gateid
//	Until the logic is implemented, terminal users must have usernames like
//  "terminal33" or "terminal6", to be able to extract gateid
	String username = ((UserDetails)auth.getAuthentication().getPrincipal()).getUsername();
	return username.replace("terminal", "");
  }

}
