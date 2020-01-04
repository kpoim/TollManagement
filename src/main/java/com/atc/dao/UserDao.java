package com.atc.dao;

import com.atc.entity.User;

public interface UserDao {

  User findByUsername(String username);

}
