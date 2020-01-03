
package com.atc.dao;

import com.atc.entity.AllClients;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AllClientsDaoImpl extends SuperDao implements AllClientsDao{

    @Override
    public List<AllClients> findAll() {
        Query q = getSession().createQuery("SELECT ac FROM AllClients ac");
        List<AllClients> list = q.getResultList();
        return list;
    }

    @Override
    public void addOrUpdate(AllClients ac) {
        getSession().saveOrUpdate(ac);
    }

    @Override
    public void delete(Integer id) {
        AllClients ac = getSession().getReference(AllClients.class, id);
        getSession().delete(ac);
    }

    @Override
    public AllClients findById(Integer id) {
        return (AllClients)getSession().get(AllClients.class, id);
    }
    
}
