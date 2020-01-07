package com.atc.service;

import com.atc.entity.History;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@Transactional
//@EnableScheduling
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
//  @Scheduled(fixedRate = 5000)
  public void doNotify(Integer gateid, History historyObject) throws IOException {
	SseEmitter emitter = emitters.get(gateid);
	try {
	  emitter.send(SseEmitter.event().data(historyObject));
//	  emitter.send(SseEmitter.event()
//		  .data(DATE_FORMATTER.format(new Date()) + " : " + UUID.randomUUID().toString()));
	} catch (IOException e) {
	  emitters.remove(gateid);
	}
  }
}
