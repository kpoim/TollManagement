package com.atc.service;

import com.atc.entity.Role;
import java.util.List;

public interface RoleService {

  List<Role> getRoles();

  Role findById(String source);

}
