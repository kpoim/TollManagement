package com.atc.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;


public class SuperDao {
  
  @Autowired
  EntityManager em;

  protected Session getSession() {
	Session s = em.unwrap(Session.class);
	return s;
  }

}
