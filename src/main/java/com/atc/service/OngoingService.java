package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.Ongoing;

public interface OngoingService {

  Ongoing findOngoingByCardId(String cardid);

  public Ongoing newEntry(String cardId, Gate gate);

  public void delete(Ongoing ongoing);

}
