package com.atc.dao;

import com.atc.entity.Station;
import java.util.List;

public interface StationDao {
  
  List<Station> findAll();

    public void addOrUpdate(Station s);

    public Station findById(Integer id);

    public void delete(int id);
  
}
