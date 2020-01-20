package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.History;
import com.atc.entity.Ongoing;
import com.atc.entity.Vehicle;

public interface HistoryService {

  History addToHistory(Ongoing ongoing, Gate exitGate);

  History findById(String historyId);

  Boolean addGeometry(String historyId, String geometry);

  Double getDistance(String id);
  
  Double getPrice(String id, Vehicle vehicle);
  
  Double getDistance(History history);

  Boolean updateCostAndVehicle(String historyId, Double price, Vehicle vehicle);

}
