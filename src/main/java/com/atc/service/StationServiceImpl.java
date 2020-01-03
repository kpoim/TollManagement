package com.atc.service;

import com.atc.dao.StationDao;
import com.atc.entity.Station;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StationServiceImpl implements StationService {

  @Autowired
  StationDao dao;
  
  @Override
  public List<Station> findAll() {
	return dao.findAll();
  }
  
  
  
}
