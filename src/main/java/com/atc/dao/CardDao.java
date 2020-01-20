
package com.atc.dao;

import com.atc.entity.Card;
import java.util.List;


public interface CardDao {
    
    List<Card> findAll();
    
    Card addOrUpdate(Card c);
    
    void delete(Integer id);
    
    Card findById(Integer id);
}
