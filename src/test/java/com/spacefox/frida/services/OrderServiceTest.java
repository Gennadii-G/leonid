package com.spacefox.frida.services;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.TrampolineHall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

    private static final int FACTOR = 20;
    private static final int PRICE = 1000;

    @Mock
    private TrampolineHall hall;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testCalculatePrice() {

        Mockito.when(hall.getPrice()).thenReturn(PRICE);

        Discount discount = Discount.builder().discountFactor(FACTOR).build();

        LocalDateTime from = LocalDateTime
                .of(2000, 12, 12, 12, 12);
        Order order = Order.builder()
                .hall(hall)
                .discount(discount)
                .bookingFrom(from)
                .bookingTo(from.plusMinutes(8))
                .trampsAmount(3)
                .build();
        orderService.calculatePrice(order);

        assertEquals(2400, order.getPrice());
        order.setTrampsAmount(1);
        orderService.calculatePrice(order);
        assertEquals(800, order.getPrice());
        order.setDiscount(null);
        orderService.calculatePrice(order);
        assertEquals(1000, order.getPrice());
        order.setBookingTo(from.plusHours(1).plusMinutes(5));
        orderService.calculatePrice(order);
        assertEquals(2000, order.getPrice());
    }
}
