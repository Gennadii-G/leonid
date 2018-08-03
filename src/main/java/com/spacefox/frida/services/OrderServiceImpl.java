package com.spacefox.frida.services;

import com.spacefox.frida.domain.*;
import com.spacefox.frida.domain.DTO.OrderCreateDTO;
import com.spacefox.frida.domain.DTO.OrderDTO;
import com.spacefox.frida.repository.OrderRepository;
import com.spacefox.frida.utils.PriceCalculator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
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
            repository.save(order);
        }
    }

    @Transactional
    @Override
    public void createOrder(OrderCreateDTO dto) {
        TrampolineHall hall = hallService.getById(dto.getHall());
        Discount discount = discountService.getById(dto.getDiscount());
        User employee = userService.getSU();
        Customer customer = customerService.getById(dto.getCustomer());
        dto.setEventDate(dto.getBookingFrom().toLocalDate());
        validate(dto, hall);
        validate(dto, discount);

        Order order = Order.builder()
                .regDate(LocalDate.now())
                .eventDate(dto.getEventDate())
                .trampsAmount(dto.getTrampsAmount())
                .bookingFrom(dto.getBookingFrom()).bookingTo(dto.getBookingTo())
                .comment("comment")
                .discount(discount)
                .employee(employee)
                .hall(hall)
                .customer(customer)
                .build();

        calculatePrice(order);
        repository.save(order);
    }

    private void validate(OrderCreateDTO dto, TrampolineHall hall) {
        if(!hallService.hasEnoughTramps(dto.getBookingFrom(), dto.getBookingTo(), dto.getTrampsAmount(), hall)) {
            throw new ValidationException("недостаточно свободных батутов на указанное время");
        }
    }

    private void validate(OrderCreateDTO dto, Discount discount){
        if(!discountService.availableDiscounts(LocalDate.now()).contains(discount)){
            throw new ValidationException("указанная акция в данный момент не активна");
        }
    }

    @Override
    public List<Order> getByHallandDate(TrampolineHall hall, LocalDate date) {
        return repository.findOrdersForDateAndHall(date, hall.getId());
    }

    @Override
    public boolean hasIntersection(Order order, LocalDateTime from, LocalDateTime to) {
        boolean result = true;

        System.out.println("sostoianie");
        System.out.println(order.getBookingFrom().isAfter(to) || order.getBookingTo().isBefore(from));

        if(order.getBookingFrom().isAfter(to) || order.getBookingTo().isBefore(from)) {
            result = false;
        }

        return result;
    }

    @Override
    public void calculatePrice(Order order) {
        PriceCalculator.calculate(order);
    }

    @Override
    public List<Order> getByHall(TrampolineHall hall) {
        List<Order> orders = repository.findByHall(hall);
        return orders;
    }
}