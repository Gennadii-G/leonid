package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository repository;
    @Autowired
    private ConversionService conversionService;


    @Override
    public List<Discount> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiscountDTO> availableDiscounts() {
        return repository
                .findAvailableDiscounts(LocalDate.now())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<Discount> availableDiscounts(LocalDate date) {
        List<Discount> list = getAll();
        list = list.stream().filter(discount -> {
            return discount.getStartAvailability().isBefore(date) &&
                    discount.getEndAvailability().isAfter(date);
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public Discount getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(Discount discount) {
        if(discount.getId() != null){
            discount.setId(null);
        }
        repository.save(discount);
    }

    @Override
    public Discount getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(DiscountDTO dto) {
        Discount discount = conversionService.convert(dto, Discount.class);
        if(repository.existsById(discount.getId())){
            repository.delete(discount);
        }
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public DiscountDTO convert(Discount discount) {
        return conversionService.convert(discount, DiscountDTO.class);
    }

    @Override
    public Discount convert(DiscountDTO dto) {
        return conversionService.convert(dto, Discount.class);
    }

    @Override
    public List<DiscountDTO> convert(List<Discount> discounts) {
        return discounts.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public void update(DiscountDTO dto) {
        Discount discount = conversionService.convert(dto, Discount.class);
        if(repository.existsById(discount.getId())){
            repository.save(discount);
        }
    }

    @Override
    public long discountCount() {
        return repository.count();
    }
}
