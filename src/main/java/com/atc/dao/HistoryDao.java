package com.atc.dao;

import com.atc.entity.History;

public interface HistoryDao {

  public boolean addToHistory(History history);

  public History findById(Integer id);

  void update(History history);

}
