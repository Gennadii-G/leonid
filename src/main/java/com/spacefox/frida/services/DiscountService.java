package com.spacefox.frida.services;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;

import java.util.List;

public interface DiscountService {

    List<Discount> getAll();

    Discount getByName(String name);

    void save(Discount disc);

}
