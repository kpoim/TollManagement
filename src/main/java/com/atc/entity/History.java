package com.atc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "History")
@Table(name = "history_logs")
public class History implements Serializable {
  
  @Id
  @Column(name = "historyid")
  private Integer id;
  private Integer cardid;
  private Timestamp entrytime;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "entrygateid")
//  @JsonIgnore
  private Gate entrygate;
  private Timestamp exittime;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "exitgateid")
//  @JsonIgnore
  private Gate exitgate;
  @Column(name = "geometry")
  private String geometry;
  @Column(name = "cost")
  private Double cost;
  @JoinColumn(name = "vehicle")
  @ManyToOne(fetch = FetchType.EAGER)
  private Vehicle vehicle;
  
  
  public History() {
  }

  public History(Integer id, Integer cardid, Timestamp entrytime, Gate entrygate, Timestamp exittime, Gate exitgate) {
	this.id = id;
	this.cardid = cardid;
	this.entrytime = entrytime;
	this.entrygate = entrygate;
	this.exittime = exittime;
	this.exitgate = exitgate;
  }
  
  

  public History(Integer id, Integer cardid, Timestamp entrytime, Gate entrygate, Timestamp exittime, Gate exitgate, String geometry) {
	this.id = id;
	this.cardid = cardid;
	this.entrytime = entrytime;
	this.entrygate = entrygate;
	this.exittime = exittime;
	this.exitgate = exitgate;
	this.geometry = geometry;
  }
  

  public History(Integer id, Integer cardid, Timestamp entrytime, Gate entrygate, Timestamp exittime, Gate exitgate, String geometry, Double cost, Vehicle vehicle) {
	this.id = id;
	this.cardid = cardid;
	this.entrytime = entrytime;
	this.entrygate = entrygate;
	this.exittime = exittime;
	this.exitgate = exitgate;
	this.geometry = geometry;
	this.cost = cost;
	this.vehicle = vehicle;
  }
  
  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  public Integer getCardid() {
	return cardid;
  }

  public void setCardid(Integer cardid) {
	this.cardid = cardid;
  }

  public Timestamp getEntrytime() {
	return entrytime;
  }

  public void setEntrytime(Timestamp entrytime) {
	this.entrytime = entrytime;
  }

  public Gate getEntrygate() {
	return entrygate;
  }

  public void setEntrygate(Gate entrygate) {
	this.entrygate = entrygate;
  }

  public Timestamp getExittime() {
	return exittime;
  }

  public void setExittime(Timestamp exittime) {
	this.exittime = exittime;
  }

  public Gate getExitgate() {
	return exitgate;
  }

  public void setExitgate(Gate exitgate) {
	this.exitgate = exitgate;
  }

  public String getGeometry() {
	return geometry;
  }

  public void setGeometry(String geometry) {
	this.geometry = geometry;
  }

  public Double getCost() {
	return cost;
  }

  public void setCost(Double cost) {
	this.cost = cost;
  }

  public Vehicle getVehicle() {
	return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 29 * hash + Objects.hashCode(this.id);
	hash = 29 * hash + Objects.hashCode(this.cardid);
	hash = 29 * hash + Objects.hashCode(this.entrytime);
	hash = 29 * hash + Objects.hashCode(this.entrygate);
	hash = 29 * hash + Objects.hashCode(this.exittime);
	hash = 29 * hash + Objects.hashCode(this.exitgate);
	hash = 29 * hash + Objects.hashCode(this.geometry);
	hash = 29 * hash + Objects.hashCode(this.cost);
	hash = 29 * hash + Objects.hashCode(this.vehicle);
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
	final History other = (History) obj;
	if (!Objects.equals(this.geometry, other.geometry)) {
	  return false;
	}
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	if (!Objects.equals(this.cardid, other.cardid)) {
	  return false;
	}
	if (!Objects.equals(this.entrytime, other.entrytime)) {
	  return false;
	}
	if (!Objects.equals(this.entrygate, other.entrygate)) {
	  return false;
	}
	if (!Objects.equals(this.exittime, other.exittime)) {
	  return false;
	}
	if (!Objects.equals(this.exitgate, other.exitgate)) {
	  return false;
	}
	if (!Objects.equals(this.cost, other.cost)) {
	  return false;
	}
	if (!Objects.equals(this.vehicle, other.vehicle)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "History{" + "id=" + id + ", cardid=" + cardid + ", entrytime=" + entrytime + ", entrygate=" + entrygate + ", exittime=" + exittime + ", exitgate=" + exitgate + ", geometry=" + geometry + ", cost=" + cost + ", vehicle=" + vehicle + '}';
  }

  
}
