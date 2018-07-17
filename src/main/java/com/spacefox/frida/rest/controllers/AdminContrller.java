package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.TestDataDTO;
import com.spacefox.frida.utils.TestDataCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminContrller {

    @Autowired
    private TestDataCreator dataCreator;

    @PostMapping("/admin/createtestdata/tendiscounts")
    @ResponseStatus(HttpStatus.OK)
    public void createTenDiscounts(){
        dataCreator.createDiscounts(10);
    }

    @PostMapping("/admin/createtestdata/tentrampolines")
    @ResponseStatus(HttpStatus.OK)
    public void createTenTrampolines(){
        dataCreator.createTrampolines(10);
    }

    @PostMapping("/admin/createtestdata/tenhalls")
    @ResponseStatus(HttpStatus.OK)
    public void createDiscounts(){
        dataCreator.createTrampolineHalls(10);
    }

    @PostMapping("/admin/createtestdata")
    @ResponseStatus(HttpStatus.OK)
    public void createDiscounts(TestDataDTO dto){
        dataCreator.createDiscounts(dto.getDiscountAmount());
        dataCreator.createTrampolines(dto.getTrampolinesAmount());
        dataCreator.createTrampolineHalls(dto.getHallsAmount());
        dataCreator.createOrdersForLastMonth(dto.getOrdersAmount());
    }
}
