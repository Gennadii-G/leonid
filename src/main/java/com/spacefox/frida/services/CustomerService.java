package com.spacefox.frida.services;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.Customer;
import com.spacefox.frida.domain.DTO.ContactDTO;
import com.spacefox.frida.domain.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<Contact> getAll();

    void save(Customer customer);

    void update(Customer customer);

    void delete(long id);

    void delete(Customer customer);

    Customer getById(long id);

    CustomerDTO getDTO(Customer customer);

    List<CustomerDTO> getDTO(List<Customer> customers);

}