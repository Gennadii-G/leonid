package com.spacefox.frida.utils.builders;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;


public class TrampolineHallBuilder {

    private TrampolineHall hall = new TrampolineHall();

    public TrampolineHall create(){
        return hall;
    }

    public TrampolineHallBuilder newHall() {
        hall = new TrampolineHall();
        return this;
    }

    public TrampolineHallBuilder fillHall(TrampolineHall hall){
        this.hall = hall;
        return this;
    }

    public TrampolineHallBuilder newHall(String name){
        hall = new TrampolineHall();
        hall.setName(name);
        return this;
    }

    public TrampolineHallBuilder withAddress(String address){
        hall.setAddress(address);
        return this;
    }

    public TrampolineHallBuilder withName(String name){
        hall.setName(name);
        return this;
    }

    public TrampolineHallBuilder withPrice(int price){
        hall.setPrice(price);
        return this;
    }

    public TrampolineHallBuilder withTramps(int trampsAmount, TrampolineType type){
        hall.getTrampolines().addAll(TrampolineBuilder.create(trampsAmount, type));
        return this;
    }

    public static TrampolineHall emptyHall(){
        return new TrampolineHall();
    }
}
