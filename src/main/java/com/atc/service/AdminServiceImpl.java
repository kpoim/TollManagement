package com.atc.service;

import com.atc.dao.EmployeeDao;
import com.atc.dao.RetailClientDao;
import com.atc.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

  @Autowired
  EmployeeDao edao;

  @Autowired
  RoleService roleService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public List<Employee> findAll() {
	return edao.findAll();
  }
  
  @Override
    public List<Employee> findAllAdmins() {
           return edao.findAllAdmins();
    }

    

  @Override
  public Employee findById(Integer id) {
	return edao.findById(id);
  }

  @Override
  public void add(Employee e) {
	e.setRole(roleService.findById("1"));
	e.setPassword(passwordEncoder.encode(e.getPassword()));
        
	edao.add(e);
  }

  @Override
  public void delete(int id) {
	edao.delete(id);
  }

    @Override
    public void addOrUpdate(Employee empl) {
        
        edao.addOrUpdate(empl);
    }

    @Override
    public Employee findByUsername(String username) {
        return edao.findByUsername(username);
    }

    

}
