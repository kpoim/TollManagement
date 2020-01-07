package com.atc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "gate")
public class Gate implements Serializable {

  @Id
  @Column(name = "gateid")
  private Integer id;
  @Column(name = "gateno")
  private Integer gateNo;
  @Column(name = "stationid")
  private Integer stationid;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employeeid")
  @JsonIgnore
  private Employee employee;
  @Column(columnDefinition = "TINYINT", name = "isentry")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  public boolean isEntry;

  public Gate() {
  }

  public Gate(Integer gateNo, Integer stationid, Employee employee, boolean isEntry) {
	this.gateNo = gateNo;
	this.stationid = stationid;
	this.employee = employee;
	this.isEntry = isEntry;
  }

  public Gate(Integer id, Integer gateNo, Integer stationid, Employee employee, boolean isEntry) {
	this.id = id;
	this.gateNo = gateNo;
	this.stationid = stationid;
	this.employee = employee;
	this.isEntry = isEntry;
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

  public Employee getEmployee() {
	return employee;
  }

  public void setEmployee(Employee employee) {
	this.employee = employee;
  }

  public boolean isIsEntry() {
	return isEntry;
  }

  public void setIsEntry(boolean isEntry) {
	this.isEntry = isEntry;
  }

  @Override
  public int hashCode() {
	int hash = 5;
	hash = 97 * hash + Objects.hashCode(this.id);
	hash = 97 * hash + Objects.hashCode(this.gateNo);
	hash = 97 * hash + Objects.hashCode(this.stationid);
	hash = 97 * hash + Objects.hashCode(this.employee);
	hash = 97 * hash + (this.isEntry ? 1 : 0);
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
	if (this.isEntry != other.isEntry) {
	  return false;
	}
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	if (!Objects.equals(this.gateNo, other.gateNo)) {
	  return false;
	}
	if (!Objects.equals(this.stationid, other.stationid)) {
	  return false;
	}
	if (!Objects.equals(this.employee, other.employee)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Gate{" + "id=" + id + ", gateNo=" + gateNo + ", stationid=" + stationid + ", isEntry=" + isEntry + '}';
  }
  
}
