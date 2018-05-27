package com.spacefox.frida.layout;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;

import java.util.List;

public interface DiscountService {

    public List<Discount> getAll();

    public Discount getByName(String name);

}
