package com.spacefox.frida.services;

import com.spacefox.frida.domain.*;
import com.spacefox.frida.domain.DTO.CreateOrderDTO;
import com.spacefox.frida.domain.DTO.OrderDTO;
import com.spacefox.frida.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private TrampolineHallService hallService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

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

//    todo
    @Override
    public List<Order> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public void update(OrderDTO dto) {
        Order order = mapper.map(dto, Order.class);
        if(repository.existsById(order.getId())){
            repository.delete(order);
        }
    }

    @Override
    public void createOrder(CreateOrderDTO dto) {
        TrampolineHall hall = hallService.getById(dto.getHall());
        Discount discount = discountService.getById(dto.getDiscount());
        User employee = userService.getSU();
        Customer customer = customerService.getById(dto.getCustomer());
        validate(dto);

        Order order = Order.builder()
                .regDate(LocalDate.now())
                .bookingFrom(dto.getBookingFrom()).bookingTo(dto.getBookingTo())
                .comment("comment")
                .discount(discount).employee(employee).hall(hall).customer(customer)
                .build();
        repository.save(order);
    }

    private void validate(CreateOrderDTO dto){
        if(dto.getBookingTo().getDayOfYear() != dto.getBookingFrom().getDayOfYear()){
            throw new ValidationException();
        }
    }

    @Override
    public List<Order> getByHallandDate(TrampolineHall hall, LocalDate date) {
        return repository.findOrdersForDateAndHall(date, hall);
    }

    @Override
    public boolean hasIntersection(Order order, LocalDateTime from, LocalDateTime to) {
        boolean result = false;
        Duration orderDuration = Duration.between(order.getBookingFrom(), order.getBookingTo());
        Duration duration = Duration.between(from, to);

        duration.compareTo(orderDuration);

        return result;
    }
}