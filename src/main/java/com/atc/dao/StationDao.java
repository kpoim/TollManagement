package com.atc.dao;

import com.atc.entity.Station;
import java.util.List;

public interface StationDao {
  
  List<Station> findAll();
  
}
