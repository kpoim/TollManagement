
package com.atc.entity;

import javax.validation.Valid;


public class WrapperGateTerminal {
    @Valid
    private Gate gate;
    @Valid
    private Terminal terminal;
    
    public WrapperGateTerminal(){
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return "WrapperGateTerminal{" + "gate=" + gate + ", terminal=" + terminal + '}';
    }
    
    
}
