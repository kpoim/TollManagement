package com.atc.service;

import com.atc.dao.VehicleDao;
import com.atc.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

  @Autowired
  VehicleDao dao;
  
  @Override
  public List<Vehicle> findAll() {
	return dao.findAll();
  }

  @Override
  public List<String> findAllVehicleNames() {
	List<String> names = new ArrayList();
	findAll().forEach(vehicle -> {
	  names.add(vehicle.getName());
	});
	return names;
  }

  @Override
  public Vehicle findByName(String s) {
	return dao.findByName(s);
  }
  
  
  
}
