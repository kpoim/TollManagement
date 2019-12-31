
package com.atc.dao;

import com.atc.entity.Gate;
import java.util.List;


public interface GateDao {
    
    
    List<Gate> findAll();
    
    public void addOrUpdate(Gate g);
    
    public void delete(Integer id);
    
    public Gate findById(Integer id);
}
