
package com.atc.dao;

import com.atc.entity.Road;
import java.util.List;


public interface RoadDao {
    
    List<Road> findAll();

    public void createOrUpdate(Road r);

    public Road findById(Integer id);

    public void delete(int id);
}
