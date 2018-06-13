package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
