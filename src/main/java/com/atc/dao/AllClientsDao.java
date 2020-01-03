
package com.atc.dao;

import com.atc.entity.AllClients;
import java.util.List;


public interface AllClientsDao {
    List<AllClients> findAll();
    
    public void addOrUpdate(AllClients ac);
    
    public void delete(Integer id);
    
    public AllClients findById(Integer id);
}
