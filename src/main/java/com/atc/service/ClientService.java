package com.atc.service;

import com.atc.entity.Client;
import java.util.List;

public interface ClientService {
    
    
  List<Client> findAll();
  
  Client findById(Integer id);
  
  Client findByUsername(String username);
  
  Client create(Client c); 
        
  void delete(int id);

  void addOrUpdate(Client client);
  
  void changePassword(Client client);

    

}
