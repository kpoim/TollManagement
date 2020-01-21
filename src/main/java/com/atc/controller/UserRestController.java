package com.atc.controller;

import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.Card;
import com.atc.entity.Client;
import com.atc.entity.History;
import com.atc.entity.Terminal;
import com.atc.service.CardService;
import com.atc.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api")
public class UserRestController {
  
  @Autowired
  AuthenticationFacade auth;
  
  @Autowired
  CardService cardService;
  
  @Autowired
  ClientService clientService;
  
  @GetMapping("/get-history")
  public ResponseEntity<List<Card>> getHistory(){
	
	MyUserDetails principal = (MyUserDetails) auth.getAuthentication().getPrincipal();
	Client client = (Client) principal.getUser();
	Client client2 = clientService.findByUsername(client.getUsername());
	
	List<Card> all = cardService.findAll();
	System.out.println("\n\nALL CARDS:" + all);
//	List<Card> cards = clientService.getCards(client);
//	System.out.println(cards);
	List<Card> cards = cardService.getCardsByClientId(client2);
	System.out.println(cards);
	System.out.println(client);
	System.out.println(client.getCards());
	return ResponseEntity.ok().body(cards);
//	cardService
//	return ResponseEntity.ok().body(null);
  }
  
}
