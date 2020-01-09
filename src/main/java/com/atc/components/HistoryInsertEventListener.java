package com.atc.components;

import com.atc.entity.History;
import com.atc.service.SsePushNotificationService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryInsertEventListener implements PostInsertEventListener {

  @Autowired
  EntityManagerFactory emf;
  
  @Autowired
  SsePushNotificationService SseService;

  @PostConstruct
  private void init() {
	SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
	EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
	registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(this);
  }

  @Override
  public void onPostInsert(PostInsertEvent event) {
	final Object entity = event.getEntity();

	System.out.print("\n\n------------->JUST INSERTED A NEW ENTRY\n    ");
	if (entity instanceof History) {
	  History history = (History) entity;
	  System.out.print("ITS A NEW HISTORY ENTRY\n    ");
	  System.out.println(history);
	  System.out.println("\n\n");
	  try {
		System.out.println("---> TRYING TO SEND");
		SseService.doNotify(history.getExitgateid().getId(), history);
		System.out.println("---> SENT");
	  } catch (IOException ex) {
		System.out.println("---> COULDNT SEND");
		SseService.removeEmitter(history.getExitgateid().getId());
		Logger.getLogger(HistoryInsertEventListener.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
  }

  @Override
  public boolean requiresPostCommitHanding(EntityPersister ep) {
	return false;
  }
}
