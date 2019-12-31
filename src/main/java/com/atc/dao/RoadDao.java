
package com.atc.dao;

import com.atc.entity.Road;
import java.util.List;


public interface RoadDao {
    
    List<Road> findAll();
    
    public void addOrUpdate(Road r);
    
    public void delete(Integer id);
    
    public Road findById(Integer id);
}
