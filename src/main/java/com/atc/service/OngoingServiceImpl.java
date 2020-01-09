package com.atc.service;

import com.atc.dao.OngoingDao;
import com.atc.entity.Gate;
import com.atc.entity.Ongoing;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OngoingServiceImpl implements OngoingService {

  @Autowired
  OngoingDao dao;

  @Override
  public Ongoing findOngoingByCardId(String cardid) {
	return dao.findOngoingByCardId(Integer.parseInt(cardid));
  }

  @Override
  public Ongoing newEntry(String cardId, Gate gate) {
	Ongoing ongoing = new Ongoing(Integer.parseInt(cardId), gate, java.sql.Timestamp.valueOf(LocalDateTime.now()));
	return dao.newEntry(ongoing) ? ongoing : null;
  }

  @Override
  public void delete(Ongoing ongoing) {
	dao.delete(ongoing);
  }
}
