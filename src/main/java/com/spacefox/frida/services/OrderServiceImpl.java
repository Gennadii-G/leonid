package com.spacefox.frida.services;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }
}
