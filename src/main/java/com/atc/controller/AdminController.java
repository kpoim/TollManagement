package com.atc.controller;

import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.Employee;
import com.atc.service.AdminService;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin")
@SessionAttributes("persistantAdmin")
public class AdminController {

    @Autowired
    AuthenticationFacade auth;

    @Autowired
    AdminService adminService;

    @GetMapping
    public String adminHome(Model m) {
        MyUserDetails principal = (MyUserDetails) auth.getAuthentication().getPrincipal();
        Employee empl = (Employee) principal.getUser();
        System.out.println("PRINCIPAL" + (principal));
        m.addAttribute("admin", empl);
        System.out.println("ADMIN=================="+empl);
        return "admin/home";
    }
    
    @GetMapping("/list-admin")
    public String listOfAdmins(Model m) {
        List<Employee> list = adminService.findAllAdmins();
        m.addAttribute("listOfAdmin", list);
        return "admin/manageAdmin/listAdmin";
    }
    

    @GetMapping("/create")
    public String adminCreate(@ModelAttribute("admin") Employee empl) {
        return "admin/manageAdmin/createAdmin";
    }

    @PostMapping("/new-admin")
    public String newAdmin(@Valid Employee empl, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/manageAdmin/createAdmin";
        }
        adminService.add(empl);
        return "redirect:/admin";
    }
    
    
    @GetMapping("/update/{id}")
    public String showUpdateForm (@PathVariable("id") String id, Model model){
        Employee admin = adminService.findById(Integer.parseInt(id));
        model.addAttribute("persistantAdmin", admin);
        return "admin/manageAdmin/updateAdmin";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute("persistantAdmin") @Valid Employee empl, BindingResult result){
        if(result.hasErrors()){
            return "admin/manageAdmin/updateAdmin";
        }
        System.out.println("Employee"+empl);
        adminService.addOrUpdate(empl);
        return "redirect:/admin";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        adminService.delete(Integer.parseInt(id));
        return "redirect:/admin/list";
    }
   
    

}
