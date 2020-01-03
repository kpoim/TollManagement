package com.atc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ongoing_logs")
public class Ongoing implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ongoingid")
  private Integer id;
  
  private Integer cardid;
  
  private Integer gateid;
  
  private Timestamp entrytime;

  public Ongoing() {
  }

  public Ongoing(Integer cardid, Integer gateid, Timestamp entrytime) {
	this.cardid = cardid;
	this.gateid = gateid;
	this.entrytime = entrytime;
  }

  public Ongoing(Integer id, Integer cardid, Integer gateid, Timestamp entrytime) {
	this.id = id;
	this.cardid = cardid;
	this.gateid = gateid;
	this.entrytime = entrytime;
  }

  public Integer getGateid() {
	return gateid;
  }

  public void setGateid(Integer gateid) {
	this.gateid = gateid;
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

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 59 * hash + Objects.hashCode(this.id);
	hash = 59 * hash + Objects.hashCode(this.cardid);
	hash = 59 * hash + Objects.hashCode(this.gateid);
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
	if (!Objects.equals(this.gateid, other.gateid)) {
	  return false;
	}
	if (!Objects.equals(this.entrytime, other.entrytime)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Ongoing{" + "id=" + id + ", cardid=" + cardid +  ", gateid=" + gateid + ", entrytime=" + entrytime + '}';
  }
}
