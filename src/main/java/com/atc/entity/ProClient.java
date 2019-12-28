
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pro_client")
public class ProClient implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proafm")
    private Integer pafm;
    @Column(name = "companyname")
    private String companyName;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;

    public ProClient() {
    }

    public ProClient(Integer pafm, String companyName, Integer phone, String address, String email) {
        this.pafm = pafm;
        this.companyName = companyName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Integer getPafm() {
        return pafm;
    }

    public void setPafm(Integer pafm) {
        this.pafm = pafm;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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
        hash = 59 * hash + Objects.hashCode(this.pafm);
        hash = 59 * hash + Objects.hashCode(this.companyName);
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
        final ProClient other = (ProClient) obj;
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.pafm, other.pafm)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProClients{" + "pafm=" + pafm + ", companyName=" + companyName + ", phone=" + phone + ", address=" + address + ", email=" + email + '}';
    }
    
    
}
