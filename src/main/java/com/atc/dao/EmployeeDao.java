
package com.atc.dao;

import com.atc.entity.Employee;
import java.util.List;


public interface EmployeeDao {
    
    List<Employee> findAll();
    
    public void addOrUpdate(Employee e);
    
    public Employee findById(Integer id);
    
    public void delete(Integer id);
}
