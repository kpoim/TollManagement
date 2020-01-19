
package com.atc.service;

import com.atc.entity.Gate;
import com.atc.entity.Terminal;


public interface TerminalService {
    
    void addOrUpdate(Terminal t);
    
    Terminal findByGateId(Gate g);
    
    void delete(Terminal t); 

    public Terminal findByUsername(String username);

}
