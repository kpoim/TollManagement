
package com.atc.dao;

import com.atc.entity.Employee;
import java.util.List;


public interface EmployeeDao {
    
    List<Employee> findAll();
    
    List<Employee> findAllAdmins();
    
    List<Employee> findAllEmployees();
    
    public void add(Employee e);
    
    public Employee findById(Integer id);
    
    public void delete(Integer id);

    public void addOrUpdate(Employee empl);

    public Employee findByUsername(String username);
}
