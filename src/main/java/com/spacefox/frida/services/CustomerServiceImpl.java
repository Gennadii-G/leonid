package com.spacefox.frida.services;

import com.spacefox.frida.domain.Customer;
import com.spacefox.frida.domain.DTO.CustomerDTO;
import com.spacefox.frida.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        customer.setId(null);
        return repository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        if (repository.existsById(customer.getId())) {
            repository.save(customer);
        }
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void delete(Customer customer) {
        if (repository.existsById(customer.getId())) {
            repository.delete(customer);
        }
    }

    @Override
    public Customer getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public CustomerDTO convert(Customer customer) {
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public Customer convert(CustomerDTO dto) {
        return mapper.map(dto, Customer.class);
    }

    @Override
    public List<CustomerDTO> convert(List<Customer> customers) {
        return customers.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public long customersCount() {
        return repository.count();
    }

    @Override
    public boolean exist(Long id) {
        return repository.existsById(id);
    }
}
