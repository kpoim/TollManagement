
package com.atc.dao;

import com.atc.entity.ProClient;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProClientDaoImpl extends SuperDao implements ProClientDao{

    @Override
    public List<ProClient> findAll() {
        Query q = getSession().createQuery("SELECT pc FROM ProClient pc");
        List<ProClient> list = q.getResultList();
        return list;
    }

    @Override
    public void addOrUpdate(ProClient pc) {
        getSession().saveOrUpdate(pc);
    }

    @Override
    public void delete(Integer id) {
        ProClient pc = getSession().getReference(ProClient.class, id);
        getSession().delete(pc);
    }

    @Override
    public ProClient findById(Integer id) {
        return (ProClient)getSession().get(ProClient.class, id);
    }
    
}
