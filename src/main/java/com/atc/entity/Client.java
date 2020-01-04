package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "client")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(column = @Column(name = "id"), name = "id")
public class Client extends User implements Serializable {

  @Column(name = "clientid")
  private Integer clientId;

  public Client() {
  }

  public Client(Integer clientId, String username, String password, Role role) {
	super(username, password, role);
	this.clientId = clientId;
  }

  public Client(Integer clientId, Integer id, String username, String password, Role role) {
	super(id, username, password, role);
	this.clientId = clientId;
  }
  

  public Integer getClientId() {
	return clientId;
  }

  public void setClientId(Integer clientId) {
	this.clientId = clientId;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 47 * hash + Objects.hashCode(this.clientId);
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
	final Client other = (Client) obj;
	if (!Objects.equals(this.clientId, other.clientId)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return super.toString() + "\nClient{" + "clientId=" + clientId + "}\n";
  }
  
}
