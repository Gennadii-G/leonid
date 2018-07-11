package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;

import java.io.DataInput;
import java.time.LocalDate;
import java.util.List;

public interface DiscountService {

    List<Discount> getAll();

    List<DiscountDTO> availableDiscounts();

    Discount getByName(String name);

    void save(Discount disc);

    void save(DiscountDTO dto);

    Discount getById(Long id);

    void delete(DiscountDTO dto);

    DiscountDTO getDTO(Discount discount);

    List<DiscountDTO> getDTO(List<Discount> discounts);

    void update(DiscountDTO dto);

    List<Discount> availableDiscounts(LocalDate date);
}
