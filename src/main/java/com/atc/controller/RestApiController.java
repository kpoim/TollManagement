package com.atc.controller;

import com.atc.components.MyUserDetails;
import com.atc.entity.Employee;
import com.atc.entity.Gate;
import com.atc.entity.Station;
import com.atc.entity.User;
import com.atc.service.GateService;
import com.atc.service.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-api")
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
  public ResponseEntity<List<Gate>> getEntryGatesByStationId(@PathVariable("id") String id){
	List<Gate> gates = gateService.findEntryGatesByStationId(id);
	return ResponseEntity.ok().body(gates);
  }
  
  @GetMapping("/add-to-gate/{id}")
  public ResponseEntity<Boolean> addEmployeeToGate(@PathVariable("id") String id, Authentication authentication){
	MyUserDetails principal = (MyUserDetails)authentication.getPrincipal();
	Employee employee = (Employee) principal.getUser();
	return ResponseEntity.ok().body(gateService.addEmployee(id, employee));
  }
}
