package com.atc.dao;

import com.atc.entity.Role;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends SuperDao implements RoleDao {

  @Override
  public List<Role> getRoles() {
	Query q = getSession().createQuery("from Role");
	return q.getResultList();
  }

  @Override
  public Role findById(Integer source) {
	return getSession().byId(Role.class).load(source);
  }

}
