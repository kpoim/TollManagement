package com.atc.controller;

import com.atc.entity.Gate;
import com.atc.entity.Station;
import com.atc.service.GateService;
import com.atc.service.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
  
  @Autowired
  StationService stationService;
  
  @Autowired
  GateService gateService;
  
  @GetMapping("/get-stations")
  public ResponseEntity<List<Station>> getStations(){
	List<Station> stations = stationService.findAll();
	return ResponseEntity.ok().body(stations);
  }
  
  @GetMapping("/get-gates/by-station/{id}")
  public ResponseEntity<List<Gate>> getGatesByStationId(@PathVariable("id") String id){
	List<Gate> gates = gateService.findByStationId(id);
	return ResponseEntity.ok().body(gates);
  }
}
