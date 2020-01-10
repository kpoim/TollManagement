
package com.atc.dao;

import com.atc.entity.Employee;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends SuperDao implements EmployeeDao{

    @Override
    public List<Employee> findAll() {
        Query q = getSession().createQuery("FROM Employee");
        List<Employee> list = q.getResultList();
        return list;
    }

    @Override
    public void addOrUpdate(Employee e) {
        getSession().saveOrUpdate(e);
    }

    @Override
    public Employee findById(Integer id) {
        return (Employee)getSession().get(Employee.class, id);
    }

    @Override
    public void delete(Integer id) {
        Employee e = getSession().getReference(Employee.class, id);
        getSession().delete(e);
    }
    
}
