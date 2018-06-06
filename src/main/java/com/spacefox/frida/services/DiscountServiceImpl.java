package com.spacefox.frida.services;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository repository;

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
}
