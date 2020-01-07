
package com.atc.dao;

import com.atc.entity.Card;
import java.util.List;


public interface CardDao {
    
    List<Card> findAll();
    
    public void addOrUpdate(Card c);
    
    public void delete(Integer id);
    
    public Card findById(Integer id);
}
