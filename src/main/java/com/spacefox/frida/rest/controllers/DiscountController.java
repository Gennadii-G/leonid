package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @DeleteMapping("/discount/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDiscount(DiscountDTO dto){
        discountService.delete(dto);
    }

    @GetMapping("/discounts")
    public List<DiscountDTO> allDiscounts() {
        return discountService.getDTO(discountService.getAll());
    }

    @PostMapping("/discount/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDiscount(@Valid DiscountDTO dto) {
        discountService.save(dto);
    }

    @GetMapping("/discount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DiscountDTO discountById(@PathVariable Long id) {
        return discountService.getDTO(discountService.getById(id));
    }

    @PutMapping("/picture/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updateDiscount(DiscountDTO dto){
        discountService.update(dto);
    }

}
