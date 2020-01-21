
package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.Terminal;
import java.util.List;


public interface TerminalService {
    
    void addOrUpdate(Terminal t);
    
    Terminal findByGateId(Gate g);
    
    void delete(Terminal t); 

    public Terminal findByUsername(String username);

    public List<Terminal> findAll();

    public List<Terminal> findByTerminal(String search);

}
