package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.repository.DiscountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Discount> getAll() {
        return repository.findAll();
    }

    @Override
    public Discount getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(Discount discount) {
        repository.save(discount);
    }

    @Override
    public void save(DiscountDTO dto) {
        repository.save(mapper.map(dto, Discount.class));
    }

    @Override
    public Discount getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(DiscountDTO dto) {
        Discount discount = mapper.map(dto, Discount.class);
        if(repository.existsById(discount.getId())){
            repository.delete(discount);
        }
    }

    @Override
    public DiscountDTO getDTO(Discount discount) {
        return mapper.map(discount, DiscountDTO.class);
    }

    @Override
    public List<DiscountDTO> getDTO(List<Discount> discounts) {
        return discounts.stream().map(this::getDTO).collect(Collectors.toList());
    }

    @Override
    public void update(DiscountDTO dto) {
        Discount discount = mapper.map(dto, Discount.class);
        if(repository.existsById(discount.getId())){
            repository.save(discount);
        }
    }
}
