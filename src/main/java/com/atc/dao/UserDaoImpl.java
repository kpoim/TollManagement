package com.atc.dao;

import com.atc.entity.User;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends SuperDao implements UserDao {

  @Override
  public User findByUsername(String username) {
	Query q = getSession().createQuery("SELECT u FROM User u WHERE u.username = : un");
	q.setParameter("un", username);
	User user = null;
	try {
	  user = (User) q.getSingleResult();
	} catch (NoResultException e) {
	}
	return user;
  }

}
