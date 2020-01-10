package com.atc.dao;

import com.atc.entity.Gate;
import com.atc.entity.Station;
import java.util.List;

public interface GateDao {
  
  List<Gate> findAll();

  Gate findById(Integer id);

  List<Gate> findEntryGatesByStationObj(Station station);
  
}
