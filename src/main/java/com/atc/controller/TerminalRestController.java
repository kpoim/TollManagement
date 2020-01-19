/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atc.controller;

import com.atc.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terminal-api/")
public class TerminalRestController {
  
  @Autowired
  HistoryService historyService;
  
  
  
  @GetMapping("/store-geometry/{id}")
  public ResponseEntity<Boolean> storeGeometry(@PathVariable("id") String historyId){
	return ResponseEntity.ok().body(true);
  }
  
  @PostMapping("/store-geometry/{id}")
  public ResponseEntity<Boolean> storeGeometry(@PathVariable("id") String historyId, @RequestBody String geometry){
	historyService.findById(historyId);
	return ResponseEntity.ok().body(historyService.addGeometry(historyId, geometry));
  }
}
