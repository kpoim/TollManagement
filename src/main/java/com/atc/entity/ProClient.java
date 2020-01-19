package com.atc.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pro_clients")
public class ProClient extends Client {
    
    @NotNull(message="AFM cannot be null") 
    @Min(value=9, message="AFM must have more than 9 digits")
  //  @Max(value=10, message="AFM must not have more 10 digits")
    @Column(name = "proafm")
    private Long proafm;
    @Size(min=3, max=100, message="The company name must be within 3 and 100 characters")
    @Column(name = "companyname")
    private String companyName ;
//    @Min(value=10, message="Must be at least 10 digits")
    private String phone;
    @Size(min=5, max=50, message="The address must be within 5 and 50 characters")
    private String address;
    @Email(message="not a valid email address")
    private String email ;

  public ProClient() {
  }

  public ProClient(Long proafm, String companyName, String phone, String address, String email, Integer clientId, String username, String password, Role role) {
	super(clientId, username, password, role);
	this.proafm = proafm;
	this.companyName = companyName;
	this.phone = phone;
	this.address = address;
	this.email = email;
  }

  public ProClient(Long proafm, String companyName, String phone, String address, String email, Integer clientId, Integer id, String username, String password, Role role) {
	super(clientId, id, username, password, role);
	this.proafm = proafm;
	this.companyName = companyName;
	this.phone = phone;
	this.address = address;
	this.email = email;
  }

  public Long getProafm() {
	return proafm;
  }

  public void setProafm(Long proafm) {
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
	hash = 47 * hash + Objects.hashCode(this.proafm);
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
	if (!Objects.equals(this.proafm, other.proafm)) {
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
