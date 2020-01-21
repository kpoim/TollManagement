package com.atc.service;

import com.atc.dao.CardDao;
import com.atc.entity.Card;
import com.atc.entity.Client;
import java.util.List;
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

  @Override
  public List<Card> getCardsByClientId(Client c) {
	return dao.getCardsByClientId(c);
  }

  @Override
  public List<Card> findAll() {
	return dao.findAll();
  }
  
}
