/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atc.controller;

import com.atc.entity.Road;
import com.atc.service.RoadService;
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
@RequestMapping("/admin/manage-road")
public class ManageRoadController {
    
    @Autowired
    RoadService service;
    
    @GetMapping("/list")
    public String listRoad(Model m){
        List<Road> list = service.findAll();
        m.addAttribute("listOfRoad", list);
        return "admin/manageRoad/listRoad";
    }
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public String showForm(@ModelAttribute("road") Road r){
        return "admin/manageRoad/formRoad";
    }
    
    @PostMapping("/create")
    public String createOrUpdate(@Valid Road r, BindingResult result){
        if(result.hasErrors()){
            return "formRoad";
        }
        service.addOrUpdate(r);
        return "redirect:/admin/manage-road/list";
    }
    
    @GetMapping("/update")
    public String showUpdateForm (@RequestParam("roadId") Integer id, Model model){
        Road r = service.findById(id);
        model.addAttribute("road", r);
        return "admin/manageRoad/formRoad";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("roadId") Integer id){
        service.delete(id);
        return "redirect:/admin/manage-road/list";
    }
}
