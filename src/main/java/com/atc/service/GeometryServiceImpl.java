package com.atc.service;

import com.atc.dao.GeometryDao;
import com.atc.entity.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeometryServiceImpl implements GeometryService {

  @Autowired
  GeometryDao dao;
  
  @Override
  public Geometry create(Geometry geometry) {
	return dao.create(geometry);
  }
  
}
