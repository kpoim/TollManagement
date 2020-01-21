
package com.atc.controller;

import com.atc.entity.Gate;
import com.atc.entity.Station;
import com.atc.entity.Terminal;
import com.atc.entity.WrapperGateTerminal;
import com.atc.service.GateService;
import com.atc.service.StationService;
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
    
    @Autowired
    StationService stationService;
    
    @GetMapping
    public String adminHome() {
        return "admin/manageGate/home";
    }

    @GetMapping("/list")
    public String listGate(Model m) {
        List<Terminal> list = terminalService.findAll();
        m.addAttribute("listOfTerminal", list);
        return "admin/manageGate/listGate";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("wrapperGateTerminal") WrapperGateTerminal w, Model m){
        List<Station> list = stationService.findAll();
        m.addAttribute("listOfStation", list);
        return "admin/manageGate/formGate";
    }
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("wrapperGateTerminal") WrapperGateTerminal w, BindingResult result, Model m){
        if(result.hasErrors()){
            return "admin/manageGate/formGate";
        }
        Gate gate = w.getGate();
        Terminal terminal= w.getTerminal();
        Terminal existing = terminalService.findByUsername(terminal.getUsername());
        if(existing!=null){
            m.addAttribute("wrapperGateTerminal", new WrapperGateTerminal());
            m.addAttribute("wrapperGateTerminalExistsError", "This terminal already exists");
            return "admin/manageGate/formGate";
        }
        gateService.addOrUpdate(gate);
        terminal.setGate(gate);
        terminalService.addOrUpdate(terminal);
        return "redirect:/admin/manage-gate/list";
    }
    
    @GetMapping("/update")
    public String showUpdateForm (@RequestParam("gateId") String id, Model model){
        Gate g = gateService.findById(id);
        List<Station> list = stationService.findAll();
        model.addAttribute("listOfStation", list);
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
    public String delete(@RequestParam("gateId") Integer id){
        Gate g = gateService.findById(id);
        Terminal t = terminalService.findByGateId(g);
        terminalService.delete(t);
        return "redirect:/admin/manage-gate/list";
    }
    
}
