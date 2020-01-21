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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin/manage-employee")
@SessionAttributes("persistantEmployee")
public class ManageEmployeeController {

    @Autowired
    EmployeeService service;

    
    @GetMapping("/list-employee")
    public String listEmployee(Model m) {
        List<Employee> list = service.findAllEmployees();
        m.addAttribute("listOfEmployee", list);
        return "admin/manageEmployee/listEmployee";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("employee") Employee e){
        return "admin/manageEmployee/formEmployee";
    }
    
    @PostMapping("/create")
    public String createOrUpdate(@Valid @ModelAttribute("employee") Employee e, BindingResult result, Model m){
        if(result.hasErrors()){
            return "admin/manageEmployee/formEmployee";
        }
        Employee exists = service.findByUsername(e.getUsername());
        if(exists!=null){
            m.addAttribute("employee", new Employee());
            m.addAttribute("employeeExistsError", "This username is taken");
            return "admin/manageEmployee/formEmployee";
        }
        service.add(e);
        return "redirect:/admin/manage-employee/listEmployee";
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateForm (@PathVariable("id") String id, Model model){
        Employee admin = service.findById(Integer.parseInt(id));
        model.addAttribute("persistantEmployee", admin);
        return "admin/manageEmployee/updateEmployee";
    }
    
     @PostMapping("/update")
    public String update(@ModelAttribute("persistantEmployee") @Valid Employee empl, BindingResult result){
        if(result.hasErrors()){
            return "admin/manageEmployee/updateEmployee";
        }
        System.out.println("Employee"+empl);
        service.addOrUpdate(empl);
        return "redirect:/admin";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        service.delete(Integer.parseInt(id));
        return "redirect:/admin/manage-employee/list-employee";
    }
    
}
