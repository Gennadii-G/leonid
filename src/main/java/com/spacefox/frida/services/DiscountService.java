package com.spacefox.frida.services;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;

import java.util.List;

public interface DiscountService {

    public List<Discount> getAll();

    public Discount getByName(String name);

    public void save(Discount disc);

}
