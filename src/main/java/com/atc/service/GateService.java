package com.atc.service;

import com.atc.entity.Gate;
import java.util.List;

public interface GateService {
  
  List<Gate> findAll();
  
  List<Gate> findByStationId(String id);
  
}
