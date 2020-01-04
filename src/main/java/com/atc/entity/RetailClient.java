package com.atc.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "retail_clients")
public class RetailClient extends Client {

    @Column(name = "retailafm")
    private int retailAfm;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;

  public RetailClient() {
  }
  

  public RetailClient(int retailAfm, String firstname, String lastname, String phone, String address, String email, Integer clientId, String username, String password, Role role) {
	super(clientId, username, password, role);
	this.retailAfm = retailAfm;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phone = phone;
	this.address = address;
	this.email = email;
  }

  public RetailClient(int retailAfm, String firstname, String lastname, String phone, String address, String email, Integer clientId, Integer id, String username, String password, Role role) {
	super(clientId, id, username, password, role);
	this.retailAfm = retailAfm;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phone = phone;
	this.address = address;
	this.email = email;
  }

  public int getRetailAfm() {
	return retailAfm;
  }

  public void setRetailAfm(int retailAfm) {
	this.retailAfm = retailAfm;
  }

  public String getFirstname() {
	return firstname;
  }

  public void setFirstname(String firstname) {
	this.firstname = firstname;
  }

  public String getLastname() {
	return lastname;
  }

  public void setLastname(String lastname) {
	this.lastname = lastname;
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
	int hash = 7;
	hash = 59 * hash + this.retailAfm;
	hash = 59 * hash + Objects.hashCode(this.firstname);
	hash = 59 * hash + Objects.hashCode(this.lastname);
	hash = 59 * hash + Objects.hashCode(this.phone);
	hash = 59 * hash + Objects.hashCode(this.address);
	hash = 59 * hash + Objects.hashCode(this.email);
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
	final RetailClient other = (RetailClient) obj;
	if (this.retailAfm != other.retailAfm) {
	  return false;
	}
	if (!Objects.equals(this.firstname, other.firstname)) {
	  return false;
	}
	if (!Objects.equals(this.lastname, other.lastname)) {
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
	return "RetailClient{" + "id=" + super.getId() + ", retailAfm=" + retailAfm + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", address=" + address + ", email=" + email + '}';
  }

}
