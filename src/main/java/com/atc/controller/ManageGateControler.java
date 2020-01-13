
package com.atc.controller;

import com.atc.entity.Gate;
import com.atc.service.GateService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/manage-gate")
public class ManageGateControler {
    
    @Autowired
    GateService service;
    
    @GetMapping
    public String adminHome() {
        return "admin/manageGate/home";
    }

    @GetMapping("/list")
    public String listGate(Model m) {
        List<Gate> list = service.findAll();
        m.addAttribute("listOfGate", list);
        return "admin/manageGate/listGate";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("gate") Gate g){
        return "admin/manageGate/formGate";
    }
    
    @PostMapping("/create")
    public String createOrUpdate(@Valid Gate g, BindingResult result){
        if(result.hasErrors()){
            return "formGate";
        }
        service.addOrUpdate(g);
        return "redirect:/admin/manage-gate/list";
    }
    
    @GetMapping("/update")
    public String showUpdateForm (@RequestParam("gateId") String id, Model model){
        Gate g = service.findById(id);
        model.addAttribute("gate", g);
        return "admin/manageGate/formGate";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("gateId") Integer id){
        service.delete(id);
        return "redirect:/admin/manage-gate/list";
    }
    
}
