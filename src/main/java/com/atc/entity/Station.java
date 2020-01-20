package com.atc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Station")
@Table(name = "station")
public class Station implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stationid")
  private Integer id;
  @Size(min = 4, max = 50, message = "The name must have at least 4 digits")
  @Column(name = "stationname")
  private String stationName;
  @NotNull(message = "This value is required")
  @Min(value = 0, message = "Cannot be a negative number")
  @Column(name = "distance")
  private Double distance;
  @Column(name = "latitude")
  private BigDecimal latitude;
  @Column(name = "longtitude")
  private BigDecimal longitude;
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "roadid")
  //@JsonIgnoreProperties("stations")
  @JsonBackReference
  private Road road;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
  @JsonIgnore
  @JsonManagedReference
  private List<Gate> gates;

  public Station() {
  }

  public Station(Integer id, String stationName, Double distance, BigDecimal latitude, BigDecimal longitude, Road road, List<Gate> gates) {
	this.id = id;
	this.stationName = stationName;
	this.distance = distance;
	this.latitude = latitude;
	this.longitude = longitude;
	this.road = road;
	this.gates = gates;
  }

  public BigDecimal getLatitude() {
	return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
	this.latitude = latitude;
  }

  public BigDecimal getLongtitude() {
	return longitude;
  }

  public void setLongtitude(BigDecimal longitude) {
	this.longitude = longitude;
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

  public List<Gate> getGates() {
	return gates;
  }

  public void setGates(List<Gate> gates) {
	this.gates = gates;
  }

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 97 * hash + Objects.hashCode(this.id);
	hash = 97 * hash + Objects.hashCode(this.stationName);
	hash = 97 * hash + Objects.hashCode(this.distance);
	hash = 97 * hash + Objects.hashCode(this.latitude);
	hash = 97 * hash + Objects.hashCode(this.longitude);
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
	if (!Objects.equals(this.latitude, other.latitude)) {
	  return false;
	}
	if (!Objects.equals(this.longitude, other.longitude)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Station{" + "id=" + id + ", stationName=" + stationName + ", distance=" + distance + ", latitude=" + latitude + ", longitude=" + longitude + '}';
  }

}
