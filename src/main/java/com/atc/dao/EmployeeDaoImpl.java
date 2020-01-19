package com.atc.dao;

import com.atc.entity.Employee;
import com.atc.entity.User;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends SuperDao implements EmployeeDao {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Employee> findAll() {
        Query q = getSession().createQuery("FROM Employee ");
        List<Employee> list = q.getResultList();
        return list;
    }
    
    //findALl for admins & Employees
    @Override
    public List<Employee> findAllAdmins() {
        Query q = getSession().createQuery("SELECT e FROM Employee e WHERE e.role= 1 ");
        List<Employee> list = q.getResultList();
        return list;
    }

    @Override
    public List<Employee> findAllEmployees() {
        Query q = getSession().createQuery("SELECT e FROM Employee e WHERE e.role= 2 ");
        List<Employee> list = q.getResultList();
        return list;
    }

    
    

    @Override
    public void add(Employee e) {
        getSession().save(e);
    }

    @Override
    public Employee findById(Integer id) {
        return (Employee) getSession().get(Employee.class, id);
    }

    @Override
    public void delete(Integer id) {
        Employee e = getSession().getReference(Employee.class, id);
        getSession().delete(e);
    }

    @Override
    public void addOrUpdate(Employee empl) {
        Query q = getSession().createQuery("SELECT password FROM User u WHERE u.id=:id");
        q.setParameter("id", empl.getId());
        List<String> list = q.getResultList();
        System.out.println("======================================"+passwordEncoder.matches(empl.getPassword(),list.get(0)) );
        System.out.println("------------------------Password from form "+empl.getPassword());
        System.out.println("------------------------Password from database "+ list.get(0));
        if (!(list.isEmpty())) {
            System.out.println("-------------------------------------" + list.get(0) + "--------" + (empl.getPassword().equals(list.get(0))));
            if (passwordEncoder.matches(empl.getPassword(),list.get(0))) {
                empl.setPassword(passwordEncoder.encode(empl.getPassword()));
                getSession().saveOrUpdate(empl);
                System.out.println("1111111"+empl.getPassword());
            }else if(empl.getPassword().equals(list.get(0))){
                System.out.println("2222222"+empl.getPassword());
                getSession().saveOrUpdate(empl);
            }
            else {
                System.out.println("3333333"+empl.getPassword());
                
                empl.setPassword(passwordEncoder.encode(empl.getPassword()));
                
                getSession().saveOrUpdate(empl);
            }

        }
        
    }

    
}
