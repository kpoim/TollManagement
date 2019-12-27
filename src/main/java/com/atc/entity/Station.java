
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class Station implements Serializable{
    
    @Id
    @Column(name = "stationid")
    private Integer id;
    @Column(name = "stationname")
    private String stationName;
    @Column(name = "distance")
    private Double distance;
    @Column(name = "roadid")
    private Integer roadid;

    public Station() {
    }

    public Station(Integer id, String stationName, Double distance, Integer roadid) {
        this.id = id;
        this.stationName = stationName;
        this.distance = distance;
        this.roadid = roadid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getRoadid() {
        return roadid;
    }

    public void setRoadid(Integer roadid) {
        this.roadid = roadid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.stationName);
        hash = 13 * hash + Objects.hashCode(this.distance);
        hash = 13 * hash + Objects.hashCode(this.roadid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Station other = (Station) obj;
        if (!Objects.equals(this.stationName, other.stationName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.distance, other.distance)) {
            return false;
        }
        if (!Objects.equals(this.roadid, other.roadid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Station{" + "id=" + id + ", stationName=" + stationName + ", distance=" + distance + ", roadid=" + roadid + '}';
    }
    
    
}
