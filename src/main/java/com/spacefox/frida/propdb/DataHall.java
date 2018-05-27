package com.spacefox.frida.propdb;

import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.PostConstruct;

@Component
public class DataHall {
    private PropertiesConfiguration props;
    private List<TrampolineHall> halls;
    private List<Trampoline> tramps;
    private int hallsAmount;
    private int trampsAmount;

    public DataHall() throws ConfigurationException {
        props = new PropertiesConfiguration("vata.properties");
        init();
    }

//    @PostConstruct
    private void init(){
        hallsAmount = props.getInt("halls.amount");
        halls = new ArrayList<>();

        for(int i=1; i < hallsAmount+1; i++){
            trampsAmount = props.getInt(i + ".hall.trampoline.amount");
            TrampolineHall tHall = new TrampolineHall();
            tHall.setName(props.getString(i + ".hall.name"));
            tHall.setPrice(props.getInt(i + ".hall.price"));
            tHall.setTramlins(loadTrompalines());
            halls.add(tHall);
        }
    }

    private List<Trampoline> loadTrompalines(){
        tramps = new ArrayList<>();
        while (tramps.size() < trampsAmount+1){
            tramps.add(new Trampoline());
        }
       return tramps;
    }

    public List<TrampolineHall> getHalls() {
        return halls;
    }
}
