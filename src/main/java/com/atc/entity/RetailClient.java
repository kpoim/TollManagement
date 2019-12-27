
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retail_client")
public class RetailClient implements Serializable{
    
    @Id
    @Column(name = "retailafm")
    private Integer rafm;
    @Column(name = "firstname")
    private String fname;
    @Column(name = "lastname")
    private String lname;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "email")
    private String email;

    public RetailClient() {
    }

    public RetailClient(Integer rafm, String fname, String lname, Integer phone, String email) {
        this.rafm = rafm;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    public Integer getRafm() {
        return rafm;
    }

    public void setRafm(Integer rafm) {
        this.rafm = rafm;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.rafm);
        hash = 23 * hash + Objects.hashCode(this.fname);
        hash = 23 * hash + Objects.hashCode(this.lname);
        hash = 23 * hash + Objects.hashCode(this.phone);
        hash = 23 * hash + Objects.hashCode(this.email);
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
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.lname, other.lname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.rafm, other.rafm)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RetailClient{" + "rafm=" + rafm + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email=" + email + '}';
    }
    
    
    
}
