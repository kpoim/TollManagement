
package com.atc.dao;

import com.atc.entity.Terminal;
import org.springframework.stereotype.Repository;

@Repository
public class TerminalDaoImpl extends SuperDao implements TerminalDao{

    @Override
    public void addOrUpdate(Terminal t) {
        getSession().saveOrUpdate(t);
    }
    
     
}
