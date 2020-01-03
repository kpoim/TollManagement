
package com.atc.dao;

import com.atc.entity.Employee;
import java.util.List;


public interface EmployeeDao {
    
    List<Employee> findAll();
    
    public void addOrUpdate(Employee e);
    
    public void delete(Integer id);
    
    public Employee findById(Integer id);
}
