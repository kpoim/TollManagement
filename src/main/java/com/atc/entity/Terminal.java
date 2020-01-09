package com.atc.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Terminal extends User {

  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "gateid")
  private Gate gate;
  
  public Terminal() {
  }

  public Gate getGate() {
	return gate;
  }

  public void setGate(Gate gate) {
	this.gate = gate;
  }

  public Terminal(String username, String password, Role role) {
	super(username, password, role);
  }

  public Terminal(Integer id, String username, String password, Role role) {
	super(id, username, password, role);
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 37 * hash + Objects.hashCode(this.gate);
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
	final Terminal other = (Terminal) obj;
	if (!Objects.equals(this.gate, other.gate)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Terminal{" + super.toString() + '}';
  }
  
}
