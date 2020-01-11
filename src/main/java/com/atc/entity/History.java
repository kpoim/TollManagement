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
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "entrygateid")
  @JsonIgnore
  private Gate entrygate;
  private Timestamp exittime;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "exitgateid")
  @JsonIgnore
  private Gate exitgate;
  
  
  public History() {
  }

  public History(Integer id, Integer cardid, Timestamp entrytime, Gate entrygateid, Timestamp exittime, Gate exitgateid) {
	this.id = id;
	this.cardid = cardid;
	this.entrytime = entrytime;
	System.out.println("HISTORY1111");
	this.entrygate = entrygateid;
	System.out.println("HISTORY2222");
	this.exittime = exittime;
	this.exitgate = exitgateid;
	System.out.println("HISTORY3333");
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

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 97 * hash + Objects.hashCode(this.id);
	hash = 97 * hash + Objects.hashCode(this.cardid);
	hash = 97 * hash + Objects.hashCode(this.entrytime);
	hash = 97 * hash + Objects.hashCode(this.entrygate);
	hash = 97 * hash + Objects.hashCode(this.exittime);
	hash = 97 * hash + Objects.hashCode(this.exitgate);
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
	return true;
  }

  @Override
  public String toString() {
	return "History{" + "id=" + id + ", cardid=" + cardid + ", entrytime=" + entrytime + ", entrygateid=" + entrygate + ", exittime=" + exittime + ", exitgateid=" + exitgate + '}';
  }
  
  
}
