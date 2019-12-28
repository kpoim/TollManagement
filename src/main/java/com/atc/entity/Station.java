
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class Station implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationid")
    private Integer id;
    @Column(name = "stationname")
    private String stationName;
    @Column(name = "distance")
    private Double distance;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "roadid")
    private Road road;

    public Station() {
    }

    public Station(Integer id, String stationName, Double distance, Road road) {
        this.id = id;
        this.stationName = stationName;
        this.distance = distance;
        this.road = road;
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

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.stationName);
        hash = 59 * hash + Objects.hashCode(this.distance);
        hash = 59 * hash + Objects.hashCode(this.road);
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
        if (!Objects.equals(this.road, other.road)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Station{" + "id=" + id + ", stationName=" + stationName + ", distance=" + distance + ", road=" + road + '}';
    }
    
}
