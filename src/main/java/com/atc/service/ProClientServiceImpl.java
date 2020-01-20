package com.atc.service;

import com.atc.dao.ProClientDao;
import com.atc.entity.ProClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProClientServiceImpl implements ProClientService {

  @Autowired
  RoleService roleService;

  @Autowired
  ProClientDao dao;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public ProClient create(ProClient pc) {
	pc.setRole(roleService.findById("3"));
        pc.setAnswer(passwordEncoder.encode(pc.getAnswer()));
         System.out.println("ENCODED ANSWER " + pc.getAnswer());
	pc.setPassword(passwordEncoder.encode(pc.getPassword()));
	return dao.create(pc);
  }

}
