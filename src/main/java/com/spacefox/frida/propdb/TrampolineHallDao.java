package com.spacefox.frida.propdb;


import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.layout.TrampolineHallService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrampolineHallDao implements TrampolineHallService {

    private PropertiesConfiguration props;
    private int hallsAmount;
    private int trampsAmount;
    private List<TrampolineHall> halls;

    public TrampolineHallDao() throws ConfigurationException {
        props = new PropertiesConfiguration("vata.properties");
        init();
    }

    @Override
    public List<TrampolineHall> getAll() {
        return halls;
    }

    @Override
    public TrampolineHall getByName(String name) {
        return halls.stream().filter(h -> h.getName().equals(name)).findFirst().get();
//        halls.stream().filter(h -> h.getName().equals(name)).collect(Collectors.toSet());
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
            tHall.setAddress(props.getString(i + ".hall.address"));
            tHall.setTramlins(loadTrompalines());
            halls.add(tHall);
        }
    }

    private List<Trampoline> loadTrompalines(){
            List<Trampoline> tramps = new ArrayList<>();
        while (tramps.size() < trampsAmount+1){
            Trampoline tramp = new Trampoline();
            tramp.setId(tramps.size());
            tramp.setBroken(false);
            tramp.setOrdered(false);
            tramps.add(new Trampoline(){
            });
        }
        return tramps;
    }
}
