package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.DateStubDTO;
import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @DeleteMapping("/discount/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDiscount(@PathVariable Long id){
        discountService.delete(id);
    }

    @GetMapping("/discounts")
    public List<DiscountDTO> allDiscounts() {
        return discountService.convert(discountService.getAll());
    }

    @GetMapping("/discounts/available")
    public List<DiscountDTO> allAvailableDiscounts() {
        return discountService.availableDiscounts();
    }

    @GetMapping("/discounts/available/date")
    public List<DiscountDTO> allAvailableDiscountsForDate(DateStubDTO dto) {
        return discountService.convert(discountService.availableDiscounts(dto.getDate()));
    }

    @PostMapping("/discount/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDiscount(@RequestBody @Valid DiscountDTO dto) {
        discountService.save(discountService.convert(dto));
    }

    @GetMapping("/discount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DiscountDTO discountById(@PathVariable Long id) {
        return discountService.convert(discountService.getById(id));
    }

    @PutMapping("/discount/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updateDiscount(@RequestBody @Valid DiscountDTO dto){
        discountService.update(dto);
    }

}
