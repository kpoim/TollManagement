package com.atc.dao;

import com.atc.entity.Gate;
import java.util.List;

public interface GateDao {
  
  List<Gate> findAll();
  
  List<Gate> findEntryGatesByStationId(Integer id);

  Gate findById(Integer id);

    public void addOrUpdate(Gate g);

    public void delete(Integer id);
  
}
