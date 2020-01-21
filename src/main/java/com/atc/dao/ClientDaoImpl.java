package com.atc.dao;

import com.atc.entity.Card;
import com.atc.entity.Client;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends SuperDao implements ClientDao {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Client> findAllClients() {
        Query q = getSession().createQuery("FROM Client ");
        List<Client> list = q.getResultList();
        return list;
    }

    @Override
    public Client findById(Integer id) {
        return (Client) getSession().get(Client.class, id);
    }
    
    @Override
    public Client findByUsername(String username) {
        Query q = getSession().createQuery("SELECT c FROM Client c WHERE c.username=:username ");
        q.setParameter("username", username);
        Client client =(Client) q.uniqueResult();
        return client;
    }

    @Override
    public Client create(Client c) {
        getSession().save(c);
        return c;
    }

    @Override
    public void delete(int id) {
        Client c = getSession().getReference(Client.class, id);
        getSession().delete(c);
    }

    @Override
    public void addOrUpdate(Client client) {
        Query q = getSession().createQuery("SELECT password FROM User u WHERE u.id=:id");
        q.setParameter("id", client.getId());
        List<String> list = q.getResultList();
        if (!(list.isEmpty())) {
            System.out.println("-------------------------------------" + list.get(0) + "--------" + (client.getPassword().equals(list.get(0))));
            if ((client.getPassword().equals(list.get(0)))) {
                getSession().saveOrUpdate(client);
            } else {
                client.setPassword(passwordEncoder.encode(client.getPassword()));
                getSession().saveOrUpdate(client);
            }

        }
    }

    @Override
    public void changePassword(Client client) {
        getSession().saveOrUpdate(client);
    }

  @Override
  public List<Card> getCards(Client client) {
	return ((Client) getSession().createQuery("SELECT c FROM Client c WHERE c.id = :id").setParameter("id", client.getId()).getResultList().get(0)).getCards();
  }


    
    
    

}
