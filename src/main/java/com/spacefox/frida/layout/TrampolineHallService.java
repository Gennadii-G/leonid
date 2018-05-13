package com.spacefox.frida.layout;



import com.spacefox.frida.domain.TrampolineHall;

import java.util.Set;


public interface TrampolineHallService {

    public Set<TrampolineHall> getAll();

    public TrampolineHall getByName(String name);
}
