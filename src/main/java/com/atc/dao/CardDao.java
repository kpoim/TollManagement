
package com.atc.dao;

import com.atc.entity.Card;
import com.atc.entity.Client;
import java.util.List;


public interface CardDao {
    
    List<Card> findAll();
    
    Card addOrUpdate(Card c);
    
    void delete(Integer id);
    
    Card findById(Integer id);

  public List<Card> getCardsByClientId(Client c);
}
