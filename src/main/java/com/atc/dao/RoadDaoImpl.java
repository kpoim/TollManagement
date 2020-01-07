
package com.atc.dao;

import com.atc.entity.Road;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoadDaoImpl extends SuperDao implements RoadDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Road> findAll() {
        Query q = getSession().createQuery("SELECT r FROM Road r");
        List<Road> list = q.getResultList();
        return list;
    }

    @Override
    public void createOrUpdate(Road r) {
        getSession().saveOrUpdate(r);
    }

    @Override
    public Road findById(Integer id) {
        return (Road)getSession().get(Road.class, id);
    }

    @Override
    public void delete(int id) {
        Road r = getSession().getReference(Road.class, id);
        getSession().delete(r);
    }
}
