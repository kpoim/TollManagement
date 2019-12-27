
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
    @Column(name = "gateNo")
    private Integer gateNo;
    @Column(name = "stationid")
    private Integer stationid;
    @Column(name = "employeeid")
    private Integer employeeid;

    public Gate() {
    }

    public Gate(Integer id, Integer gateNo, Integer stationid, Integer employeeid) {
        this.id = id;
        this.gateNo = gateNo;
        this.stationid = stationid;
        this.employeeid = employeeid;
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

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.gateNo);
        hash = 79 * hash + Objects.hashCode(this.stationid);
        hash = 79 * hash + Objects.hashCode(this.employeeid);
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
        if (!Objects.equals(this.employeeid, other.employeeid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gate{" + "id=" + id + ", gateNo=" + gateNo + ", stationid=" + stationid + ", employeeid=" + employeeid + '}';
    }
    
    
}
