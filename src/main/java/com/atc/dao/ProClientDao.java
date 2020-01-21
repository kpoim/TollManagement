package com.atc.dao;

import com.atc.entity.ProClient;

public interface ProClientDao {
  
  ProClient create(ProClient c);

    public ProClient findByUsername(String username);
  
}
