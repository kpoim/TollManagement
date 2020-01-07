package com.atc.service;

import com.atc.dao.HistoryDao;
import com.atc.entity.Gate;
import com.atc.entity.History;
import com.atc.entity.Ongoing;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

  @Autowired
  HistoryDao dao;
  
  
  
  @Override
  public History addToHistory(Ongoing ongoing, Gate exitGate) {
	History history = new History(
		ongoing.getId(),
		ongoing.getCardid(),
		ongoing.getEntrytime(),
		ongoing.getGate(), 
		java.sql.Timestamp.valueOf(LocalDateTime.now()),
		exitGate
	);
	System.out.println("HistService HISTORY: " + history);
	return dao.addToHistory(history) ? history : null;
  }
  
}
