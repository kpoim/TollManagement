package com.atc.service;

import com.atc.dao.HistoryDao;
import com.atc.entity.Gate;
import com.atc.entity.History;
import com.atc.entity.Ongoing;
import com.atc.entity.Vehicle;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

  @Autowired
  HistoryDao dao;

  @Autowired
  VehicleService vehicleService;

  @Override
  public History addToHistory(Ongoing ongoing, Gate exitGate) {
	if(exitGate.getEmployee() == null){
	  return new History();
	}
	History history = new History(
		ongoing.getId(),
		ongoing.getCardid(),
		ongoing.getEntrytime(),
		ongoing.getGate(),
		java.sql.Timestamp.valueOf(LocalDateTime.now()),
		exitGate
	);
	System.out.println("HistService HISTORY: " + history);
	return dao.addToHistory(history) ? history : null;
  }

  @Override
  public History findById(String historyId) {
	try {
	  Integer id = Integer.parseInt(historyId);
	  return dao.findById(id);
	} catch (Exception e) {
	  return null;
	}
  }

  @Override
  public Boolean addGeometry(String historyId, String geometry) {
	History history = findById(historyId);
	history.setGeometry(geometry);
	dao.update(history);
	return history.getGeometry().equals(geometry);
  }

  @Override
  public Double getDistance(String id) {
	History history = findById(id);
	Double start = history.getEntrygate().getStation().getDistance();
	Double end = history.getExitgate().getStation().getDistance();
	return Math.abs(start - end);
  }

  @Override
  public Double getDistance(History history) {
	Double start = history.getEntrygate().getStation().getDistance();
	Double end = history.getExitgate().getStation().getDistance();
	return Math.abs(start - end);
  }

  @Override
  public Double getPrice(String id, Vehicle vehicle) {
	History history = findById(id);
	Double distance = getDistance(history);
	return vehicle.getPrice().doubleValue() * distance;
  }

  @Override
  public Boolean updateCostAndVehicle(String historyId, Double price, Vehicle vehicle) {
	try {
	  History history = findById(historyId);
	  history.setCost(price);
	  history.setVehicle(vehicle);
	  System.out.println("------> " + history);
	  dao.update(history);
	  return true;
	} catch (Exception e) {
	  return false;
	}
  }

}
