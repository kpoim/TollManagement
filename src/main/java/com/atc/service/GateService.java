package com.atc.service;

import com.atc.entity.Employee;
import com.atc.entity.Gate;
import java.util.List;

public interface GateService {
  
  List<Gate> findAll();
  
  Gate findById(String id);
  
  public List<Gate> findEntryGatesByStationId(String id);
  
  boolean addEmployee(String gateIndex, Employee employee);
  
}
