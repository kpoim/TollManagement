package com.atc.dao;

import com.atc.entity.ProClient;
import org.springframework.stereotype.Repository;

@Repository
public class ProClientDaoImpl extends SuperDao implements ProClientDao{

    @Override
    public ProClient create(ProClient pc) {
        getSession().save(pc);
	return pc;
    }
    
}
