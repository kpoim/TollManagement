
package com.atc.dao;

import com.atc.entity.Gate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GateDaoImpl extends SuperDao implements GateDao{
    
    
    @Override
    public List<Gate> findAll() {
        Query q = getSession().createQuery("SELECT g FROM Gate g");
        List<Gate> list = q.getResultList();
        return list;
    }

    @Override
    public void addOrUpdate(Gate g) {
        getSession().saveOrUpdate(g);
    }

    @Override
    public void delete(Integer id) {
        Gate g = getSession().getReference(Gate.class, id);
        getSession().delete(g);
    }

    @Override
    public Gate findById(Integer id) {
        return (Gate)getSession().get(Gate.class, id);
    }
    
}
