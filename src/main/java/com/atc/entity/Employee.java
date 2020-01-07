package com.atc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee extends User implements Serializable {

  @Column(name = "firstname")
  private String fname;
  @Column(name = "lastname")
  private String lname;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;

  public Employee() {
  }

  public Employee(String fname, String lname, String phone, String email, String username, String password, Role role) {
	super(username, password, role);
	this.fname = fname;
	this.lname = lname;
	this.phone = phone;
	this.email = email;
  }

  public Employee(String fname, String lname, String phone, String email, Integer id, String username, String password, Role role) {
	super(id, username, password, role);
	this.fname = fname;
	this.lname = lname;
	this.phone = phone;
	this.email = email;
  }

  public String getFname() {
	return fname;
  }

  public void setFname(String fname) {
	this.fname = fname;
  }

  public String getLname() {
	return lname;
  }

  public void setLname(String lname) {
	this.lname = lname;
  }

  public String getPhone() {
	return phone;
  }

  public void setPhone(String phone) {
	this.phone = phone;
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
	hash = 83 * hash + Objects.hashCode(this.fname);
	hash = 83 * hash + Objects.hashCode(this.lname);
	hash = 83 * hash + Objects.hashCode(this.phone);
	hash = 83 * hash + Objects.hashCode(this.email);
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
	final Employee other = (Employee) obj;
	if (!Objects.equals(this.fname, other.fname)) {
	  return false;
	}
	if (!Objects.equals(this.lname, other.lname)) {
	  return false;
	}
	if (!Objects.equals(this.phone, other.phone)) {
	  return false;
	}
	if (!Objects.equals(this.email, other.email)) {
	  return false;
	}
	return true;
  }
  
  @Override
  public String toString() {
	return "Employee{" + "id=" + super.getId() + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email=" + email + '}';
  }

}
