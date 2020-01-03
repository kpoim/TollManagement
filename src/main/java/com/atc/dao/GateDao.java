package com.atc.dao;

import com.atc.entity.Gate;
import java.util.List;

public interface GateDao {
  
  List<Gate> findAll();
  
  List<Gate> findByStationId(Integer id);
  
}
