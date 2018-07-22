package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.TestDataDTO;
import com.spacefox.frida.utils.TestDataCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminContrller {

    @Autowired
    private TestDataCreator dataCreator;

    @PostMapping("/admin/createtestdata/discounts/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void createDiscounts(@PathVariable Integer amount){
        dataCreator.createDiscounts(amount);
    }

    @PostMapping("/admin/createtestdata/trampolines/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void createTrampolines(@PathVariable Integer amount){
        dataCreator.createTrampolines(amount);
    }

    @PostMapping("/admin/createtestdata/halls/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void createTrampolineHalls(@PathVariable Integer amount){
        dataCreator.createTrampolineHalls(amount);
    }

    @PostMapping("/admin/createtestdata/orders/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void createOrders(@PathVariable Integer amount){
        dataCreator.createOrdersForLastMonth(amount);
    }

    @PostMapping("/admin/createtestdata/contacts/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void createContacts(@PathVariable Integer amount){
        dataCreator.createContacts(amount);
    }

    @PostMapping("/admin/createtestdata/customers/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void createCustomers(@PathVariable Integer amount){
        dataCreator.createCustomers(amount);
    }

//    @PostMapping("/admin/createtestdata")
//    @ResponseStatus(HttpStatus.OK)
    public void createDiscounts(TestDataDTO dto){
        dataCreator.createDiscounts(dto.getDiscountAmount());
        dataCreator.createTrampolines(dto.getTrampolinesAmount());
        dataCreator.createTrampolineHalls(dto.getHallsAmount());
        dataCreator.createOrdersForLastMonth(dto.getOrdersAmount());
    }
}
