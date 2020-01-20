package com.atc.controller;

import com.atc.components.AuthenticationFacade;
import com.atc.components.MyUserDetails;
import com.atc.entity.Client;
import com.atc.entity.Employee;
import com.atc.entity.Gate;
import com.atc.entity.Road;
import com.atc.entity.Station;
import com.atc.entity.Vehicle;
import com.atc.service.ClientService;
import com.atc.service.GateService;
import com.atc.service.HistoryService;
import com.atc.service.RoadService;
import com.atc.service.StationService;
import com.atc.service.VehicleService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-api")
public class EmployeeRestController {

  @Autowired
  StationService stationService;

  @Autowired
  GateService gateService;

  @Autowired
  ClientService clientService;

  @Autowired
  AuthenticationFacade auth;
  
  @Autowired
  RoadService roadService;
  
  @Autowired
  HistoryService historyService;
  
  @Autowired
  VehicleService vehicleService;

  @GetMapping("/get-roads")
  public ResponseEntity<List<Road>> getRoads() {
	List<Road> roads = roadService.findAll();
	return ResponseEntity.ok().body(roads);
  }
  
  @GetMapping("/get-stations")
  public ResponseEntity<List<Station>> getStations() {
	List<Station> stations = stationService.findAll();
	return ResponseEntity.ok().body(stations);
  }

  @GetMapping("/get-gates/entry/by-station/{id}")
  public ResponseEntity<List<Gate>> getEntryGatesByStationId(@PathVariable("id") String id) {
	List<Gate> gates = gateService.findEntryGatesByStationId(id);
	return ResponseEntity.ok().body(gates);
  }

  @GetMapping("/add-to-gate/{id}")
  public ResponseEntity<Boolean> addEmployeeToGate(@PathVariable("id") String id, Authentication authentication) {
	MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
	Employee employee = (Employee) principal.getUser();
	return ResponseEntity.ok().body(gateService.addEmployee(id, employee));
  }

  @GetMapping("/remove-from-gate/{id}")
  public ResponseEntity<Boolean> removeEmployeeFromGate(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("------->  REMOVE EMPLOYEE FROM GATE " + id);
	Authentication authentication = auth.getAuthentication();
	if (authentication != null) {
	  new SecurityContextLogoutHandler().logout(request, response, authentication);
	}
	gateService.removeEmployeeFromGate(id);
	return ResponseEntity.ok().body(true);
  }
  
  @GetMapping("/get-distance-from-history-id/{id}")
  public ResponseEntity<String> getDistance(@PathVariable("id") String id){
	String distance = historyService.getDistance(id).toString();
	System.out.println("------> Distance: " + distance);
	return ResponseEntity.ok().body(distance);
	
  }

  @GetMapping("/get-vehicle-types")
  public ResponseEntity<List<String>> getVehicleNames(){
	return ResponseEntity.ok().body(vehicleService.findAllVehicleNames());
  }
  
  @GetMapping("/get-price-for-history-id/{id}/vehicle/{vehicle}")
  public ResponseEntity<Double> getPrice(@PathVariable("id") String historyId, @PathVariable("vehicle") Vehicle vehicle){
	return ResponseEntity.ok().body(historyService.getPrice(historyId, vehicle));
  }
  
  @GetMapping("/pay/history/{h}/price/{p}/vehicle/{v}")
  public ResponseEntity<Boolean> pay(@PathVariable("h") String historyId, @PathVariable("p") Double price, @PathVariable("v") Vehicle vehicle){
	Boolean b = historyService.updateCostAndVehicle(historyId, price, vehicle);
	return ResponseEntity.ok().body(b);
  }
  
 @GetMapping("/get-username")
  public ResponseEntity<List<String>> getUsername() {
	List<Client> clients = clientService.findAll();
        List<String> clientsUsernames= new ArrayList();
        for(int i=0;i<clients.size();i++){
            clientsUsernames.add(clients.get(i).getUsername());
        }
	return ResponseEntity.ok().body(clientsUsernames);
  }
  
}
