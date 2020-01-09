
package com.atc.service;

import com.atc.dao.RoadDao;
import com.atc.entity.Road;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class RoadServiceImpl implements RoadService{
    @Autowired
    RoadDao rdao;

    @Override
    public List<Road> getAllRoads() {
        return rdao.findAll();
    }

    @Override
    public void createOrUpdateRoad(Road r) {
        rdao.createOrUpdate(r);
    }

    @Override
    public Road findRoadById(Integer id) {
        return rdao.findById(id);
    }

    @Override
    public void deleteRoad(int id) {
        rdao.delete(id);
    }
}
