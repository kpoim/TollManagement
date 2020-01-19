
package com.atc.controller;

import com.atc.entity.Gate;
import com.atc.entity.Terminal;
import com.atc.entity.WrapperGateTerminal;
import com.atc.service.GateService;
import com.atc.service.TerminalService;
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
    GateService gateService;
    
    @Autowired
    TerminalService terminalService;
    
    @GetMapping
    public String adminHome() {
        return "admin/manageGate/home";
    }

    @GetMapping("/list")
    public String listGate(Model m) {
        List<Gate> list = gateService.findAll();
        m.addAttribute("listOfGate", list);
        return "admin/manageGate/listGate";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("wrapperGateTerminal") WrapperGateTerminal w){
        return "admin/manageGate/formGate";
    }
    
    @PostMapping("/create")
    public String create(@Valid WrapperGateTerminal w, BindingResult result){
        if(result.hasErrors()){
            return "admin/manageGate/formGate";
        }
        gateService.addOrUpdate(w.getGate());
        Terminal terminal= w.getTerminal();
        terminal.setGate(w.getGate());
        terminalService.addOrUpdate(terminal);
        //Adding gateId to Terminal
        return "redirect:/admin/manage-gate/list";
    }
    
    @GetMapping("/update")
    public String showUpdateForm (@RequestParam("gateId") String id, Model model){
        Gate g = gateService.findById(id);
        model.addAttribute("gate", g);
        return "admin/manageGate/formUpdateGate";
    }
    
    @PostMapping("/update")
    public String update(@Valid Gate g, BindingResult result){
        if(result.hasErrors()){
            return "admin/manageGate/formUpdateGate";
        }
        gateService.addOrUpdate(g);
        return "redirect:/admin/manage-gate/list";
    }
    
    
    @GetMapping("/delete")
    public String delete(@RequestParam("gateId") String id){
        Gate g = gateService.findById(id);
        Terminal t = terminalService.findByGateId(g);
        terminalService.delete(t); 
        return "redirect:/admin/manage-gate/list";
    }
    
}
