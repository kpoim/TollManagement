package com.atc.dao;

import com.atc.entity.Gate;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GateDaoImpl extends SuperDao implements GateDao {

  @Override
  public List<Gate> findAll() {
	return getSession().createQuery("from Gate").getResultList();
  }

  @Override
  public List<Gate> findByStationId(Integer id) {
	return getSession().createQuery("SELECT g FROM Gate g WHERE g.stationid = :id").setParameter("id", id).getResultList();
  }
  
}
