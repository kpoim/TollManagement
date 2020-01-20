package com.atc.dao;

import com.atc.entity.ProClient;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProClientDaoImpl extends SuperDao implements ProClientDao{

    @Override
    public ProClient create(ProClient pc) {
        getSession().save(pc);
	return pc;
    }

    @Override
    public ProClient findByUsername(String username) {
        Query q = getSession().createQuery("SELECT p FROM ProClient p WHERE p.username = : username");
        q.setParameter("username", username);
        ProClient proClient = null;
	try {
	  proClient = (ProClient) q.getSingleResult();
	} catch (NoResultException e) {
	}
	return proClient;
    }
    
}
