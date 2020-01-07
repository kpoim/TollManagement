
package com.atc.service;

import com.atc.entity.Road;
import java.util.List;


public interface RoadService {
    
    List<Road> getAllRoads();

    public void createOrUpdateRoad(Road r);

    public Road findRoadById(Integer id);

    public void deleteRoad(int id);
}
