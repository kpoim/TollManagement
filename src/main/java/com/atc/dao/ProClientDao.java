
package com.atc.dao;

import com.atc.entity.ProClient;
import java.util.List;


public interface ProClientDao {
    
    List<ProClient> findAll();
    
    public void addOrUpdate(ProClient pc);
    
    public void delete(Integer id);
    
    public ProClient findById(Integer id);
}
