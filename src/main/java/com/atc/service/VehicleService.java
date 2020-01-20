package com.atc.service;

import com.atc.entity.Vehicle;
import java.util.List;

public interface VehicleService {
  
  List<Vehicle> findAll();
  
  List<String> findAllVehicleNames();

  public Vehicle findByName(String s);
  
}
