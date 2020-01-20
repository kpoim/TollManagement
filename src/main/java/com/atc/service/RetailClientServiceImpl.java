package com.atc.service;

import com.atc.dao.RetailClientDao;
import com.atc.entity.RetailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RetailClientServiceImpl implements RetailClientService {

  @Autowired
  CardService cardService;

  @Autowired
  RoleService roleService;

  @Autowired
  RetailClientDao dao;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public RetailClient create(RetailClient rc) {
	rc.setRole(roleService.findById("3"));
	rc.setAnswer(passwordEncoder.encode(rc.getAnswer()));
	System.out.println("ENCODED ANSWER " + rc.getAnswer());
	rc.setPassword(passwordEncoder.encode(rc.getPassword()));
	rc.addCard(cardService.create());
	return dao.create(rc);
  }

}
