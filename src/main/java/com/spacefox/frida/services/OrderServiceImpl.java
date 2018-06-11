package com.spacefox.frida.services;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.repository.OrderRepository;
import com.spacefox.frida.utils.DateFormatterJH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public void saveWithRegDate(Order order) {
        order.setRegDate(new Date());
        save(order);
    }
}
