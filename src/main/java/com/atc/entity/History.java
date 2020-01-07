package com.atc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "History")
@Table(name = "history")
public class History implements Serializable {

    @Id
    @Column(name = "historyid")
    private Integer id;
    @JoinColumn(name = "cardid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Integer cardid;
    private Timestamp entrytime;
    private Integer entrygateid;
    private Timestamp exittime;
    private Integer exitgateid;

    public History() {
    }

    public History(Ongoing ongoing) {
        this.id = ongoing.getId();
        this.cardid = ongoing.getCardid();
        this.entrytime = ongoing.getEntrytime();
        this.exittime = Timestamp.valueOf(LocalDateTime.now());
        this.entrygateid = ongoing.getGateid();
        this.exitgateid = 100;
    }

    public History(Integer cardid, Timestamp entrytime, Integer entrygateid, Timestamp exittime, Integer exitgateid) {
        this.cardid = cardid;
        this.entrytime = entrytime;
        this.entrygateid = entrygateid;
        this.exittime = exittime;
        this.exitgateid = exitgateid;
    }

    public History(Integer id, Integer cardid, Timestamp entrytime, Integer entrygateid, Timestamp exittime, Integer exitgateid) {
        this.id = id;
        this.cardid = cardid;
        this.entrytime = entrytime;
        this.entrygateid = entrygateid;
        this.exittime = exittime;
        this.exitgateid = exitgateid;
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

    public Timestamp getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Timestamp entrytime) {
        this.entrytime = entrytime;
    }

    public Integer getEntrygateid() {
        return entrygateid;
    }

    public void setEntrygateid(Integer entrygateid) {
        this.entrygateid = entrygateid;
    }

    public Timestamp getExittime() {
        return exittime;
    }

    public void setExittime(Timestamp exittime) {
        this.exittime = exittime;
    }

    public Integer getExitgateid() {
        return exitgateid;
    }

    public void setExitgateid(Integer exitgateid) {
        this.exitgateid = exitgateid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.cardid);
        hash = 79 * hash + Objects.hashCode(this.entrytime);
        hash = 79 * hash + Objects.hashCode(this.entrygateid);
        hash = 79 * hash + Objects.hashCode(this.exittime);
        hash = 79 * hash + Objects.hashCode(this.exitgateid);
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
        final History other = (History) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cardid, other.cardid)) {
            return false;
        }
        if (!Objects.equals(this.entrytime, other.entrytime)) {
            return false;
        }
        if (!Objects.equals(this.entrygateid, other.entrygateid)) {
            return false;
        }
        if (!Objects.equals(this.exittime, other.exittime)) {
            return false;
        }
        if (!Objects.equals(this.exitgateid, other.exitgateid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", cardid=" + cardid + ", entrytime=" + entrytime + ", entrygateid=" + entrygateid + ", exittime=" + exittime + ", exitgateid=" + exitgateid + '}';
    }

}
