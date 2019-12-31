
package com.atc.dao;

import com.atc.entity.Station;
import java.util.List;


public interface StationDao {
    
    List<Station> findAll();
    
    public void addOrUpdate(Station s);
    
    public void delete(Integer id);
    
    public Station findById(Integer id);
}
