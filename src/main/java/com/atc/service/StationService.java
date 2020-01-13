package com.atc.service;

import com.atc.entity.Station;
import java.util.List;

public interface StationService {

    List<Station> findAll();

    public void addOrUpdate(Station s);

    public Station findById(Integer id);

    public void delete(int id);
}
