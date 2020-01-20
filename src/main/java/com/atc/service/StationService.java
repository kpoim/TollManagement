package com.atc.service;

import com.atc.entity.Station;
import java.util.List;

public interface StationService {

    List<Station> findAll();

    void addOrUpdate(Station s);

    Station findById(Integer id);

    void delete(int id);

    public List<Station> findByName(String search);
}
