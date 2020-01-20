package com.atc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "client")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(column = @Column(name = "id"), name = "id")
public class Client extends User implements Serializable {

  @Column(name = "clientid")
  private Integer clientId;
  
  private String question;
  
  private String answer;

    public Client() {
    }

    public Client(Integer clientId, String username, String password, Role role) {
	super(username, password, role);
	this.clientId = clientId;
  }

  public Client(Integer clientId, Integer id, String username, String password, Role role) {
	super(id, username, password, role);
	this.clientId = clientId;
  }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.clientId);
        hash = 73 * hash + Objects.hashCode(this.question);
        hash = 73 * hash + Objects.hashCode(this.answer);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", question=" + question + ", answer=" + answer + '}';
    }
  
  
  
}
