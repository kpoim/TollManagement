package com.atc.service;

import com.atc.dao.GateDao;
import com.atc.dao.StationDao;
import com.atc.entity.Employee;
import com.atc.entity.Gate;
import com.atc.entity.Station;
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

  @Autowired
  StationDao sdao;

  @Override
  public List<Gate> findAll() {
	return dao.findAll();
  }

  @Override
  public Gate findById(String id) {
	return dao.findById(Integer.parseInt(id));
  }

  @Override
  public List<Gate> findEntryGatesByStationId(String index) {
	Station station = null;
	try {
	  Integer id = Integer.parseInt(index);
	  station = sdao.findById(id);
	} catch (NumberFormatException e) {
	  return new ArrayList<>();
	}
	return dao.findEntryGatesByStationObj(station);
  }

  @Override
  public boolean addEmployee(String gateIndex, Employee employee) {
	Gate gate = findById(gateIndex);
	if (gate == null) {
	  return false;
	}
	gate.setEmployee(employee);
	return true;
  }

    @Override
    public void addOrUpdate(Gate g) {
       dao.addOrUpdate(g);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

}
