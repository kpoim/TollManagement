
package com.atc.dao;

import com.atc.entity.Gate;
import com.atc.entity.Terminal;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TerminalDaoImpl extends SuperDao implements TerminalDao{

    @Override
    public void addOrUpdate(Terminal t) {
        getSession().saveOrUpdate(t);
    }
    
    @Override
    public void delete(Terminal t) {
        getSession().delete(t);
    } 

    @Override
    public Terminal findByGateId(Gate g) {
        Query q = getSession().createQuery("SELECT t FROM Terminal t WHERE t.gate = : gate");
	q.setParameter("gate", g);
	Terminal terminal = null;
	try {
	  terminal = (Terminal) q.getSingleResult();
	} catch (NoResultException e) {
	}
	return terminal;
    }

    @Override
    public Terminal findByUsername(String username) {
        Query q = getSession().createQuery("SELECT t FROM Terminal t WHERE t.username = : username");
        q.setParameter("username", username);
        Terminal terminal = null;
	try {
	  terminal = (Terminal) q.getSingleResult();
	} catch (NoResultException e) {
	}
	return terminal;
    }

}
