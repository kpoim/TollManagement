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
  public Gate findById(Integer id) {
	Gate gate = null;
	gate = getSession().byId(Gate.class).load(id);
	System.out.println("\n\n----------->INSIDE GATEDAO");
	System.out.println(gate);
	return gate;
  }

  @Override
  public List<Gate> findEntryGatesByStationId(Integer id) {
	return getSession().createQuery("SELECT g FROM Gate g WHERE g.isEntry = 0 AND g.station = :id").setParameter("id", id).getResultList();
  }
  
}
