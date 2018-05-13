package com.spacefox.frida.services;


import com.spacefox.frida.inmemdb.DataHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Shower {

    private DataHall dataHall;

    @Autowired
    public Shower(DataHall dataHall) {
        this.dataHall = dataHall;
    }

    public String showAllHallsInfo(){
        StringBuffer buffer = new StringBuffer();
        dataHall.getHalls().stream().forEach( elt -> {
            buffer.append(elt.toString() + "\n");
        });
        return buffer.toString();
    }
}
