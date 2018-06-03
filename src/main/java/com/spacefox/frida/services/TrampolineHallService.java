package com.spacefox.frida.services;



import com.spacefox.frida.domain.TrampolineHall;

import java.util.List;


public interface TrampolineHallService {

    public List<TrampolineHall> getAll();

    public TrampolineHall getByName(String name);

    public void save(TrampolineHall hall);

    public void save(TrampolineHall hall, int trampsAmount);
}
