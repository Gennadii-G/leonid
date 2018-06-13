package com.spacefox.frida.services;

import com.spacefox.frida.domain.TrampolineHall;

import java.util.List;


public interface TrampolineHallService {

    List<TrampolineHall> getAll();

    TrampolineHall getByName(String name);

    void save(TrampolineHall hall);

    void save(TrampolineHall hall, int trampsAmount);
}
