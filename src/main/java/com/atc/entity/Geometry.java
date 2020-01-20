package com.atc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "geometry")
public class Geometry implements Serializable {

  @Id
  @JsonProperty("id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "geometry")
  @JsonProperty("geometry")
  private String geometry;

  public Geometry() {
  }

  public Geometry(Integer id, String geometry) {
	this.id = id;
	this.geometry = geometry;
  }

  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  public String getGeometry() {
	return geometry;
  }

  public void setGeometry(String geometry) {
	this.geometry = geometry;
  }

  @Override
  public int hashCode() {
	int hash = 5;
	hash = 89 * hash + Objects.hashCode(this.id);
	hash = 89 * hash + Objects.hashCode(this.geometry);
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
	final Geometry other = (Geometry) obj;
	if (!Objects.equals(this.geometry, other.geometry)) {
	  return false;
	}
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Geometry{" + "id=" + id + ", geometry=" + geometry + '}';
  }

}
