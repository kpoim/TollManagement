
package com.atc.service;

import com.atc.entity.Employee;
import java.util.List;


public interface EmployeeService {
    
    List<Employee> findAll();
    
    List<Employee> findAllEmployees();
    
    Employee findById(Integer id);
    
    void add(Employee e);
    
    void delete(int id);

    void addOrUpdate(Employee empl);
}
