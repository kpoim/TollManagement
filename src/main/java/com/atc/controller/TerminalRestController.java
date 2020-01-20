/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atc.controller;

import com.atc.entity.Geometry;
import com.atc.service.GeometryService;
import com.atc.service.HistoryService;
import java.sql.Array;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/terminal-api", consumes = "application/json", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class TerminalRestController {

  @Autowired
  HistoryService historyService;

  @Autowired
  GeometryService geometryService;
  
  @GetMapping("/return-json")
  public ResponseEntity<Geometry> returnJson(){
	return ResponseEntity.ok().body(new Geometry());
  }

  @PostMapping(value = "/store-json")//, consumes = TEXT_HTML)
  public ResponseEntity<Geometry> storeGeometryGET(@RequestBody String payload) {
	System.out.println(payload);
	return ResponseEntity.ok().body(new Geometry());
  }

//  public @ResponseBody Geometry storeGeometry(@PathVariable("id") String historyId, @RequestBody Geometry json){
  @PostMapping("/store-geometry/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Geometry> storeGeometry(@PathVariable("id") String historyId, @RequestBody Geometry json) {
//    String json = httpEntity.getBody();
	System.out.println("json = " + json);
//	geometryService.create(json);
//	System.out.println(geometry);
//	historyService.findById(historyId);
//	return ResponseEntity.ok().body("response-text");
	return ResponseEntity.ok().body(json);
//	return json;
  }
}
