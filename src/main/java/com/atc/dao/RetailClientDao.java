
package com.atc.dao;

import com.atc.entity.RetailClient;
import java.util.List;


public interface RetailClientDao {
    
    List<RetailClient> findAll();
    
    public void addOrUpdate(RetailClient rc);
    
    public void delete(Integer id);
    
    public RetailClient findById(Integer id);
}
