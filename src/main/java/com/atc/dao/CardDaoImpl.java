
package com.atc.dao;

import com.atc.entity.Card;
import com.atc.entity.Client;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardDaoImpl extends SuperDao implements CardDao{

    @Override
    public List<Card> findAll() {
        Query q = getSession().createQuery("SELECT c FROM Card c");
        List<Card> list = q.getResultList();
        return list;
    }

    @Override
    public Card addOrUpdate(Card c) {
        getSession().saveOrUpdate(c);
		 System.out.println("-------> " + c);
		return c.getId() == 0 ? null : c;
    }

    @Override
    public void delete(Integer id) {
        Card c = getSession().getReference(Card.class, id);
        getSession().delete(c);
    }

    @Override
    public Card findById(Integer id) {
        return (Card)getSession().get(Card.class, id);
    }

  @Override
  public List<Card> getCardsByClientId(Client c) {
	return getSession().createQuery("SELECT c FROM Card c WHERE c.client.id = :id").setParameter("id", c.getId()).getResultList();
  }
    
}
