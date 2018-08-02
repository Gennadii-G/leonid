package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.OrderCreateDTO;
import com.spacefox.frida.domain.DTO.OrderDTO;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @DeleteMapping("/order/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(OrderDTO dto){
        orderService.delete(dto);
    }

    @GetMapping("/orders")
    public List<OrderDTO> allOrders(){
        List<Order> orders = orderService.getAll();
        return orderService.getDTO(orders);
    }

    @GetMapping("/order/date")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> allOrdersForDate(Date date) {
        List<Order> dtos = orderService.findByDate(LocalDate.now());
        return orderService.getDTO(dtos);
    }

    @PostMapping("/order/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@RequestBody @Valid OrderDTO dto) {
        orderService.save(dto);
    }

    @PostMapping("/order/add/neworder")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@RequestBody @Valid OrderCreateDTO dto) {
        orderService.createOrder(dto);
    }

    @GetMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO orderById(@PathVariable Long id){
        return orderService.getDTO(orderService.getById(id));
    }

    @PutMapping("/order/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@RequestBody @Valid OrderDTO dto){
        orderService.update(dto);
    }

}
