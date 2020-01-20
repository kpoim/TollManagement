package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.Ongoing;

public interface OngoingService {

  Ongoing findOngoingByCardId(String cardid);

  Ongoing newEntry(String cardId, Gate gate);

  void delete(Ongoing ongoing);

}
