
package com.atc.service;

import com.atc.entity.Road;
import java.util.List;


public interface RoadService {
    
    List<Road> findAll();

    void addOrUpdate(Road r);

    Road findById(Integer id);

    void delete(int id);
    
}
