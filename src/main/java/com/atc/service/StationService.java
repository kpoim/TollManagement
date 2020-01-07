package com.atc.service;

import com.atc.entity.Station;
import java.util.List;

public interface StationService {

    List<Station> getAllStations();

    public void createOrUpdateStation(Station s);

    public Station findStationById(Integer id);

    public void deleteStation(int id);
}
