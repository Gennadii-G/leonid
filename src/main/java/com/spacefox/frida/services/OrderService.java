package com.spacefox.frida.services;

import com.spacefox.frida.domain.Order;
import java.util.List;

public interface OrderService {

    public List<Order> getAll();

    public Order getByName(String name);

    public void save(Order order);

}
