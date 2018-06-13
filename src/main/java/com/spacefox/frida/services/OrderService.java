package com.spacefox.frida.services;

import com.spacefox.frida.domain.Order;
import java.util.List;

public interface OrderService {

    List<Order> getAll();

    void save(Order order);

    void saveWithRegDate(Order order);

    Order getById(Long id);

    void delete(Long id);
}
