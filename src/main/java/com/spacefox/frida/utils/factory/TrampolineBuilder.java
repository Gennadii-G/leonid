package com.spacefox.frida.utils.factory;

import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.catalogs.TrampolineType;

import java.util.ArrayList;
import java.util.List;

public class TrampolineBuilder {

    public static List<Trampoline> create(int trampsAmount, TrampolineType type) {
        List<Trampoline> tramps = new ArrayList<>();
        for(int i = 0; i < trampsAmount; i++){
            tramps.add(new Trampoline(type));
        }
        return tramps;
    }

    public static List<Trampoline> create(int trampsAmount) {
        return create(trampsAmount, TrampolineType.NORMAL);
    }
}
