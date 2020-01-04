package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String username;
  
  private String password;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rid")
  private Role role;

  public User() {
  }

  public User(String username, String password, Role role) {
	this.username = username;
	this.password = password;
	this.role = role;
  }

  public User(Integer id, String username, String password, Role role) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.role = role;
  }

  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
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

  public Role getRole() {
	return role;
  }

  public void setRole(Role role) {
	this.role = role;
  }

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 29 * hash + Objects.hashCode(this.id);
	hash = 29 * hash + Objects.hashCode(this.username);
	hash = 29 * hash + Objects.hashCode(this.password);
	hash = 29 * hash + Objects.hashCode(this.role);
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
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	if (!Objects.equals(this.role, other.role)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + '}';
  }

}
