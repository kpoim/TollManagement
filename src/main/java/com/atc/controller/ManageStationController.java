
package com.atc.controller;

import com.atc.entity.Road;
import com.atc.entity.Station;
import com.atc.service.RoadService;
import com.atc.service.StationService;
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
@RequestMapping("/admin/manage-station")
public class ManageStationController {
    
    @Autowired
    StationService service;
    
    @Autowired
    RoadService roadService;
    
    @GetMapping("/list")
    public String listStation(Model m){
        List<Station> list = service.findAll();
        m.addAttribute("listOfStation", list);
        return "admin/manageStation/listStation";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("station") Station s, Model m){
        List<Road> list = roadService.findAll();
        m.addAttribute("listOfRoad", list);
        return "admin/manageStation/formStation";
    }
    
    @PostMapping("/create")
    public String createOrUpdate(@Valid Station s, BindingResult result){
        System.out.println("INSIDE POST CREATE");
        System.out.println(s);
        if(result.hasErrors()){
            return "admin/manageStation/formStation";
        }
        service.addOrUpdate(s);
        return "redirect:/admin/manage-station/list";
    }
    
    @GetMapping("/update")
    public String showUpdateForm (@RequestParam("stationId") Integer id , Model model){
        Station s = service.findById(id);
        model.addAttribute("station", s);
        List<Road> list = roadService.findAll();
        model.addAttribute("listOfRoad", list);
        return "admin/manageStation/formStation";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("stationId") Integer id){
        service.delete(id);
        return "redirect:/admin/manage-station/list";
    }
    
    @GetMapping("/search")
    public String searchStation(@RequestParam("search") String search, Model m){
        List<Station> list = service.findByName(search);
        m.addAttribute("listOfStation", list);
        return "admin/manageStation/listStation";
    }
    
}
