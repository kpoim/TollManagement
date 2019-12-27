package com.atc.service;

import com.atc.entity.Ongoing;

public interface OngoingService {

  Ongoing findOngoingByCardId(String cardid);

  public Ongoing newEntry(String id);

  public void delete(Ongoing ongoing);

}