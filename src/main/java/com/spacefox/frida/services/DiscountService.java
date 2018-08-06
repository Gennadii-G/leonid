package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.domain.Discount;

import java.time.LocalDate;
import java.util.List;

public interface DiscountService {

    List<Discount> getAll();

    List<DiscountDTO> availableDiscounts();

    Discount getByName(String name);

    Discount save(Discount discount);

    Discount getById(Long id);

    void delete(DiscountDTO dto);

    void delete(Long id);

    DiscountDTO convert(Discount discount);

    Discount convert(DiscountDTO dto);

    List<DiscountDTO> convert(List<Discount> discounts);

    void update(DiscountDTO dto);

    List<Discount> availableDiscounts(LocalDate date);

    long discountCount();

    boolean exist(Long id);
}
