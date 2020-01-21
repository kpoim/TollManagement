package com.atc.service;

import com.atc.dao.ClientDao;
import com.atc.entity.Card;
import com.atc.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

  @Autowired
  RoleService roleService;

  @Autowired
  ClientDao dao;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Client> findAll() {
        return dao.findAllClients();
    }

    @Override
    public Client findById(Integer id) {
        return dao.findById(id);
    }
    
     @Override
    public Client findByUsername(String username) {
        return dao.findByUsername(username);
    }
    
     @Override
  public Client create(Client c) {
//	c.setRole(roleService.findById("3"));
        c.setAnswer(passwordEncoder.encode(c.getAnswer()));
	c.setPassword(passwordEncoder.encode(c.getPassword()));
	return dao.create(c);
  }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void addOrUpdate(Client client) {
        dao.addOrUpdate(client);
    }

    @Override
    public void changePassword(Client client) {
        dao.changePassword(client);
    }

  @Override
  public List<Card> getCards(Client client) {
	return dao.getCards(client);
  }

   

}
