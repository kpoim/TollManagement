package com.atc.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;


public class SuperDao {
  
  @Autowired
  EntityManager em;

  protected Session getSession() {
	System.out.println("SUPERDAO 1111111");
	Session s = em.unwrap(Session.class);
	System.out.println("SUPERDAO 22222");
	return s;
  }

}
