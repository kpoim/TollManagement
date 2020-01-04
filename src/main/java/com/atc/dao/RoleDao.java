package com.atc.dao;

import com.atc.entity.Role;
import java.util.List;

public interface RoleDao {

  public List<Role> getRoles();

  public Role findById(Integer source);

}
