package com.atc.dao;

import com.atc.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends SuperDao implements ClientDao {

  @Override
  public Client create(Client c) {
	getSession().save(c);
	return c;
  }
  
}
