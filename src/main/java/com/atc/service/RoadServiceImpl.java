
package com.atc.service;

import com.atc.dao.RoadDao;
import com.atc.entity.Road;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoadServiceImpl implements RoadService{
    
    @Autowired
    RoadDao rdao;

    @Override
    public List<Road> findAll() {
        return rdao.findAll();
    }

    @Override
    public void addOrUpdate(Road r) {
        rdao.addOrUpdate(r);
    }

    @Override
    public Road findById(Integer id) {
        return rdao.findById(id);
    }

    @Override
    public void delete(int id) {
        rdao.delete(id);
    }

    
}
