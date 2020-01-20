package com.atc.dao;

import com.atc.entity.Vehicle;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDaoImpl extends SuperDao implements VehicleDao{

  @Override
  public List<Vehicle> findAll() {
	return getSession().createQuery("FROM Vehicle").getResultList();
  }

  @Override
  public Vehicle findByName(String s) {
	try {
	  return getSession().byId(Vehicle.class).load(s);
	} catch (Exception e) {
	  return null;
	}
  }
  
}
