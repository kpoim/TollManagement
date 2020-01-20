package com.atc.dao;

import com.atc.entity.Vehicle;
import java.util.List;

public interface VehicleDao {
  
  List<Vehicle> findAll();

  public Vehicle findByName(String s);
  
}
