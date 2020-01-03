package com.atc.service;

import com.atc.dao.GateDao;
import com.atc.entity.Gate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GateServiceImpl implements GateService {

  @Autowired
  GateDao dao;
  
  @Override
  public List<Gate> findAll() {
	return dao.findAll();
  }

  @Override
  public List<Gate> findByStationId(String index) {
	Integer id;
	try {
	  id = Integer.parseInt(index);
	} catch (NumberFormatException e) {
	  return new ArrayList<>();
	}
	return dao.findByStationId(id);
  }
  
  
  
}
