package com.atc.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pro_clients")
public class ProClient extends Client {

    @Column(name = "proafm")
    private int proafm;
    @Column(name = "companyname")
    private String companyName ;
    private String phone;
    private String address;
    private String email ;

  public ProClient() {
  }

  public ProClient(int proafm, String companyName, String phone, String address, String email, Integer clientId, String username, String password, Role role) {
	super(clientId, username, password, role);
	this.proafm = proafm;
	this.companyName = companyName;
	this.phone = phone;
	this.address = address;
	this.email = email;
  }

  public ProClient(int proafm, String companyName, String phone, String address, String email, Integer clientId, Integer id, String username, String password, Role role) {
	super(clientId, id, username, password, role);
	this.proafm = proafm;
	this.companyName = companyName;
	this.phone = phone;
	this.address = address;
	this.email = email;
  }

  public int getProafm() {
	return proafm;
  }

  public void setProafm(int proafm) {
	this.proafm = proafm;
  }

  public String getCompanyName() {
	return companyName;
  }

  public void setCompanyName(String companyName) {
	this.companyName = companyName;
  }

  public String getPhone() {
	return phone;
  }

  public void setPhone(String phone) {
	this.phone = phone;
  }

  public String getAddress() {
	return address;
  }

  public void setAddress(String address) {
	this.address = address;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  @Override
  public int hashCode() {
	int hash = 5;
	hash = 47 * hash + this.proafm;
	hash = 47 * hash + Objects.hashCode(this.companyName);
	hash = 47 * hash + Objects.hashCode(this.phone);
	hash = 47 * hash + Objects.hashCode(this.address);
	hash = 47 * hash + Objects.hashCode(this.email);
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
	final ProClient other = (ProClient) obj;
	if (this.proafm != other.proafm) {
	  return false;
	}
	if (!Objects.equals(this.companyName, other.companyName)) {
	  return false;
	}
	if (!Objects.equals(this.phone, other.phone)) {
	  return false;
	}
	if (!Objects.equals(this.address, other.address)) {
	  return false;
	}
	if (!Objects.equals(this.email, other.email)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "ProClient{" + "id=" + super.getId() + ", proafm=" + proafm + ", companyName=" + companyName + ", phone=" + phone + ", address=" + address + ", email=" + email + '}';
  }
	
}
