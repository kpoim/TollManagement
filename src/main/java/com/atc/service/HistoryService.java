package com.atc.service;

import com.atc.entity.History;
import com.atc.entity.Ongoing;

public interface HistoryService {

  History addToHistory(Ongoing ongoing, String exitGateId);

}
