
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gate")
public class Gate implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gateid")
    private Integer id;
    @Column(name = "gateNo")
    private Integer gateNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "stationid")
    private Station station;
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "employeeid")
    private Employee employee;

    public Gate() {
    }

    public Gate(Integer id, Integer gateNo, Station station, Employee employee) {
        this.id = id;
        this.gateNo = gateNo;
        this.station = station;
        this.employee = employee;
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

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.gateNo);
        hash = 61 * hash + Objects.hashCode(this.station);
        hash = 61 * hash + Objects.hashCode(this.employee);
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
        if (!Objects.equals(this.station, other.station)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gate{" + "id=" + id + ", gateNo=" + gateNo + ", station=" + station + ", employee=" + employee + '}';
    }

    
    
    
}
