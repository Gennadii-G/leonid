package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findByName(String name);
}
