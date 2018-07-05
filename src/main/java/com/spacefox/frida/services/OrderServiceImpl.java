package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.OrderDTO;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.repository.OrderRepository;
import com.spacefox.frida.utils.DateFormatterJH;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ModelMapper mapper;

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
        order.setRegDate(LocalDate.now());
        save(order);
    }

    @Override
    public Order getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        Order order = mapper.map(orderDTO, Order.class);
        save(order);
    }

    @Override
    public Order getOrder(OrderDTO orderDTO) {
        return mapper.map(orderDTO, Order.class);
    }

    @Override
    public OrderDTO getDTO(Order order) {
        return mapper.map(order, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getDTO(List<Order> orders) {
        return orders.stream().map(this::getDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(OrderDTO dto) {
        Order order = mapper.map(dto, Order.class);
        if(repository.existsById(order.getId())){
            repository.delete(order);
        }
    }

    @Override
    public List<OrderDTO> findByDate(Date date) {
        return null;
    }

    @Override
    public void update(OrderDTO dto) {
        Order order = mapper.map(dto, Order.class);
        if(repository.existsById(order.getId())){
            repository.delete(order);
        }
    }
}
