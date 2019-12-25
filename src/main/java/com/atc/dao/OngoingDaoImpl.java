package com.atc.dao;

import com.atc.entity.Ongoing;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OngoingDaoImpl extends SuperDao implements OngoingDao {

  @Override
  public Ongoing findOngoingByCardId(Integer cardid) {
	Query q = getSession().createQuery("SELECT o FROM Ongoing o WHERE o.cardid = :cid");
	q.setParameter("cid", cardid);
	Ongoing ongoing = null;
	try {
	  ongoing = (Ongoing)q.getSingleResult();
	} catch (Exception e) {
	  return null;
	}
	return ongoing;
  }

  @Override
  public boolean newEntry(Ongoing ongoing) {
	getSession().save(ongoing);
	return true;
  }

  @Override
  public void delete(Ongoing ongoing) {
	getSession().delete(ongoing);
  }

}
