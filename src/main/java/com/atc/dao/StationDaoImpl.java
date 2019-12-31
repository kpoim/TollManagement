
package com.atc.dao;

import com.atc.entity.Station;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StationDaoImpl extends SuperDao implements StationDao{
    
    
    @Override
    public List<Station> findAll() {
        Query q = getSession().createQuery("SELECT s FROM Station s");
        List<Station> list = q.getResultList();
        return list;
    }

    @Override
    public void addOrUpdate(Station s) {
        getSession().saveOrUpdate(s);
    }

    @Override
    public void delete(Integer id) {
        Station s = getSession().getReference(Station.class, id);
        getSession().delete(s);
    }

    @Override
    public Station findById(Integer id) {
        return (Station)getSession().get(Station.class, id);
    }
    
    
}
