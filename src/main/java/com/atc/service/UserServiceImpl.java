package com.atc.service;

import com.atc.components.MyUserDetails;
import com.atc.dao.UserDao;
import com.atc.entity.Role;
import com.atc.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  UserDao dao;

  @Override
  public User findByUsernme(String username) {
	return dao.findByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
	User user = findByUsernme(string);
	System.out.println("\n\n\n----USER---->");
	System.out.println(user);
	if (user == null) {
	  throw new UsernameNotFoundException("Invalid Username");
	}
	return new MyUserDetails(user);
//	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRole()));
  }

  private Collection<? extends GrantedAuthority> getGrantedAuthorities(Role role) {
	List<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(new SimpleGrantedAuthority(role.getRname()));
	return authorities;
  }
}
