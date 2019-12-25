package com.atc.service;

import com.atc.dao.HistoryDao;
import com.atc.entity.History;
import com.atc.entity.Ongoing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

  @Autowired
  HistoryDao dao;
  
  @Override
  public History addToHistory(Ongoing ongoing) {
	History history = new History(ongoing);
	return dao.addToHistory(history) ? history : null;
  }
  
}
