
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "all_clients")
public class AllClients implements Serializable{
    
    @Id
    @Column(name = "clientid")
    private Integer id;
    @Column(name = "cardid")
    private Integer cardid;
    @Column(name = "retailafm")
    private Integer rafm;
    @Column(name = "proafm")
    private Integer pafm;

    public AllClients() {
    }

    public AllClients(Integer id, Integer cardid, Integer rafm, Integer pafm) {
        this.id = id;
        this.cardid = cardid;
        this.rafm = rafm;
        this.pafm = pafm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getRafm() {
        return rafm;
    }

    public void setRafm(Integer rafm) {
        this.rafm = rafm;
    }

    public Integer getPafm() {
        return pafm;
    }

    public void setPafm(Integer pafm) {
        this.pafm = pafm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.cardid);
        hash = 97 * hash + Objects.hashCode(this.rafm);
        hash = 97 * hash + Objects.hashCode(this.pafm);
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
        final AllClients other = (AllClients) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cardid, other.cardid)) {
            return false;
        }
        if (!Objects.equals(this.rafm, other.rafm)) {
            return false;
        }
        if (!Objects.equals(this.pafm, other.pafm)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AllClients{" + "id=" + id + ", cardid=" + cardid + ", rafm=" + rafm + ", pafm=" + pafm + '}';
    }
    
}
