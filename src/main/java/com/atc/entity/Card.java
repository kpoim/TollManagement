package com.atc.entity;

import java.io.Serializable;
import java.util.List;
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

@Entity
@Table(name = "card")
public class Card implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cardid")
  private int id;
  @OneToMany(mappedBy = "cardid")
  private List<History> historyData;
  @JoinColumn(name = "clientid")
  @ManyToOne
  private Client client;

  public Card() {
  }

  public Card(int cardid) {
	this.id = cardid;
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public Client getClient() {
	return client;
  }

  public void setClient(Client client) {
//	client.addCard(this);
	this.client = client;
  }

  public List<History> getHistoryData() {
	return historyData;
  }

  public void setHistoryData(List<History> historyData) {
	this.historyData = historyData;
  }

  @Override
  public int hashCode() {
	int hash = 5;
	hash = 67 * hash + this.id;
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
	final Card other = (Card) obj;
	if (this.id != other.id) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Card{" + "id=" + id + ", client=" + client + '}';
  }

}
