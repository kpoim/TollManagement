package com.atc.service;

import com.atc.dao.CardDao;
import com.atc.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardServiceImpl implements CardService {

  @Autowired
  CardDao dao;
  
  @Override
  public Card create() {
	return dao.addOrUpdate(new Card());
  }
  
}
