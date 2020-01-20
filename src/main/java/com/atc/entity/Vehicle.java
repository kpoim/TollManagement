package com.atc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "ppkm")
  private BigDecimal price;

  public Vehicle() {
  }

  public Vehicle(String name, BigDecimal price) {
	this.name = name;
	this.price = price;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public BigDecimal getPrice() {
	return price;
  }

  public void setPrice(BigDecimal price) {
	this.price = price;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 71 * hash + Objects.hashCode(this.name);
	hash = 71 * hash + Objects.hashCode(this.price);
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
	final Vehicle other = (Vehicle) obj;
	if (!Objects.equals(this.name, other.name)) {
	  return false;
	}
	if (!Objects.equals(this.price, other.price)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Vehicle{" + "name=" + name + ", price=" + price + '}';
  }
  
}
