package com.atc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ongoing_logs")
public class Ongoing implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ongoingid")
  private Integer id;
  
  private Integer cardid;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gateid")
  private Gate gate;
  
  private Timestamp entrytime;

  public Ongoing() {
  }

  public Ongoing(Integer cardid, Gate gate, Timestamp entrytime) {
	this.cardid = cardid;
	this.gate = gate;
	this.entrytime = entrytime;
  }

  public Ongoing(Integer id, Integer cardid, Gate gate, Timestamp entrytime) {
	this.id = id;
	this.cardid = cardid;
	this.gate = gate;
	this.entrytime = entrytime;
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

  public Gate getGate() {
	return gate;
  }

  public void setGate(Gate gate) {
	this.gate = gate;
  }

  public Timestamp getEntrytime() {
	return entrytime;
  }

  public void setEntrytime(Timestamp entrytime) {
	this.entrytime = entrytime;
  }

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 59 * hash + Objects.hashCode(this.id);
	hash = 59 * hash + Objects.hashCode(this.cardid);
	hash = 59 * hash + Objects.hashCode(this.gate);
	hash = 59 * hash + Objects.hashCode(this.entrytime);
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
	final Ongoing other = (Ongoing) obj;
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	if (!Objects.equals(this.cardid, other.cardid)) {
	  return false;
	}
	if (!Objects.equals(this.gate, other.gate)) {
	  return false;
	}
	if (!Objects.equals(this.entrytime, other.entrytime)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Ongoing{" + "id=" + id + ", cardid=" + cardid + ", gate=" + gate + ", entrytime=" + entrytime + '}';
  }
  
}
