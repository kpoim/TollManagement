package com.atc.dao;

import com.atc.entity.RetailClient;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RetailClientDaoImpl extends SuperDao implements RetailClientDao{

    

    @Override
    public RetailClient create(RetailClient rc) {
        getSession().save(rc);
	return rc;
    }

    @Override
    public RetailClient findByUsername(String username) {
        Query q = getSession().createQuery("SELECT r FROM RetailClient r WHERE r.username = : username");
        q.setParameter("username", username);
        RetailClient retailClient = null;
	try {
	  retailClient = (RetailClient) q.getSingleResult();
	} catch (NoResultException e) {
	}
	return retailClient;
    }
    
}
