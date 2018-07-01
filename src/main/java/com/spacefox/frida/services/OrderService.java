package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.OrderDTO;
import com.spacefox.frida.domain.Order;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> getAll();

    void save(Order order);

    void save(OrderDTO orderDTO);

    Order getOrder(OrderDTO orderDTO);

    OrderDTO getDTO(Order order);

    List<OrderDTO> getDTO(List<Order> orders);

    void saveWithRegDate(Order order);

    Order getById(Long id);

    void delete(Long id);

    void delete(OrderDTO dto);

    List<OrderDTO> findByDate(Date date);

    void update(OrderDTO dto);
}
