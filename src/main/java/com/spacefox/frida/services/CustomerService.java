package com.spacefox.frida.services;

import com.spacefox.frida.domain.Customer;
import com.spacefox.frida.domain.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    void save(Customer customer);

    void update(Customer customer);

    void delete(long id);

    void delete(Customer customer);

    Customer getById(long id);

    CustomerDTO convert(Customer customer);

    Customer convert(CustomerDTO dto);

    List<CustomerDTO> convert(List<Customer> customers);

    long customersCount();

}
