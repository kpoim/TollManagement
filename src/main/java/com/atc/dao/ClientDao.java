package com.atc.dao;

import com.atc.entity.Client;
import java.util.List;

public interface ClientDao {
  
  Client create(Client c);

    public List<Client> findAllClients();
    
    public Client findByUsername(String username);

    public Client findById(Integer id);

    public void delete(int id);

    public void addOrUpdate(Client client);
    
    public void changePassword(Client client);

    
  
}
