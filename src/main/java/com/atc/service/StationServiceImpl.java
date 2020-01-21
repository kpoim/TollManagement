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
    public List<Station> findAll() {
        return sdao.findAll();
    }

    @Override
    public void addOrUpdate(Station s) {
        sdao.addOrUpdate(s);
    }

    @Override
    public Station findById(Integer id) {
        return sdao.findById(id);
    }

    @Override
    public void delete(int id) {
        sdao.delete(id);
    }

    @Override
    public List<Station> findByName(String search) {
        List<Station> list = sdao.findByName(search);
        return list;
    }
    
}
