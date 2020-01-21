
package com.atc.dao;

import com.atc.entity.Gate;
import com.atc.entity.Terminal;
import java.util.List;


public interface TerminalDao {
    
    public void addOrUpdate(Terminal t);
    
    public void delete(Terminal t);

    public Terminal findByGateId(Gate g);

    public Terminal findByUsername(String username);

    public List<Terminal> findAll();

    public List<Terminal> findByTerminal(String search);

}
