
package com.atc.dao;

import com.atc.entity.AllClients;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AllClientsDaoImpl extends SuperDao implements AllClientsDao{

    @Override
    public List<AllClients> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrUpdate(AllClients ac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AllClients findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
