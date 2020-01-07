package com.atc.controller;

import com.atc.service.SsePushNotificationService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = "*")
public class SsePushNotificationRestController {

  @Autowired
  SsePushNotificationService service;

  final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

  @GetMapping("/{id}")
  public ResponseEntity<SseEmitter> doNotify(@PathVariable("id") Integer id){// throws InterruptedException, IOException {
	final SseEmitter emitter = new SseEmitter(36000000L);
	System.out.println("------> REGISTERING EMITTER");
	service.addEmitter(id, emitter);
	System.out.println("------> EMITTER REGISTERED");
//	service.doNotify();
	emitter.onCompletion(() -> service.removeEmitter(id));
	emitter.onTimeout(() -> service.removeEmitter(id));
	return new ResponseEntity<>(emitter, HttpStatus.OK);
  }

}
