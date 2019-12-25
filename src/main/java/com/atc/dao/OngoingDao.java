package com.atc.dao;

import com.atc.entity.Ongoing;

public interface OngoingDao {
  
  Ongoing findOngoingByCardId(Integer cardid);

  public boolean newEntry(Ongoing ongoing);

  public void delete(Ongoing ongoing);
  
}
