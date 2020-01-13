package com.atc.dao;

import com.atc.entity.RetailClient;
import org.springframework.stereotype.Repository;

@Repository
public class RetailClientDaoImpl extends SuperDao implements RetailClientDao{

    

    @Override
    public RetailClient create(RetailClient rc) {
        getSession().save(rc);
	return rc;
    }
    
}
