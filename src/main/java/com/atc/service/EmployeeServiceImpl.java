
package com.atc.service;

import com.atc.dao.EmployeeDao;
import com.atc.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    EmployeeDao edao;

    @Override
    public List<Employee> findAll() {
        return edao.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return edao.findById(id);
    }

    @Override
    public void addOrUpdate(Employee e) {
        edao.addOrUpdate(e);
    }

    @Override
    public void delete(int id) {
        edao.delete(id);
    }
    
}
