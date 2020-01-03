
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gate")
public class Gate implements Serializable{
    
    @Id
    @Column(name = "gateid")
    private Integer id;
    @Column(name = "gateno")
    private Integer gateNo;
    @Column(name = "stationid")
    private Integer stationid;

    public Gate() {
    }

    public Gate(Integer id, Integer gateNo, Integer stationid) {
        this.id = id;
        this.gateNo = gateNo;
        this.stationid = stationid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGateNo() {
        return gateNo;
    }

    public void setGateNo(Integer gateNo) {
        this.gateNo = gateNo;
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.gateNo);
        hash = 79 * hash + Objects.hashCode(this.stationid);
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
        final Gate other = (Gate) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.gateNo, other.gateNo)) {
            return false;
        }
        if (!Objects.equals(this.stationid, other.stationid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gate{" + "id=" + id + ", gateNo=" + gateNo + ", stationid=" + stationid + '}';
    }
    
    
}
