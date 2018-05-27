package com.spacefox.frida.utils;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.layout.DiscountService;
import com.spacefox.frida.layout.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderHandler {

    private TrampolineHallService hallService;
    private DiscountService discountService;

    @Autowired
    public OrderHandler(TrampolineHallService hallService, DiscountService discountService) {
        this.hallService = hallService;
        this.discountService = discountService;
    }

    public void handle(Order order) {
        validateOrder(order);
        calcPrice(order);
        saveOrder(order);
    }

    private void validateOrder(Order order){

    }

    private void calcPrice(Order order){
        TrampolineHall hall = hallService.getByName(order.getHallId());
        float price = hall.getPrice();
        Discount disc = discountService.getByName(order.getDiscountId());
        if(disc.getDiscountFactor() > 0){
            price = calculateDesc(price, disc.getDiscountFactor());
        }
        int finalPrice = (int) calcFinalPrice(order.getMinuteAmount(), price);

        order.setPrice(finalPrice);
    }

    private void saveOrder(Order order) {
        TrampolineHall hall = hallService.getByName(order.getHallId());
        order.setRegDate(new Date());
        hall.orderTramp(order);

    }

    private float calculateDesc(float fullPrice, int factor){
        return  ((fullPrice / 100) * (100 - factor));
    }

    private float calcFinalPrice(int minuteAmount, float price) {
        return minuteAmount * (price / 60);
    }
}
