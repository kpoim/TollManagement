
package com.atc.service;

import com.atc.entity.Employee;
import java.util.List;


public interface AdminService {
    
    List<Employee> findAll();
    
    List<Employee> findAllAdmins();
    
    
    
    Employee findById(Integer id);
    
    public void add(Employee e);
    
    public void delete(int id);

    public void addOrUpdate(Employee empl);
}
