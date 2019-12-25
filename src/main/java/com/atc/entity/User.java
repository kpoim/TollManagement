package com.atc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer uid;

  @NotEmpty
  @Size(min = 1, max = 30)
  private String username;

  @NotEmpty
  private String password;

  @NotEmpty
  @Size(min = 1, max = 20)
  private String fname;

  @NotEmpty
  @Size(min = 1, max = 20)
  private String lname;

  @NotEmpty
  @Size(min = 1, max = 20)
  private String email;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",
	  joinColumns = @JoinColumn(name = "uid"),
	  inverseJoinColumns = @JoinColumn(name = "rid")
	  )
  List<Role> roles;

  public User() {
  }

  public User(Integer uid, String username, String password, String fname, String lname, String email) {
	this.uid = uid;
	this.username = username;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
  }

  public Integer getUid() {
	return uid;
  }

  public void setUid(Integer uid) {
	this.uid = uid;
  }

  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
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

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  public List<Role> getRoles() {
	return roles;
  }

  public void setRoles(List<Role> roles) {
	this.roles = roles;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 67 * hash + Objects.hashCode(this.uid);
	hash = 67 * hash + Objects.hashCode(this.username);
	hash = 67 * hash + Objects.hashCode(this.password);
	hash = 67 * hash + Objects.hashCode(this.fname);
	hash = 67 * hash + Objects.hashCode(this.lname);
	hash = 67 * hash + Objects.hashCode(this.email);
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
	final User other = (User) obj;
	if (!Objects.equals(this.username, other.username)) {
	  return false;
	}
	if (!Objects.equals(this.password, other.password)) {
	  return false;
	}
	if (!Objects.equals(this.fname, other.fname)) {
	  return false;
	}
	if (!Objects.equals(this.lname, other.lname)) {
	  return false;
	}
	if (!Objects.equals(this.email, other.email)) {
	  return false;
	}
	if (!Objects.equals(this.uid, other.uid)) {
	  return false;
	}
	return true;
  }

  public void addRole(Role role){
	if(roles == null) roles = new ArrayList<>();
	roles.add(role);
  }
  
  @Override
  public String toString() {
	return "User{" + "uid=" + uid + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
  }

}
