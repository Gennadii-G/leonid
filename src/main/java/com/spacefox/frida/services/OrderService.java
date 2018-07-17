package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.OrderCreateDTO;
import com.spacefox.frida.domain.DTO.OrderDTO;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.TrampolineHall;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    List<Order> findByDate(LocalDate date);

    void update(OrderDTO dto);

    void createOrder(OrderCreateDTO dto);

    List<Order> getByHallandDate(TrampolineHall hall, LocalDate date);

    boolean hasIntersection(Order order, LocalDateTime from, LocalDateTime to);
}
