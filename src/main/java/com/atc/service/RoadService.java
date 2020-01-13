
package com.atc.service;

import com.atc.entity.Road;
import java.util.List;


public interface RoadService {
    
    List<Road> findAll();

    public void addOrUpdate(Road r);

    public Road findById(Integer id);

    public void delete(int id);
    
}
