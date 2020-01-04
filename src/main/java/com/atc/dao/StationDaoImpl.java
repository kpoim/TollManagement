package com.atc.dao;

import com.atc.entity.Station;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class StationDaoImpl extends SuperDao implements StationDao {

  @Override
  public List<Station> findAll() {
	return getSession().createQuery("from Station").getResultList();
  }
  
}
