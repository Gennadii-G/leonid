package com.spacefox.frida.utils;

import com.spacefox.frida.domain.Order;

public class PriceCalculator {

    public static void calculate(Order order){
        int price = 0;
        int hoursAmount = (order.getBookingTo().getHour() + 1) - order.getBookingFrom().getHour();
        int hallPrice = order.getHall().getPrice();
        price = hoursAmount * (hallPrice * order.getTrampsAmount());
        if(order.getDiscount() != null){
            price -= (price * order.getDiscount().getDiscountFactor()) / 100;
        }
        order.setPrice(price);
    }
}
