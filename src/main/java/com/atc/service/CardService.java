package com.atc.service;

import com.atc.entity.Card;
import com.atc.entity.Client;
import java.util.List;

public interface CardService {

  Card create();

  public List<Card> getCardsByClientId(Client c);

  public List<Card> findAll();
  
}
