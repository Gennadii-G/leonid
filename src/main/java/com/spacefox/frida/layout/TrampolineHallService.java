package com.spacefox.frida.layout;



import com.spacefox.frida.domain.TrampolineHall;

import java.util.List;


public interface TrampolineHallService {

    public List<TrampolineHall> getAll();

    public TrampolineHall getByName(String name);
}
