package com.atc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "gate")
public class Gate implements Serializable {

  @Id
  @Column(name = "gateid")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "gateno")
  private Integer gateNo;
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "stationid", referencedColumnName = "stationid")
  @JsonBackReference
  private Station station;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employeeid")
  @JsonIgnore
  private Employee employee;
  @Column(columnDefinition = "TINYINT", name = "isentry")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  public boolean isEntry;

  public Gate() {
  }

  public Gate(Integer id, Integer gateNo, Station station, Employee employee, boolean isEntry) {
	this.id = id;
	this.gateNo = gateNo;
	this.station = station;
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

  public boolean isIsEntry() {
	return isEntry;
  }

  public void setIsEntry(boolean isEntry) {
	this.isEntry = isEntry;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 41 * hash + Objects.hashCode(this.id);
	hash = 41 * hash + Objects.hashCode(this.gateNo);
	hash = 41 * hash + Objects.hashCode(this.station);
	hash = 41 * hash + Objects.hashCode(this.employee);
	hash = 41 * hash + (this.isEntry ? 1 : 0);
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
	return "Gate{" + "id=" + id + ", gateNo=" + gateNo + ", isEntry=" + isEntry + '}';
  }
  

}
