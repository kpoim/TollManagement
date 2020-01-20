package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.History;

public interface PassageService {

  History processCard(String id);

  Gate extractGateFromTerminal(String id);
  
}
