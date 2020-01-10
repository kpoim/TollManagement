
package com.atc.service;

import com.atc.entity.Employee;
import java.util.List;


public interface EmployeeService {
    
    List<Employee> findAll();
    
    Employee findById(Integer id);
    
    public void addOrUpdate(Employee e);
    
    public void delete(int id);
}
