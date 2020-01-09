package com.atc.dao;

import com.atc.entity.History;
import org.springframework.stereotype.Repository;


@Repository
public class HistoryDaoImpl extends SuperDao implements HistoryDao {

  @Override
  public boolean addToHistory(History history) {
	System.out.println("HDAO 1111111");
	getSession().save(history);
	System.out.println("HDAO 22222");
	return true;
  }

}
