
package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "all_client")
public class AllClients implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private Integer id;
    @OneToMany(mappedBy = "cardid")
    @Column(name = "cardid")
    private Card card;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "retailafm")
    private RetailClient rafm;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "proafm")
    private ProClient pafm;

    public AllClients() {
    }

    public AllClients(Integer id, Card card, RetailClient rafm, ProClient pafm) {
        this.id = id;
        this.card = card;
        this.rafm = rafm;
        this.pafm = pafm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public RetailClient getRafm() {
        return rafm;
    }

    public void setRafm(RetailClient rafm) {
        this.rafm = rafm;
    }

    public ProClient getPafm() {
        return pafm;
    }

    public void setPafm(ProClient pafm) {
        this.pafm = pafm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.card);
        hash = 83 * hash + Objects.hashCode(this.rafm);
        hash = 83 * hash + Objects.hashCode(this.pafm);
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
        if (!Objects.equals(this.card, other.card)) {
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
        return "AllClients{" + "id=" + id + ", card=" + card + ", rafm=" + rafm + ", pafm=" + pafm + '}';
    }

    
    
}
