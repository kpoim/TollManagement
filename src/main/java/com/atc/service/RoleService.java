package com.atc.service;

import com.atc.entity.Role;
import java.util.List;

public interface RoleService {

  public List<Role> getRoles();

  public Role findById(String source);

}
