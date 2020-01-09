package com.atc.service;

import com.atc.dao.StationDao;
import com.atc.entity.Station;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StationServiceImpl implements StationService {

  @Autowired
    StationDao sdao;

    @Override
    public List<Station> getAllStations() {
        return sdao.findAll();
    }

    @Override
    public void createOrUpdateStation(Station s) {
        sdao.createOrUpdate(s);
    }

    @Override
    public Station findStationById(Integer id) {
        return sdao.findById(id);
    }

    @Override
    public void deleteStation(int id) {
        sdao.delete(id);
    }
    
}
