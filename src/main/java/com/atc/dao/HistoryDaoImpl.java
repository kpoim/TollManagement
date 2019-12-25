package com.atc.dao;

import com.atc.entity.History;
import org.springframework.stereotype.Repository;


@Repository
public class HistoryDaoImpl extends SuperDao implements HistoryDao {

  @Override
  public boolean addToHistory(History history) {
	getSession().save(history);
	return true;
  }

}
