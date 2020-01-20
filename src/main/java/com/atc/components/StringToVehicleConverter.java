package com.atc.components;

import com.atc.entity.Vehicle;
import com.atc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToVehicleConverter implements Converter<String, Vehicle> {

  @Autowired
  VehicleService service;
  
  @Override
  public Vehicle convert(String s) {
	return service.findByName(s);
  }
  
}
