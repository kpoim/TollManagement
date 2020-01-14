package com.atc.controller;

import com.atc.entity.Employee;
import com.atc.service.EmployeeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/manage-employee")
public class ManageEmployee {

    @Autowired
    EmployeeService service;

    @GetMapping
    public String adminHome() {
        return "admin/manageEmployee/home";
    }

    @GetMapping("/listEmployee")
    public String listEmployee(Model m) {
        List<Employee> list = service.findAll();
        m.addAttribute("listOfEmployee", list);
        return "admin/manageEmployee/listEmployee";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("employee") Employee e){
        return "admin/manageEmployee/formEmployee";
    }
    
    @PostMapping("/create")
    public String createOrUpdate(@Valid Employee e, BindingResult result){
        if(result.hasErrors()){
            return "formEmployee";
        }
        service.add(e);
        return "redirect:/admin/manage-employee/listEmployee";
    }
}
