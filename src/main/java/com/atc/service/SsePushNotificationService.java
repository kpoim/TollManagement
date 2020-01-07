package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.History;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@Transactional
public class SsePushNotificationService {

  final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
  final Map<Integer, SseEmitter> emitters = new HashMap();

  public void addEmitter(Integer gateid, final SseEmitter emitter) {
	emitters.put(gateid, emitter);
  }

  public void removeEmitter(Integer gateid) {
	emitters.remove(gateid);
  }

  @Async
  public void doNotify(Integer gate, History historyObject) throws IOException {
	System.out.println("SSESERVICE gateid: " + gate);
	System.out.println(historyObject);
	SseEmitter emitter = emitters.get(gate);
	System.out.println("EMITTER: "+emitter);
	try {
	  emitter.send(SseEmitter.event().data(historyObject));
	  System.out.println("SENTTTTTTTTTTTTTT");
	} catch (IOException e) {
	  emitters.remove(gate);
	}
  }
}
