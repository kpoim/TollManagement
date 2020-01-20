package com.atc.dao;

import com.atc.entity.Geometry;
import org.springframework.stereotype.Repository;

@Repository
public class GeometryDaoImpl extends SuperDao implements GeometryDao{

  @Override
  public Geometry create(Geometry geometry) {
	getSession().save(geometry);
	return geometry;
  }
  
}
